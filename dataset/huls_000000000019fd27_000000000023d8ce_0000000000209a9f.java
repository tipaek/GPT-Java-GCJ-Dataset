import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Google Code Jam 2020 - Round 0 - Solution B
 *
 * @author : huls
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            char[] digits = in.next().toCharArray();
            //Stack<Integer> stack = new Stack<>();
            int currentDepth = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch : digits) {
                int chVal = Character.getNumericValue(ch);
                if (currentDepth < chVal) {
                    for (int cd = currentDepth; cd < chVal; ++cd) {
                        sb.append('(');
                    }
                } else if (currentDepth > chVal) {
                    for (int cd = currentDepth; cd > chVal; cd--) {
                        sb.append(')');
                    }
                }
                sb.append(ch);

                currentDepth = chVal;
            }
            for (int last = 0; last < currentDepth; ++last) sb.append(')');

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
