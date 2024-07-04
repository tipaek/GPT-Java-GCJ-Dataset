import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        // int T = 1;

        // int[] start = { 360, 420, 600 };
        // int[] stop = { 480, 540, 660 };

        for (int i = 0; i < T; i++) {
            boolean cAvailable = true;
            boolean jAvailable = true;
            int N = input.nextInt();
            // int N = 3;
            int[] start = new int[N];
            int[] stop = new int[N];
            int[] all = new int[2 * N];
            int[] numworking = new int[N];
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
                            cAvailable = true;
                            working--;
                        } else {
                            jAvailable = true;
                            working--;
                        }
                        stop[k] = -stop[k];
                    } else if (all[j] == start[k]) {
                        working++;
                        if (cAvailable == true) {
                            solutions[k] = 'C';
                            cAvailable = false;
                        } else if (jAvailable == true) {
                            solutions[k] = 'J';
                            jAvailable = false;
                        }
                        if (working > 2) {
                            System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                            impossible = true;
                            break a;
                        }
                        start[k] = -start[k];
                    }

                }
            }
            // System.out.println(Arrays.toString(numworking));

            if (impossible == false) {
                for (int k = 0; k < N; k++) {
                    solution += solutions[k];
                }
                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
        }

    }
}