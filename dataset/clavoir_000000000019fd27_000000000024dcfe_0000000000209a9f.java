
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static String compute(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));

            int nOpenBrackets = digit - depth;
            if (nOpenBrackets > 0) {
                for(int j=0; j < nOpenBrackets; j++) {
                    sb.append("(");
                    depth++;
                }
            }

            sb.append(digit);
            if (i + 1 < s.length()) {
                int nClosedBracket = depth - Character.getNumericValue(s.charAt(i+1));
                for(int j=0; j < nClosedBracket; j++) {
                    sb.append(")");
                    depth--;
                }

            } else {
                for(int j=0; j < depth; j++) {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testCase = 0; testCase < t; testCase++) {
            String s = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String result = compute(s);
            System.out.printf("Case #%s: %s", testCase+1, result);
            System.out.println("");
        }

        scanner.close();
    }
}
