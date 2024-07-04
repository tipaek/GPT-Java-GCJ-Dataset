import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {

            int numCases = Integer.parseInt(br.readLine());

            for (int i = 1; i <= numCases; i++) {
                String input = br.readLine();
                int depth = 0;
                StringBuilder output = new StringBuilder();

                for (char c : input.toCharArray()) {
                    int val = c - '0';

                    while (depth < val) {
                        output.append('(');
                        depth++;
                    }
                    while (depth > val) {
                        output.append(')');
                        depth--;
                    }

                    output.append(c);
                }

                while (depth > 0) {
                    output.append(')');
                    depth--;
                }

                pw.println("Case #" + i + ": " + output.toString());
            }

            pw.flush();
        }
    }
}