import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Downloader {
    public static Set<Account> downloadAccounts(String fileName) throws IOException {
        Set<Account> accounts=new HashSet<>();
        FileReader fileReader=new FileReader(fileName);
        Scanner fin=new Scanner(fileReader);
        String info="";
        int i=3;
        while (fin.hasNextLine()){
            if(i==3) info+=fin.nextLine().toLowerCase(Locale.ROOT).trim()+"\n";
            else info+=fin.nextLine().trim()+"\n";
            if(i!=1)i--;
            else i=3;
        }
        String[] fields=info.split("\n");
        for(int j=0;j<fields.length/3;j++){
            Account account=new Account(fields[j*3],fields[j*3+1],Integer.parseInt(fields[j*3+2]));
            accounts.add(account);
        }
        fileReader.close();
        return accounts;
    }
}
