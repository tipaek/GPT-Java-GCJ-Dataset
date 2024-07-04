import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(System.out)) {

            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();

            for (int h = 1; h <= t; h++) {
                result.append("Case #").append(h).append(":\n");
                int n = Integer.parseInt(br.readLine());
                int k = (int) (Math.log(n) / Math.log(2)) + 1;
                boolean startFromLeft = true;

                while (n > 0) {
                    int sum = (int) Math.pow(2, k - 1);
                    addRowElements(result, k, startFromLeft, true, 0);
                    startFromLeft = !startFromLeft;
                    n -= sum;
                    k--;

                    if (n < Math.pow(2, k - 1)) {
                        break;
                    }
                }

                if (n > 0) {
                    addRowElements(result, k, startFromLeft, false, n);
                    n -= k;
                    startFromLeft = !startFromLeft;
                }

                if (n > 0) {
                    addRowElements(result, k, startFromLeft, false, n);
                    n -= k;
                }
            }

            out.print(result);
            out.flush();
        }
    }

    private static void addRowElements(StringBuilder result, int k, boolean startFromLeft, boolean includeAll, int remaining) {
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
            if (startFromLeft) {
                for (int i = k; i >= 1; i--) {
                    result.append(1).append(" ").append(i).append("\n");
                    remaining--;
                    if (remaining == 0) {
                        break;
                    }
                }
            } else {
                for (int i = k; i >= 1; i--) {
                    result.append(i).append(" ").append(i).append("\n");
                    remaining--;
                    if (remaining == 0) {
                        break;
                    }
                }
            }
        }
    }
}