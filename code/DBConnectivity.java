import java.sql.*;
import java.util.regex.*;

class DBConnectivity {

  private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
  private final String SERVER_NAME = "localhost";
  private final String DATABASE_NAME = "timetable_management_system";
  private String username = "robyjacob";
  private String passwd = "Root@123";
  private final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + DATABASE_NAME;
  private Connection conn;
  private Statement stmt;
  private ResultSet result_set;

  DBConnectivity() {
    connect();
  }

  DBConnectivity(String name,String password) {
    username = name;
    passwd = password;
  }

  private void connect() {
    try {
      Class.forName(DRIVER_NAME);
      conn = DriverManager.getConnection(URL,username,passwd);
      stmt = conn.createStatement();
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  private boolean validateQuery(String query) {
      if (Pattern.matches("[insert|INSERT|Insert].[into|INTO|Into]..*.[values|Values|VALUES]\\(.*\\)",query)) {
        return true;
      }
      // int match_count = 0;
      // if (query.contains(" ")) {
      //   String first_word = query.substring(0,query.indexOf(" "));
      //   if (first_word == "insert") {
      //     String[] words = query.split(" ");
      //     if (words.length != 4) return false;
      //     for (String word : words) {
      //
      //     }
      //   }
      // } else {
      //   return false;
      // }
      return false;
  }

  public void insert(String query) {
    if (validateQuery(query)) {
      System.out.println("query matched");
    }
  }

}
