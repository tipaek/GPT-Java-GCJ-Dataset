import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(":\n");
            int n = Integer.parseInt(reader.readLine());
            int sk = 1;

            if (n == 2) {
                result.append("1 1\n2 1\n");
            } else {
                result.append("1 1\n");
                int val = 1;

                while (val + 1 + sk <= n) {
                    result.append(sk + 1).append(" ").append(sk).append("\n");
                    val += sk;
                    sk++;
                }

                n -= val;
                if (n > 0) {
                    int k = sk - 1;
                    addRowElements(result, k + 1, false, n);
                }
            }
        }

        writer.print(result);
        writer.flush();
        reader.close();
    }

    private static void addRowElements(StringBuilder result, int k, boolean startFromLeft, int remaining) {
        int count = 0;

        if (startFromLeft) {
            for (int i = k; count < remaining; i++, count++) {
                result.append(i).append(" 1\n");
            }
        } else {
            for (int i = k; count < remaining; i++, count++) {
                result.append(i).append(" ").append(i).append("\n");
            }
        }
    }
}