import java.io.*;
import java.util.*;

public class Solution {
    static long[] power;
    static int[] rowOffsets = {1, -1, 0, 0};
    static int[] colOffsets = {0, 0, 1, -1};
    static char[] directions = {'S', 'N', 'E', 'W'};
    static boolean isFound;
    static final int NUM = 100;
    static int k = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        k = 1;
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        while (testCases-- > 0) {
            boolean foundCenter = false;
            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    System.out.println(i + " " + j);
                    System.out.flush();
                    String response = scanner.next();
                    if (response.equals("CENTER")) {
                        foundCenter = true;
                        break;
                    }
                }
                if (foundCenter) {
                    break;
                }
            }
            if (foundCenter && testCases == 0) {
                System.exit(0);
            }
        }
    }
}