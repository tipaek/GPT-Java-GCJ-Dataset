import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String s = br.readLine();
            StringBuilder result = new StringBuilder("Case #").append(t).append(": ");
            int currentLevel = 0;

            for (char ch : s.toCharArray()) {
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

            System.out.println(result.toString());
        }
    }
}