import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            int[] order = new int[N];
            int[] assigned = new int[N];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int minStart = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int j = 0; j < N; j++) {
                    if (intervals[j][0] < minStart) {
                        minStart = intervals[j][0];
                        minIndex = j;
                    }
                }
                intervals[minIndex][0] += 24 * 60;
                order[i] = minIndex;
            }

            for (int i = 0; i < N; i++) {
                intervals[i][0] %= (24 * 60);
            }

            boolean possible = true;
            outerLoop:
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (intervals[order[i]][1] > intervals[order[k]][0] &&
                            intervals[order[j]][1] > intervals[order[k]][0]) {
                            possible = false;
                            break outerLoop;
                        }
                    }
                }
            }

            if (!possible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++) {
                    if (assigned[i] == 0) assigned[i] = 1;
                    for (int j = i + 1; j < N; j++) {
                        if (intervals[order[i]][1] > intervals[order[j]][0]) {
                            assigned[j] = (assigned[i] == 1) ? 2 : 1;
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (order[j] == i) {
                            System.out.print(assigned[j] == 1 ? "J" : "C");
                        }
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}