import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private Connection conn;
    private String flora;

    public DBConnection() {

        try {
            String dbUrl = "jdbc:sqlite:Flora.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                DatabaseMetaData databaseMetaData = conn.getMetaData();
                System.out.println("Connected to " + databaseMetaData.getDatabaseProductName() + " " + databaseMetaData.getDatabaseProductVersion());

                //Creating table
                Statement statement = conn.createStatement();
                String sqlStatement =
                        " CREATE TABLE IF NOT EXISTS Flora" +
                                " (floraID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "latinName TEXT NOT NULL, " +
                                "latvianName TEXT NOT NULL, " +
                                "type TEXT NOT NULL, " +
                                "soil TEXT NOT NULL, " +
                                "light TEXT NOT NULL," +
                                "height TEXT NOT NULL)";

                statement.execute(sqlStatement);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Database issues" + exception);
        }

    }


    public void getConifers () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE type = 'conifers'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("Please see the List of all Conifers in database :");

            Conifers flora = new Conifers();

            while (rs.next()) {
                flora.setFloraID(rs.getInt("floraID"));
                flora.setLatinName(rs.getString("latinName"));
                flora.setLatvianName(rs.getString("latvianName"));
                flora.setType(rs.getString("type"));
                flora.setSoil(rs.getString("soil"));
                flora.setLight(rs.getString("light"));
                flora.setHeight(rs.getInt("height"));

                System.out.println(flora);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting Conifer list: " + exception);
        }
    }

    public void getLeafTree () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE type = 'leafTree'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("Please see the List of all LeafTrees in database :");

            LeafTree flora = new LeafTree();

            while (rs.next()) {
                flora.setFloraID(rs.getInt("floraID"));
                flora.setLatinName(rs.getString("latinName"));
                flora.setLatvianName(rs.getString("latvianName"));
                flora.setType(rs.getString("type"));
                flora.setSoil(rs.getString("soil"));
                flora.setLight(rs.getString("light"));
                flora.setHeight(rs.getInt("height"));

                System.out.println(flora);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting LeafTree list: " + exception);
        }
    }
    public void getPerenials () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE type = 'perenials'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("Please see the List of all Perenials in database :");

            Perenials flora = new Perenials();

            while (rs.next()) {
                flora.setFloraID(rs.getInt("floraID"));
                flora.setLatinName(rs.getString("latinName"));
                flora.setLatvianName(rs.getString("latvianName"));
                flora.setType(rs.getString("type"));
                flora.setSoil(rs.getString("soil"));
                flora.setLight(rs.getString("light"));
                flora.setHeight(rs.getInt("height"));

                System.out.println(flora.toString());
            }

        } catch (SQLException exception) {
            System.out.println("Error getting Perenial list: " + exception);
        }
    }


        // add new plant to database
    public void addNewPlant( Flora flora ) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;
            if (flora instanceof Conifers || flora instanceof Perenials || flora instanceof LeafTree) {
                Conifers conifer = (Conifers) flora;
                sqlStatement = "INSERT INTO flora (" + "latinName, latvianName, type, soil, light, height) " + "VALUES (" +
                        "'" + conifer.getLatinName() + "'," +
                        "'" + conifer.getLatvianName() + "'," +
                        "'" + conifer.getType() + "'," +
                        "'" + conifer.getSoil() + "'," +
                        "'" + conifer.getLight() + "'," +
                        "'" + conifer.getHeight() + "'," +
                        ")";

            } else {

                sqlStatement = "INSERT INTO flora (" +
                        "latinName, latvianName, type, soil, light, height) " +
                        "VALUES (" +
                        "'" + flora.getLatinName() + "'," +
                        "'" + flora.getLatvianName() + "'," +
                        "'" + flora.getType() + "'," +
                        ")";
            }
            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Flora list: " + exception);
        }
    }


}

