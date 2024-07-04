import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[][] input = new int[t][2];

        for (int i = 0; i < t; i++) {
            input[i][0] = scn.nextInt();
            input[i][1] = scn.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int n = input[i][0];
            int m = input[i][1];
            if (isImpossible(n, m)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            int[][] finalArr = new int[n][n];
            int num = m / n;
            distributeValues(n, m, finalArr, num);

            if (!isValidConfiguration(n, finalArr)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                fillRemainingValues(n, finalArr);
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                printMatrix(finalArr);
            }
        }
    }

    private static boolean isImpossible(int n, int m) {
        return m < n || n * n < m;
    }

    private static void distributeValues(int n, int m, int[][] finalArr, int num) {
        int h = m - (num * n);
        if (h <= (n - num)) {
            for (int j = 0; j < n; j++) {
                finalArr[j][j] = num;
            }
            finalArr[0][0] += h;
        } else {
            for (int j = 0; j < n; j++) {
                finalArr[j][j] = (h > 0) ? num + 1 : num;
                h--;
            }
        }
    }

    private static boolean isValidConfiguration(int n, int[][] finalArr) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int j = 0; j < n; j++) {
            uniqueValues.add(finalArr[j][j]);
        }
        return uniqueValues.size() == 1 || (n - uniqueValues.size() + 1) >= (n % 2 == 0 ? n / 2 : n / 2 + 1);
    }

    private static void fillRemainingValues(int n, int[][] finalArr) {
        for (int j = 0; j < n; j++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j == j2) continue;

                List<String> list = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    list.add(String.valueOf(k + 1));
                }

                removeUsedValues(n, finalArr, j, j2, list);

                if (list.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    System.exit(0);
                } else {
                    assignRemainingValues(finalArr, j, j2, list);
                }
            }
        }
    }

    private static void removeUsedValues(int n, int[][] finalArr, int j, int j2, List<String> list) {
        for (int k = 0; k < n; k++) {
            list.remove(String.valueOf(finalArr[j][k]));
            list.remove(String.valueOf(finalArr[k][j2]));
        }
    }

    private static void assignRemainingValues(int[][] finalArr, int j, int j2, List<String> list) {
        for (int k = 0; k < finalArr.length; k++) {
            for (int k2 = 0; k2 < finalArr.length; k2++) {
                if (list.contains(String.valueOf(finalArr[k][k2]))) {
                    finalArr[j][j2] = finalArr[k][k2];
                }
            }
        }
        if (finalArr[j][j2] == 0) {
            finalArr[j][j2] = Integer.parseInt(list.get(0));
        }
    }

    private static void printMatrix(int[][] finalArr) {
        for (int[] row : finalArr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}