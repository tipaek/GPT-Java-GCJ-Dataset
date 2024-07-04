import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int numCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= numCases; i++) {
            String input = br.readLine();
            int depth = 0;
            StringBuilder output = new StringBuilder();

            for (char c : input.toCharArray()) {
                int val = c - '0';
                while (depth != val) {
                    if (depth < val) {
                        output.append('(');
                        depth++;
                    } else {
                        output.append(')');
                        depth--;
                    }
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
        pw.close();
        br.close();
    }
}