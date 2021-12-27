import java.util.Set;

public class Uploader {
    public static void uploadAccount(Account account) {
        DataBaseHandler dbHandler =new DataBaseHandler();
        dbHandler.registrationUser(account);
    }
}
