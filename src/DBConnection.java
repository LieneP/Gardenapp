import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    public ArrayList<Flora> getLeafTree () {

        ArrayList<Flora> leafTree = new ArrayList<>();

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
                leafTree.add(flora);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting LeafTree list: " + exception);
        }
        return leafTree;
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

                System.out.println(flora);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting Perenial list: " + exception);
        }
    }

    public void getPerenialSoil () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE soil = 'loam soil' AND type = 'perenials'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("These plants prefer loam soil :");

            Perenials flora = new Perenials();

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
            System.out.println("Error getting soil list: " + exception);
        }
    }
    public void getPerenialLight () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE soil = 'loam soil' AND type = 'perenials' AND light = 'sunny'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("These plants prefer sunny place :");

            Perenials flora = new Perenials();

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
            System.out.println("Error getting light list: " + exception);
        }
    }

    public void getPerenialHeight () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM Flora WHERE soil = 'loam soil' AND type = 'perenials' AND light = 'sunny' AND height > 50";

            ResultSet rs = statement.executeQuery(sqlStatement);

            System.out.println("Willing plant height :");

            Perenials flora = new Perenials();

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
            System.out.println("Error getting exact height: " + exception);
        }
    }
    /*public void createSoilSwitch(Scanner scanner) {
        System.out.println("Enter type of soil. 1 - clay soil, 2 - sandy soil, 3 - clay sand soil, loam soil, peat soil");
        int soilType = scanner.nextInt();
        scanner.nextInt();
    }*/



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

