import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private Connection conn;

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
    public ArrayList<Flora> getFlora(){

        ArrayList<Flora> floraList = new ArrayList<~>();

        try{
        Statement statement = conn.createStatement();
        String sqlStatement = "select * from Flora";
        ResultSet rs = statement.executeQuery(sqlStatement);

        while ( rs.next() ) {

        // add new plant
            Flora flora;
            if (flora instanceof Conifers || flora instanceof Perenials || flora instanceof LeafTrees) {
                Conifers conifer = (Conifers) flora;
                Flora eqlstatement = new Flora();

                Flora flora = new Flora();
                flora.setFloraID(rs.getInt("id"));
                flora.setLatinName(rs.getString("latinName"));
                flora.setLatvianName(rs.getString("latvianName"));
                flora.setType(rs.getString("type"));
                flora.setSoil(rs.getString("soil"));
                flora.setLight(rs.getString("light"));
                flora.setHeight(rs.getInt("height"));
                System.out.println(flora.toString());

            } else {

                sqlStatement = new Flora();
                        "'" + flora.getLatinName() + "'," +
                        "'" + flora.getLatvianName() + "'," +
                        "'" + flora.getType() + "'," +
                        ")";
            }
            statement.execute(sqlStatement);
        }

        } catch (SQLException exception) {
            System.out.println("Error getting Plant list: " + exception);
    }
        return floraList;
    }

    public void createFlora( Flora flora ) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;
            if (flora instanceof Conifers || flora instanceof Perenials || flora instanceof LeafTrees) {
                Conifers conifer = (Conifers) flora;
                sqlStatement = "INSERT INTO flora (" +
                        "latinName, latvianName, type, soil, light, height) " +
                        "VALUES (" +
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

