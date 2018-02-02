import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalizeIP {
    public static void main(String[] args) throws IOException {

        Pair<String,String> range = getIPRange();
        printRange(range);
    }

    static Pair<String,String> getIPRange() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("IP from: ");
        String ipBegin = br.readLine();
        System.out.print("IP to: ");
        String ipEnd = br.readLine();

        return new Pair<String,String>(ipBegin,ipEnd);
    }

    static void printRange(Pair<String,String> range){

    }
}
