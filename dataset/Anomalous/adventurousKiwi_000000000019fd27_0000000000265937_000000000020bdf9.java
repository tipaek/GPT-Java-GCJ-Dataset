import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static boolean isFree(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            if (N > 2 * (24 * 60 + 1)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            int[] jamie = new int[24 * 60 + 1];
            int[] cameron = new int[24 * 60 + 1];
            int[] day = new int[24 * 60 + 1];
            boolean impossible = false;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for (int k = start; k < end; k++) {
                    day[k]++;
                    if (day[k] >= 3) {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) break;

                if (isFree(jamie, start, end)) {
                    for (int k = start; k < end; k++) {
                        jamie[k] = j + 1;
                    }
                    sb.append("J");
                } else if (isFree(cameron, start, end)) {
                    for (int k = start; k < end; k++) {
                        cameron[k] = j + 1;
                    }
                    sb.append("C");
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + sb.toString());
            }
        }
    }
}