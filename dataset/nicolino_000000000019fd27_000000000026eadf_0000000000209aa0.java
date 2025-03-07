import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            String[] NK = in.nextLine().split("\\s+");

            int n = Integer.parseInt(NK[0]);
            int k = Integer.parseInt(NK[1]);

            boolean isPossible = isPossible(n, k);

            if (!isPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                if (k % n == 0 && k / n == k) {
                    int start = k / n;
                    for (int r = 0; r < n; r++) {
                        for (int c = 0; c < n; c++) {
                            System.out.print(start + " ");
                            int inc = 1;
                            if (c + 1 == n) {
                                inc = 0;
                            }
                            if (start + inc > n) {
                                start = 1;
                            } else {
                                start += inc;
                            }
                        }
                        System.out.println("");
                    }
                } else {
                    int start = k / n;
                    for (int r = 0; r < n; r++) {
                        for (int c = n-1; c >= 0; c--) {
                            System.out.print(start + " ");
                            int inc = 1;
                            if (c - 1 < 0) {
                                inc = 0;
                            }
                            if (start + inc > n) {
                                start = 1;
                            } else {
                                start += inc;
                            }
                        }
                        System.out.println("");
                    }
                }
            }

        }
    }

    public static boolean isPossible(int n, int k) {
        //int sum = (n * (n + 1)) / 2;
        return ((k % n) == 0/*  || sum == k */);
    }

}
