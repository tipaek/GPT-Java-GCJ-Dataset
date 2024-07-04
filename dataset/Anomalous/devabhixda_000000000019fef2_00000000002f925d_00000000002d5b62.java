import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            String result;

            if (Integer.bitCount(Math.abs(m) + Math.abs(n)) == 1) {
                result = "IMPOSSIBLE";
            } else {
                if (m > 0 && n > 0) {
                    result = "SEN";
                } else if (m > 0 && n < 0) {
                    result = "NES";
                } else if (m < 0 && n > 0) {
                    result = "SWN";
                } else if (m < 0 && n < 0) {
                    result = "NWS";
                } else if (m == 0 && n > 0) {
                    result = "NN";
                } else if (m == 0 && n < 0) {
                    result = "SS";
                } else if (m > 0 && n == 0) {
                    result = "EE";
                } else { // m < 0 && n == 0
                    result = "WW";
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}