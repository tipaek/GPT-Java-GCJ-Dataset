import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int h = 1; h <= t; h++) {
            result.append("Case #").append(h).append(":\n");
            int n = Integer.parseInt(br.readLine());
            int k = 0;
            boolean startFromLeft = true;
            int total = 0;

            while (total + Math.pow(2, k) <= n) {
                int sum = (int) Math.pow(2, k);
                appendRowElements(result, k + 1, startFromLeft, true, 0);
                startFromLeft = !startFromLeft;
                total += sum;
                k++;
            }

            int remaining = n - total;
            if (remaining > 0) {
                appendRowElements(result, k + 1, startFromLeft, false, remaining);
            }
        }

        out.print(result);
        out.flush();
        br.close();
    }

    private static void appendRowElements(StringBuilder result, int k, boolean startFromLeft, boolean includeAll, int remaining) {
        if (includeAll) {
            if (startFromLeft) {
                for (int i = 1; i <= k; i++) {
                    result.append(k).append(" ").append(i).append("\n");
                }
            } else {
                for (int i = k; i >= 1; i--) {
                    result.append(k).append(" ").append(i).append("\n");
                }
            }
        } else {
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
}