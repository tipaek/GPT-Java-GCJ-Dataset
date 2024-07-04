import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int T = Integer.parseInt(line);
        for (int t = 1; t <= T; t++) {
            line = reader.readLine();
            StringBuilder sb = new StringBuilder();

            int depth = 0;
            for (int i = 0; i < line.length(); i++) {
                int num = line.charAt(i) - '0';
                while (num > depth) {
                    sb.append('(');
                    depth++;
                }
                while (num < depth) {
                    sb.append(')');
                    depth--;
                }
                sb.append(num);
            }
            while (depth-- > 0) sb.append(')');

            System.out.println("Case #" + t + ": " + sb.toString());
        }

    }
}