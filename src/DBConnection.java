import java.sql.*;

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
    public void getFlora(){
        try{
        Statement statement = conn.createStatement();
        String sqlStatement = "select * from Flora";
        ResultSet rs = statement.executeQuery(sqlStatement);

    } catch (SQLException exception) {
        exception.printStackTrace();
        System.out.println("Database issues" + exception);
    }
    }
}

