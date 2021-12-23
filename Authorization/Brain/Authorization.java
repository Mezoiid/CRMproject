import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Authorization {
    private Set<Account> accounts;
    public Scanner sin=new Scanner (System.in);

    public Authorization(){
        accounts=new HashSet<>();
    }
    public Authorization(String file) throws IOException {
        accounts= Downloader.downloadAccounts(file);
    }

    public int signUp() {
        int accessLevel = 0;
        System.out.println("Введите логин");
        String login = sin.nextLine();
        System.out.println("Введите пароль");
        String password = sin.nextLine();
        accessLevel = containsAccount(login, password);
        if (accessLevel == 0) {
            System.out.println("Такого аккаунта нету");
        }
        if (accessLevel == -1) {
            System.out.println("Неправильный пароль");
        }
        return accessLevel;
    }

    public boolean registrationAccount()
    {
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
        if(accounts.contains(new Account(login,password,accessLevel)))
        {
            System.out.println("Такой аккаунт уже есть");
            return false;
        }else
        {
            accounts.add(new Account(login,password,accessLevel));
            return true;
        }
    }

    private int containsAccount(String login, String password) {
        for (Account account : accounts)
            if (account.getLogin().equals(login)) {
                if (account.getPassword().equals(password)) return account.getAccessLevel();
                else return -1;
            }
        return 0;
    }

    public void authorizationStop(String fileName) throws IOException {
        Uploader.uploadAccounts(accounts,fileName);
    }
}
