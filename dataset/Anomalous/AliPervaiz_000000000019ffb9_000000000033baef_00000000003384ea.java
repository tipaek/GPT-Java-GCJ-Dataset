import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            writer.print("Case #" + i + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long L = Long.parseLong(tokenizer.nextToken());
            long R = Long.parseLong(tokenizer.nextToken());
            int steps = 0;

            while (steps + 1 <= L || steps + 1 <= R) {
                int increment = ++steps;
                if (L >= R) {
                    L -= increment;
                } else {
                    R -= increment;
                }
            }

            writer.println(steps + " " + L + " " + R);
        }

        writer.close();
    }
}