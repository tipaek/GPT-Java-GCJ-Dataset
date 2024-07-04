import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[][] mat = buildMatrix(k, n);

//            if (gcd(k, n) == 1) {
            if (containsZero(mat)) {
                System.out.println("Case      #" + i
                        + ":      IMPOSSIBLE");
                continue;
            }

            System.out.println("Case      #" + i + ":      POSSIBLE");
            printMatrix(mat);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    private static void printMatrix(int[][] buildMatrix) {
        for (int[] line : buildMatrix) {
            StringBuilder l = new StringBuilder("");
            for (int v : line) {
                l.append(v + "      ");
            }
            System.out.println(l.toString().trim());
        }
    }

    private static int[][] buildMatrix(int k, int n) {
        int[][] mat = new int[n][n];
        int diagSum = 0;
        int r = 0;
        while (diagSum < k) {
            mat[r][r]++;
            diagSum++;
            r++;
            if (r == n) {
                r = 0;
            }
        }
        Set<Integer>[] rExist = new HashSet[n];
        Set<Integer>[] cExist = new HashSet[n];
        for (int i = 0; i < n; i++) {
            rExist[i] = new HashSet<>();
            rExist[i].add(mat[i][i]);
            cExist[i] = new HashSet<>();
            cExist[i].add(mat[i][i]);
        }

        int[][] newMat = copy(mat, n);

        outer:
        for (int ro = 0; ro < n; ro++) {
            for (int co = ro + 1;;) {

                if (co == n) {
                    co = 0;
                }

                if (co == ro) {
                    continue outer;
                }

                for (int val = 1; val <= n; val++) {

                    if (!rExist[ro].contains(val) && !cExist[co].contains(val)) {
                        newMat[ro][co] = val;
                        rExist[ro].add(val);
                        cExist[co].add(val);
                        break;

                    }
                }

                co++;
            }
        }

        if (containsZero(newMat)) {
            newMat = copy(mat, n);
            for (int i = 0; i < n; i++) {
                rExist[i] = new HashSet<>();
                rExist[i].add(mat[i][i]);
                cExist[i] = new HashSet<>();
                cExist[i].add(mat[i][i]);
            }
            outer:
            for (int ro = 0; ro < n; ro++) {
                for (int co = ro + 1;;) {

                    if (co == n) {
                        co = 0;
                    }

                    if (co == ro) {
                        continue outer;
                    }

                    for (int val = n; val > 0; val--) {

                        if (!rExist[ro].contains(val) && !cExist[co].contains(val)) {
                            newMat[ro][co] = val;
                            rExist[ro].add(val);
                            cExist[co].add(val);
                            break;

                        }
                    }

                    co++;
                }
            }
        }

        return newMat;
    }

    private static int[][] copy(int[][] mat, int n) {
        int[][] newMAt = new int[n][n];

        for (int i = 0; i < n; i++) {
            newMAt[i] = Arrays.copyOf(mat[i], n);
        }

        return newMAt;
    }

    private static boolean containsZero(int[][] newMat) {
        for (int[] m : newMat) {
            for (int v : m) {
                if (v == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}