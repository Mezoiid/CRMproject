import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Authorization {
    public Scanner sin=new Scanner (System.in);

    public String signUp() throws SQLException {
        int accessLevel = 0;
        System.out.println("Введите логин");
        String login = sin.nextLine();
        System.out.println("Введите пароль");
        String password = sin.nextLine();
        Account account=new Account(login,password,accessLevel);
        if(containsAccount(account))
        {
            ResultSet resultSet=getAccount(account);
            resultSet.next();
            if(account.getPassword().equals(resultSet.getString("Password"))){
                return "Удачного рабочего дня "+resultSet.getString("AccessLevel")+"!";
            }else {
                return "Неправильный пароль";
            }
        }else
        {
            return "Такого аккаунта нету";
        }
    }

    public boolean registrationAccount() throws SQLException {
        System.out.println("Введите логин");
        String login=sin.nextLine();
        System.out.println("Введите пароль");
        String password=sin.nextLine();
        int accessLevel=0;
        System.out.println("Введите уровень допуска");
        if (sin.hasNextInt())accessLevel=sin.nextInt();
        else {
            System.out.println("Непраильный ввод");
            return false;
        }
        if(accessLevel<1||accessLevel>3)
        {
            System.out.println("Такого уровня допуска нету");
            return false;
        }
        if(containsAccount(new Account(login,password,accessLevel)))
        {
            System.out.println("Такой аккаунт уже есть");
            return false;
        }else
        {
            Uploader.uploadAccount(new Account(login,password,accessLevel));
            return true;
        }
    }

    private ResultSet getAccount(Account account)throws SQLException {
        return Downloader.getAccount(account);
    }

    private boolean containsAccount(Account account) throws SQLException {
        ResultSet resultSet=Downloader.getAccount(account);
        if(resultSet.next())return true;
        return false;
    }
}
