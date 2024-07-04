import java.util.*;

class Solution {
    static int[][] getMatrix(int n, Scanner sc) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    static int computeTrace(int[][] arr) {
        int trace = 0;
        for (int i = 0; i < arr.length; i++) {
            trace += arr[i][i];
        }
        return trace;
    }

    static int badRows(int[][] arr) {
        int bad = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < arr[i].length; j++) {
                if (set.contains(arr[i][j])) {
                    bad++;
                    break;
                } else {
                    set.add(arr[i][j]);
                }
            }
        }
        return bad;
    }

    static int badCols(int[][] arr) {
        int bad = 0;
        for (int j = 0; j < arr[0].length; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i][j])) {
                    bad++;
                    break;
                } else {
                    set.add(arr[i][j]);
                }
            }
        }
        return bad;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = sc.nextInt();
            int[][] arr = getMatrix(n, sc);
            int trace = computeTrace(arr);
            int badRows = badRows(arr);
            int badCols = badCols(arr);
            System.out.printf("Case #%d: %d %d %d\n", test, trace, badRows, badCols);
        }
    }
}