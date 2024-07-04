import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        for (int cc = 0; cc < cases; cc++) {
            String line = reader.readLine();

            StringBuilder r = new StringBuilder(line.length() * 4);
            r.append(line);

            int depth = 0;
            for (int i = 0; i < r.length(); i++) {
                int c = r.charAt(i) - '0';
                if (c >= 0 && c <= 9) {
                    int diff = c - depth;
                    if (diff != 0) {
                        for (int j = 0; j < Math.abs(diff); j++) {
                            r.insert(i, c > 0 ? '(' : ')');
                        }
                        depth += diff;
                        i += Math.abs(diff);
                    }
                }
            }
            for (int i = 0; i < depth; i++) {
                r.append(')');
            }

            System.out.printf("Case #%d: %s%n", cc + 1, r);
        }
    }

}
