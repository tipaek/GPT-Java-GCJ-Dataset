import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCount; ++t) {
            char[] digits = br.readLine().toCharArray();
            int length = digits.length;
            StringBuilder result = new StringBuilder();

            int initialDigit = digits[0] - '0';
            for (int i = 0; i < initialDigit; ++i) {
                result.append("(");
            }
            result.append(digits[0]);

            for (int i = 1; i < length; ++i) {
                int currentDigit = digits[i] - '0';
                int previousDigit = digits[i - 1] - '0';
                
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < (currentDigit - previousDigit); ++j) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < (previousDigit - currentDigit); ++j) {
                        result.append(")");
                    }
                }
                result.append(digits[i]);
            }

            int finalDigit = digits[length - 1] - '0';
            for (int i = 0; i < finalDigit; ++i) {
                result.append(")");
            }

            w.println("Case #" + t + ": " + result);
        }

        w.flush();
        w.close();
    }
}