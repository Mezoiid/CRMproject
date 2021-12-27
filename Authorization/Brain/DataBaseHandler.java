import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);
        return dbConnection;
    }

    public void registrationUser (Account account) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_LOGIN + "," + Const.USER_PASS + "," + Const.USER_ACCESS_LEVEL + ")" +
                "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, account.getLogin());
            prSt.setString(2, account.getPassword());
            prSt.setString(3, String.valueOf(account.getAccessLevel()));
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet checkAccount(Account account){
        ResultSet resultSet=null;
        String select = "SELECT * FROM "+Const.USER_TABLE+" WHERE "+Const.USER_LOGIN+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, account.getLogin());
            resultSet=prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
