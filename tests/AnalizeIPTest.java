import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AnalizeIPTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void getIPContent() {
        AnalizeIP analize = new AnalizeIP();
        int[] ipArray = { 192,168,0,1 };
        assertArrayEquals(ipArray,analize.getIPContent("192.168.0.1"));
    }

    @Test
    public void printRange() {
        AnalizeIP analize = new AnalizeIP();

        Pair<String,String> range = new Pair<String,String>("192.168.0.1","192.168.0.5");
        analize.printRange(range);

        assertEquals("192.168.0.2\n192.168.0.3\n192.168.0.4\n", outContent.toString());
    }
}