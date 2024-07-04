import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.printf("Case #%d: ", t + 1);
            if (k < n || k > n * n || k % n != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println("POSSIBLE");

            int[] rowMap = new int[n];
            int[] colMap = new int[n];
            for (int i = 0; i < n; i++) {
                rowMap[i] = i;
                colMap[i] = i;
            }

            int trace = n;

            while (trace < k) {
                // find the two minimum slots in the diagonal
                int i1 = -1, min1 = n, i2 = -1, min2 = n;
                for (int i = 0; i < n; i++) {
                    int val = Math.floorMod(rowMap[i] - colMap[i], n);
                    if (val < min1) {
                        min2 = min1;
                        i2 = i1;
                        min1 = val;
                        i1 = i;
                    } else if (val < min2) {
                        min2 = val;
                        i2 = i;
                    }
                }

                // swap the rows. It should increase N to the trace.
                int tmp = rowMap[i1];
                rowMap[i1] = rowMap[i2];
                rowMap[i2] = tmp;

                // compute again just in case
                // we could replace by trace += n
                trace = 0;
                for (int i = 0; i < n; i++) {
                    int val = Math.floorMod(rowMap[i] - colMap[i], n);
                    trace += val + 1;
                }
//                System.out.println("trace = " + trace);
//                System.out.println();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.floorMod(rowMap[i] - colMap[j], n);
                    System.out.printf("%d ", val + 1);
                }
                System.out.println();
            }

//            Random rnd = new Random();
//
//            for (int x = 0; x < 30; x++) {
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        if (i == j || true) {
//                            int val = Math.floorMod(rowMap[i] - colMap[j], n);
//                            System.out.printf("%d ", val + 1);
//                        } else {
//                            System.out.print("  ");
//                        }
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//
//                trace = 0;
//                for (int i = 0; i < n; i++) {
//                    int val = Math.floorMod(rowMap[i] - colMap[i], n);
//                    trace += val + 1;
//                }
//                System.out.println("trace = " + trace);
//                System.out.println();
//
//                int a = rnd.nextInt(n);
//                int b = rnd.nextInt(n);
//
//                int tmp = rowMap[a];
//                rowMap[a] = rowMap[b];
//                rowMap[b] = tmp;
//            }

        }
    }
}
