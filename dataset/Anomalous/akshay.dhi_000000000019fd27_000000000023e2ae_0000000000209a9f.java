import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int counter = 1;

        while (testCases-- > 0) {
            String s = br.readLine();
            int currentLevel = 0;
            StringBuilder result = new StringBuilder("Case #" + counter + ": ");

            for (char c : s.toCharArray()) {
                int digit = c - '0';

                while (currentLevel < digit) {
                    result.append("(");
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    result.append(")");
                    currentLevel--;
                }
                result.append(c);
            }

            while (currentLevel > 0) {
                result.append(")");
                currentLevel--;
            }

            System.out.println(result.toString());
            counter++;
        }
    }
}