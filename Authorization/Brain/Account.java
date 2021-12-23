import java.util.Locale;

public class Account {
    private String login;
    private String password;
    private int accessLevel;

    public Account(){
        setLogin(null);
        setPassword(null);
        setAccessLevel(1);
    }

    public Account(String login, String password, int accessLevel){
        setLogin(login);
        setPassword(password);
        setAccessLevel(accessLevel);
    }

    public void setLogin(String login) {
        this.login = login.toLowerCase(Locale.ROOT).trim();
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAccessLevel(int accessLevel) {
        if(accessLevel>0&&accessLevel<4)this.accessLevel = accessLevel;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
}
