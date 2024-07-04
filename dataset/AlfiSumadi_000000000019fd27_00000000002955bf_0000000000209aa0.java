import java.util.*;
import java.io.*;
/**
 * Solution
 */

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }

    private static void solve(long x) {
        int n = sc.nextInt(), k = sc.nextInt();

        // initialise candidate k partition
        int[] kp = new int[n];
        int sumSoFar = 0;
        for(int i = 1; i <= n; i++) {
            kp[i-1] = i;
            sumSoFar += i;
        }
        int curI = n - 1;
        while (sumSoFar != k && curI > 0) {
            if (k > sumSoFar) {
                kp[curI]++;
                sumSoFar++;
                if (kp[curI] == n) curI--;
            } else {
                kp[curI]--;
                sumSoFar--;
                if (kp[curI] == 1) curI--;
            }
        }
        Arrays.sort(kp);

        // initialise square
        int[][] sq = new int[n][n];
        for (int i = 0; i < n; i++) {
            sq[i][i] = kp[i];
        }

        boolean possible = false;
        boolean outOfKPartitions = false;
        
        while (!(possible = fillSq(sq, n)) && !outOfKPartitions) {
            outOfKPartitions = nextKPartition(kp);
        }

        if (possible) {
            System.out.println("Case #"+x+": POSSIBLE");
            printSq(sq);
        }
        else System.out.println("Case #"+x+": IMPOSSIBLE");
    }

    static boolean fillSq(int[][] sq, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    boolean found = false;
                    for (int x = 1; x <= n; x++) {
                        found = false;
                        for (int r = 0; r < n; r++) {
                            if (sq[i][r] == x) {
                                found = true;
                                break;
                            }
                        }
                        for (int c = 0; c < n; c++) {
                            if (sq[c][j] == x) { 
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            sq[i][j] = x;
                            break;
                        }
                    }
                    if (found) return false;
                }
            }
        }
        return true;
    }

    static boolean nextKPartition(int[] kp) {
        if (kp[kp.length - 1] - kp[0] == 1 || kp[kp.length - 1] == kp[0]) { return true; }
        int lowest = kp[0];
        int i = 0;
        for (; i < kp.length - 1; i++) {
            if (kp[i] > lowest) {
                break;
            }
        }
        kp[kp.length - 1]--;
        kp[i - 1]++;
        return false;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private static void printSq(int[][] sq) {
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq.length - 1; j++) {
                System.out.print(sq[i][j] + " ");
            }
            System.out.print(sq[i][sq.length - 1]);
            System.out.println("");
        }
    }
}