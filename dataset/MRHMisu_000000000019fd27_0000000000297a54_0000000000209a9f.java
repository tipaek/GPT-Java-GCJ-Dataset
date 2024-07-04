import java.util.*;
import java.io.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            String line = scan.next();
            String result = "Case #" + (test_no + 1) + ": " + processPranthesis(line);
            System.out.println(result);
        }
    }

    static String processPranthesis(String line) {
        char[] digits = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        int previous = -1;
        for (int i = 0; i < line.length(); i++) {
            int digit = Integer.parseInt(digits[i] + "");
            if (digit == 0) {
                if (previous == -1) {
                    sb.append(digit);
                } else if (previous == 0) {
                    sb.append(digit);
                } else if (previous == 1) {
                    sb.append(")" + digit);
                }
                previous = digit;
            } else if (digit == 1) {
                if (previous == -1) {
                    sb.append("(" + digit);
                } else if (previous == 0) {
                    sb.append("(" + digit);
                } else if (previous == 1) {
                    sb.append(digit);
                }
                previous = digit;
            }
        }
        if (previous == 1) sb.append(")");
        return sb.toString();

    }
}