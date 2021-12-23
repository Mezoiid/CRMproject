import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Uploader {
    public static void uploadAccounts(Set<Account> accounts, String fileName) throws IOException {
        FileWriter fileWriter=new FileWriter(fileName);
        for(Account account:accounts){
            fileWriter.write(account.getLogin()+"\n");
            fileWriter.write(account.getPassword()+"\n");
            fileWriter.write(account.getAccessLevel()+"\n");
        }
        fileWriter.close();
    }
}
