import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            boolean[] jBusy = new boolean[n];
            boolean[] cBusy = new boolean[n];
            boolean[] j = new boolean[1441];
            boolean[] c = new boolean[1441];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                for (int t1 = start; t1 < end; t1++) {
                    if (j[t1]) {
                        jBusy[i] = true;
                        break;
                    }
                }

                if (jBusy[i]) {
                    for (int t2 = start; t2 < end; t2++) {
                        if (c[t2]) {
                            cBusy[i] = true;
                            break;
                        }
                    }

                    if (jBusy[i] && cBusy[i]) {
                        System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        for (int t3 = start; t3 < end; t3++) {
                            c[t3] = true;
                        }
                    }
                } else {
                    for (int t4 = start; t4 < end; t4++) {
                        j[t4] = true;
                    }
                }
            }

            if (!impossible) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(jBusy[i] ? 'C' : 'J');
                }
                System.out.println("Case #" + (z + 1) + ": " + result);
            }
        }

        scanner.close();
    }
}