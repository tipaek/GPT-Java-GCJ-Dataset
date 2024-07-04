import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Check {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int g = 1; g <= n; g++) {
            String s = br.readLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : s.toCharArray()) {
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

            result.append("Case #").append(g).append(": ").append(output).append("\n");
        }

        System.out.print(result);
    }
}