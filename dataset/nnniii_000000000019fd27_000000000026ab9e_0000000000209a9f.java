import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            String S = reader.readLine();
            StringBuilder caseResult = new StringBuilder();

            int open = 0;
            for (char c : S.toCharArray()) {
                int num = c - '0';

                while (num - open > 0) {
                    caseResult.append('(');
                    open++;
                }
                while (open - num > 0) {
                    caseResult.append(')');
                    open--;
                }
                caseResult.append(num);
            }

            while (open > 0) {
                caseResult.append(')');
                open--;
            }

            result.append(String.format("Case #%d: %s\n", i, caseResult.toString()));
        }

        writer.println(result.toString());

        reader.close();
        writer.close();
    }
}
