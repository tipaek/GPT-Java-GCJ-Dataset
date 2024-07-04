import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static String repeatBrace(int n, char brace) {
        char[] chArr = new char[n];
        Arrays.fill(chArr, brace);
        return new String(chArr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            char[] sArr = in.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            for (char ch : sArr) {
                int val = ch - '0';
                if (val > counter) {
                    int diff = val - counter;
                    sb.append(repeatBrace(diff, '('));
                    counter += diff;
                } else if (val < counter) {
                    int diff = counter - val;
                    sb.append(repeatBrace(diff, ')'));
                    counter -= diff;
                }
                sb.append(ch);
            }
            if (counter > 0) {
                sb.append(repeatBrace(counter, ')'));
            }

            System.out.println(String.format("Case #%s: %s",
                    testCase, sb.toString()));
        }
    }
}