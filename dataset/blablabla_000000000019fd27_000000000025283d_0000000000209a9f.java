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

            char last = 'x';
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1' && last != '1') {
                    result.append('(');
                } else if (chars[i] == '0' && last == '1') {
                    result.append(')');
                }

                result.append(chars[i]);

                if (i == chars.length - 1 && chars[i] == '1') {
                    result.append(')');
                }

                last = chars[i];


            }
            System.out.println("Case #" + caseId + ": " + result);
        }
    }
}
