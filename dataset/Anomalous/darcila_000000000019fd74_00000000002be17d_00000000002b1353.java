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
            int maxPower = 0;

            for (int i = powers.length - 1; i >= 0; i--) {
                if (powers[i] <= N) {
                    maxPower = i;
                    break;
                }
            }

            if (powers[maxPower] + maxPower - 1 > (long) N) {
                maxPower--;
            }

            boolean[] on = new boolean[100];
            on[maxPower] = true;

            long total = maxPower + powers[maxPower] - 1;
            int pos = maxPower - 1;

            while (N - total > 35) {
                while (total + powers[pos] - 1 > N) {
                    pos--;
                }
                total += powers[pos] - 1;
                on[pos] = true;
                pos--;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(t).append(":\n");
            boolean start = true;

            for (int i = 1; i <= maxPower + (N - total); i++) {
                if (on[i]) {
                    if (start) {
                        for (int j = 1; j <= i; j++) {
                            sb.append(i).append(" ").append(j).append("\n");
                        }
                    } else {
                        for (int j = i; j > 0; j--) {
                            sb.append(i).append(" ").append(j).append("\n");
                        }
                    }
                    start = !start;
                } else {
                    if (start) {
                        sb.append(i).append(" 1\n");
                    } else {
                        sb.append(i).append(" ").append(i).append("\n");
                    }
                }
            }
            System.out.print(sb.toString());
        }
    }
}