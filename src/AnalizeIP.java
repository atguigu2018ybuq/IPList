import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AnalizeIP {
    private final static String CONVERT_IP_ERROR="Ошибка в формате IP адресов";
    
    public static void main(String[] args) throws IOException {
        Pair<String,String> range = getIPRange();
        printRange(range);
    }

    private static Pair<String,String> getIPRange() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("IP from: ");
        String ipBegin = br.readLine();
        System.out.print("IP to: ");
        String ipEnd = br.readLine();

        //ipBegin = "192.168.0.1";
        //ipEnd = "192.168.0.5";
        return new Pair<String,String>(ipBegin,ipEnd);
    }

    private static void printRange(Pair<String,String> range){
        int[] fromRangeInt = new int[4];
        int[] toRangeInt = new int[4];
        int i=0;
        try {
            for (String str : range.getKey().split("\\.")) {
                fromRangeInt[i++] = Integer.parseInt(str);
            }
            i = 0;
            for (String str : range.getValue().split("\\.")) {
                toRangeInt[i++] = Integer.parseInt(str);
            }
        }catch(NumberFormatException e){
            System.out.println(CONVERT_IP_ERROR);
        }

        //Ограничение диапазона, ip должен быть в пределах 1-255
        fromRangeInt[3] = Math.max(1,fromRangeInt[3]);
        toRangeInt[3] = Math.min(255,toRangeInt[3]);

        for(int ip3=fromRangeInt[3]+1;ip3<toRangeInt[3];ip3++){
            System.out.println(String.format("%d.%d.%d.%d",fromRangeInt[0],fromRangeInt[1],fromRangeInt[2],ip3));
        }
    }
}
