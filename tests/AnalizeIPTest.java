import org.junit.Test;

import static org.junit.Assert.*;

public class AnalizeIPTest {

    @Test
    public void getIPContent() {
        AnalizeIP analize = new AnalizeIP();
        int[] ipArray = { 192,168,0,1 };
        assertArrayEquals(ipArray,analize.getIPContent("192.168.0.1"));
    }
}