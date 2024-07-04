import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.LongUnaryOperator;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());
            long diff = Math.abs(a - b);

            long maxBinSearch = 5000000000L;
            long x = binarySearch(diff, 0, maxBinSearch, Solution::calculateSum);

            if (b > a) {
                b -= calculateSum(x);
            } else {
                a -= calculateSum(x);
            }

            long leftK = b > a ? x : x - 1;
            long rightK = b > a ? x - 1 : x;
            maxBinSearch = 1000000000L;

            long y = binarySearch(a, 0, maxBinSearch, n -> calculateSumWithK(n, leftK));
            a -= calculateSumWithK(y, leftK);

            long z = binarySearch(b, 0, maxBinSearch, n -> calculateSumWithK(n, rightK));
            b -= calculateSumWithK(z, rightK);

            long answer = x + y + z;
            writer.printf("Case #%d: %d %d %d\n", caseNum, answer, a, b);
        }

        reader.close();
        writer.close();
    }

    public static long calculateSum(long x) {
        return x * (x + 1) / 2;
    }

    public static long calculateSumWithK(long n, long k) {
        long result = n * (n + 1) + k * n;
        return result < 0 ? Long.MAX_VALUE : result;
    }

    public static long binarySearch(long value, long min, long max, LongUnaryOperator function) {
        long left = min;
        long right = max;
        while (left < right) {
            if (right - left <= 1) {
                return function.applyAsLong(right) <= value ? right : left;
            }
            long mid = (left + right) / 2;
            if (function.applyAsLong(mid) <= value) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}