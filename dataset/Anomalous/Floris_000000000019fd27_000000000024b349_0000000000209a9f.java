import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int numberOfCases = sc.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String s = sc.next() + "0";
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < s.length(); i++) {
                int digitValue = s.charAt(i) - '0';

                while (currentDepth < digitValue) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digitValue) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(s.charAt(i));
            }

            result.deleteCharAt(result.length() - 1);
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }
}