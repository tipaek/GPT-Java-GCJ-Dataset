
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            String line = scanner.next();

            StringBuilder result = new StringBuilder();
            char[] chars = line.toCharArray();
            int depth = 0;
            int last = 0;

            for (int i = 0; i < chars.length; i++) {
                int curr = chars[i] - '0';

                if (curr > last) {
                    append(result, '(', curr - last);
                    depth = depth + (curr - last);
                } else if (last > curr) {
                    append(result, ')', last - curr);
                    depth = depth - (last - curr);
                }

                result.append(chars[i]);

                if (i == chars.length - 1) {
                    append(result, ')', depth);
                }

                last = chars[i] - '0';
            }
            System.out.println("Case #" + caseId + ": " + result);
        }

    }

    private static void append(StringBuilder sb, char c, int howMany) {
        for (int i = 0; i < howMany; i++) {
            sb.append(c);
        }
    }
}
