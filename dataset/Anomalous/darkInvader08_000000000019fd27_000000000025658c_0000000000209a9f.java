import java.io.*;

public class Check {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int g = 1; g <= n; g++) {
            String s = br.readLine();
            StringBuilder op = new StringBuilder();
            int currentDepth = 0;

            for (char ch : s.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    op.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    op.append(")");
                    currentDepth--;
                }
                op.append(ch);
            }

            while (currentDepth > 0) {
                op.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + g + ": " + op.toString());
        }
    }
}