import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] results = new String[n];

        for (int g = 0; g < n; g++) {
            String input = br.readLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(ch);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            results[g] = "Case #" + (g + 1) + ": " + output.toString();
            System.out.println(results[g]);
        }
    }
}