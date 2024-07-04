import java.io.*;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8), 1 << 15);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8), 1 << 15)) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 0; t < tests; t++) {
                String line = in.readLine().trim();
                int totalOpened = 0;
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    int c = line.charAt(i) - '0';
                    while (totalOpened < c) {
                        result.append("(");
                        totalOpened++;
                    }
                    while (totalOpened > c) {
                        result.append(")");
                        totalOpened--;
                    }
                    result.append(line.charAt(i));
                }
                while (totalOpened > 0) {
                    result.append(")");
                    totalOpened--;
                }
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
