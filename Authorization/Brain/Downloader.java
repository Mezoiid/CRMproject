import java.sql.ResultSet;

public class Downloader {

    public static ResultSet getAccount(Account account){
        DataBaseHandler dataBase=new DataBaseHandler();
        return dataBase.checkAccount(account);
    }
}
