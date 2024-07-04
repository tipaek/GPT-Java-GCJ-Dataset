import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] powers = new long[32];
        powers[1] = 1L;

        for (int i = 2; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int maxPower = findMaxPower(powers, N);

            if (powers[maxPower] + maxPower - 1 > N) {
                maxPower--;
            }

            boolean[] on = new boolean[100];
            on[maxPower] = true;

            long total = maxPower + powers[maxPower] - 1;
            int pos = powers.length - 1;

            while (N - total > 35) {
                while (total + powers[pos] - 1 > N) {
                    pos--;
                }
                total += powers[pos] - 1;
                on[pos] = true;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(t).append(":\n");
            boolean start = true;

            for (int i = 1; i <= maxPower + (N - total); i++) {
                if (on[i]) {
                    appendPositions(sb, i, start);
                    start = !start;
                } else {
                    sb.append(i).append(start ? " 1\n" : " " + i + "\n");
                }
            }
            System.out.print(sb.toString());
        }
    }

    private static int findMaxPower(long[] powers, int N) {
        for (int i = powers.length - 1; i >= 0; i--) {
            if (powers[i] <= N) {
                return i;
            }
        }
        return 0;
    }

    private static void appendPositions(StringBuilder sb, int i, boolean start) {
        if (start) {
            for (int j = 1; j <= i; j++) {
                sb.append(i).append(" ").append(j).append("\n");
            }
        } else {
            for (int j = i; j > 0; j--) {
                sb.append(i).append(" ").append(j).append("\n");
            }
        }
    }
}