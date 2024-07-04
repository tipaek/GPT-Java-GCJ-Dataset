import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            String str = br.readLine().trim();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : str.toCharArray()) {
                int num = Character.getNumericValue(ch);
                if (num > currentDepth) {
                    result.append("(".repeat(num - currentDepth));
                } else if (num < currentDepth) {
                    result.append(")".repeat(currentDepth - num));
                }
                result.append(num);
                currentDepth = num;
            }

            result.append(")".repeat(currentDepth));

            System.out.println("Case #" + t + ": " + result);
        }
    }
}