import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Main {

    public static Scanner sin=new Scanner (System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь фала с аккаунтами");
        String fileName=sin.next();
        Authorization authorization=new Authorization(fileName);
    }
}
