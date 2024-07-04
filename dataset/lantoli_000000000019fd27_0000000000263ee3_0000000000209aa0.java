//package codejam2020.round0.indicium;

import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        //String inFile = "sample.in";
        //Scanner sc = new Scanner(Solution.class.getResource(inFile).openStream());
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] cur = new int[n];
            for (int i = 0; i < n; i++) {
                cur[i] = i+1;
            }
            perm = new ArrayList<>();
            calc_perm(cur, 0);
            System.out.println("Case #" + test + ": " + doit(n, k));
        }
    }

    public static List<int[]> perm;

    public static void calc_perm(int[] cur, int index) {
        if (index == cur.length - 1) {
            perm.add(cur);
            return;
        }
        for (int i = index; i <= cur.length - 1; i++) {
            int[] newArray = cur.clone();
            if (i != index) {
                newArray[i] ^= newArray[index];
                newArray[index] ^= newArray[i];
                newArray[i] ^= newArray[index];
            }
            calc_perm(newArray, index + 1);
        }
    }

    public static String doit(int n, int k) {
        int ret = n + k;

        int[] pos = new int[n];
        while (true) {
            int[][] matrix = new int[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = perm.get(pos[i]);
            }
            if (check(n, k, matrix)) {
                return "POSSIBLE\n" + print(n, matrix);
            }
            int index = 0;
            while (true) {
                pos[index]++;
                if (pos[index] == perm.size()) {
                    pos[index] = 0;
                    index++;
                    if (index == n) {
                        return "IMPOSSIBLE";
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static boolean check(int n, int k, int[][] matrix) {
        int sum = 0;
        if (n == 3 && matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2) {
            int a = 0;
        }
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        if (sum != k) return false;
        for (int j = 0; j < n; j++) {
            boolean[] found = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (found[matrix[i][j]-1]) {
                    return false;
                } else {
                    found[matrix[i][j]-1] = true;
                }
            }
        }
        return true;
    }

    public static String print(int n, int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
                if (j < n-1) sb.append(' ');
            }
            if (i < n-1) sb.append('\n');        }
        return sb.toString();
    }
}
