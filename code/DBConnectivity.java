import java.sql.*;

class DBConnectivity {

  private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
  private final String SERVER_NAME = "localhost";
  private final String DATABASE_NAME = "timetable_management_system";
  private final String USERNAME = "robyjacob";
  private final String PASSWD = "Root@123";
  private final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + DATABASE_NAME;
  private Connection conn;
  private Statement stmt;
  private ResultSet result_set;

  static DBConnectivity() {
    connect();
  }

  private void connect() {
    Class.forName(DRIVER_NAME);
    conn = DriverManager.getConnection(URL,USERNAME,PASSWD);
    stmt = conn.createStatement();
  }

}
