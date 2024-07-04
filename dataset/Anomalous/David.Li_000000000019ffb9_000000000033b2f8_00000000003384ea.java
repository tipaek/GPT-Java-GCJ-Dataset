import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            long[] result = solve(l, r);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static long[] solve(long l, long r) {
        long[] result = new long[3];
        long difference = Math.abs(l - r);

        long times = (long) ((Math.sqrt(8 * difference + 1) - 1) / 2);
        long lStep = times + 1;
        long rStep = times + 2;

        if (l >= r) {
            l -= times * (times + 1) / 2;
        } else {
            r -= times * (times + 1) / 2;
            if (l != r) {
                rStep = times + 1;
                lStep = times + 2;
            }
        }
        result[0] += times;

        long k = calculateSteps(rStep, r);
        r -= (k + rStep - 1) * k;
        result[0] += k;

        k = calculateSteps(lStep, l);
        l -= (k + lStep - 1) * k;
        result[0] += k;

        result[1] = l;
        result[2] = r;

        return result;
    }

    private static long calculateSteps(long start, long total) {
        long b = start - 1;
        long c = -total;
        return (long) ((-b + Math.sqrt(b * b - 4 * c)) / 2);
    }
}