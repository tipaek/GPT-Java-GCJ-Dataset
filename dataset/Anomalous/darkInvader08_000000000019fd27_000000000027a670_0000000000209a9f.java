import java.io.*;

public class Check {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {
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

            results[i] = "Case #" + (i + 1) + ": " + output.toString();
            System.out.println(results[i]);
        }
    }
}