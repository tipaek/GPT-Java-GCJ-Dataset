import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int cc = -1;
            int jj = -1;
            int N = input.nextInt();
            int[] start = new int[N];
            int[] stop = new int[N];
            int[] all = new int[2 * N];
            boolean impossible = false;
            String solution = "";
            char[] solutions = new char[N];

            for (int j = 0; j < N; j++) {
                start[j] = input.nextInt();
                stop[j] = input.nextInt();
            }

            for (int j = 0; j < N; j++) {
                all[j] = start[j];
            }
            for (int j = N; j < 2 * N; j++) {
                all[j] = stop[j - N];
            }
            Arrays.sort(all);
            int working = 0;

            a: for (int j = 0; j < 2 * N; j++) {
                for (int k = 0; k < N; k++) {
                    if (all[j] == stop[k]) {
                        if (solutions[k] == 'C') {
                            cc = -1;
                            working--;
                        } else if (solutions[k] == 'J') {
                            jj = -1;
                            working--;
                        }
                        // System.out.println(" stop: " + cc + " " + jj + " " + k);
                        stop[k] = -stop[k];
                    }
                }
                for (int k = 0; k < N; k++) {
                    if (all[j] == start[k]) {
                        if (cc == -1) {
                            solutions[k] = 'C';
                            cc = k;
                        } else if (jj == -1) {
                            solutions[k] = 'J';
                            jj = k;
                        }
                        working++;
                        if (working == 3) {
                            System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                            impossible = true;
                            break a;
                        }
                        // System.out.println(" start: " + cc + " " + jj + " " + k);
                        start[k] = -start[k];
                    }

                }
            }
            if (impossible == false) {
                for (int k = 0; k < N; k++) {
                    solution += solutions[k];
                }
                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
        }

    }
}