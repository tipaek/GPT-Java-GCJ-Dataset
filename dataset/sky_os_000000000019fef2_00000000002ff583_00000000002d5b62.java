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

    public static String resolve(double a, double b) {
        int max = 0;
        double init = Math.abs(a) + Math.abs(b);
        while (init != 0) {
            if (init < 2) {
                break;
            }
            init = init / 2;
            max++;
        }
        String result = "";
        while (max != -1) {
            if (Math.abs(a) > Math.abs(b)) {
                if (a > 0) {
                    a = a - Math.pow(2, max);
                    result = result + "E";
                } else {
                    a = a + Math.pow(2, max);
                    result = result + "W";

                }
            } else {
                if (b > 0) {
                    b = b - Math.pow(2, max);
                    result = result + "S";
                } else {
                    b = b + Math.pow(2, max);
                    result = result + "N";
                }
            }
            max--;
        }
        if (a == 0 && b == 0) {
            return result;

        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Case #" + testNumber + ": " + resolve(a, b));

            }
        }
    }
}
