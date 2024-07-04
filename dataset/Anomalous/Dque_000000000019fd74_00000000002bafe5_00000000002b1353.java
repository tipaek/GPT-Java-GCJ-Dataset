import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            writer.println("Case #" + testCase + ":");
            StringJoiner output = new StringJoiner("\n");
            int n = Integer.parseInt(reader.readLine());

            if (n == 1) {
                writer.println("1 1");
                continue;
            }
            if (n == 2) {
                writer.println("1 1");
                writer.println("2 1");
                continue;
            }

            int x = 0;
            int powerOfTwo = 1;

            while (x + 1 + powerOfTwo * 2 <= n) {
                x++;
                powerOfTwo *= 2;
            }

            for (int k = 0; k <= x; k++) {
                output.add((k + 1) + " 1");
            }

            for (int k = 2; k <= x; k++) {
                output.add((x + 1) + " " + k);
            }

            int currentSum = x + powerOfTwo - 1;

            while (currentSum + x + 1 <= n) {
                output.add((x + 2) + " " + (x + 1));
                currentSum += x + 1;
                x++;
            }

            while (currentSum < n) {
                output.add((x + 1) + " " + (x + 1));
                currentSum++;
                x++;
            }

            writer.println(output.toString());
        }

        writer.close();
    }
}