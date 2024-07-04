import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());

            long left = 0L;
            long right = 1000000000L;
            long maxK = 0L;
            long finalA = a;
            long finalB = b;

            while (left <= right) {
                long mid = left + (right - left) / 2;

                boolean isFail = false;
                long currentA = a;
                long currentB = b;

                for (long k = 1L; k <= mid; k++) {
                    if (currentA < k && currentB < k) {
                        isFail = true;
                        break;
                    }
                    if (currentA >= currentB) {
                        currentA -= k;
                    } else {
                        currentB -= k;
                    }
                }

                if (!isFail) {
                    maxK = mid;
                    finalA = currentA;
                    finalB = currentB;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            writer.println("Case #" + testCase + ": " + maxK + " " + finalA + " " + finalB);
        }

        writer.close();
    }
}