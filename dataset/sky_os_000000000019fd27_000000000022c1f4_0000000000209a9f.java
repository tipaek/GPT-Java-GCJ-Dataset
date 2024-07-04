
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    public static String addPar(char par, int num) {
        if (num<=0) {
            return "";
        }
        return String.format("%1$-" + num + "s", "").replace(' ', par);

    }

    public static String solve(String str) {
        int curPar = 0;
        String ret = "";
        for (int charactor = 0; charactor < str.length(); charactor++) {
            int value = Integer.parseInt(str.charAt(charactor) + "");
            //close lai
            int minus = curPar - value;
            if (minus > 0) {
                ret += addPar(')', minus);
                curPar -= minus;
            } else if (minus < 0) {
                ret += addPar('(', -minus);
                curPar += -minus;
            }
            ret = ret + value;
        }
        return ret + addPar(')', curPar);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(input));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
