import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder("Case #").append(caseNumber).append(": ");
            int currentLevel = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }
                result.append(ch);
            }

            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }

            System.out.println(result);
            caseNumber++;
        }
    }
}