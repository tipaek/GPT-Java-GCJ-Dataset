import java.util.Scanner;

public class Solution {

    public static boolean latinSquare(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (duplicates(array[i])) {
                return false;
            }

            int[] column = new int[array[i].length];
            for (int j = 0; j < array.length; j++) {
                column[j] = array[j][i];
            }
            if (duplicates(column)) {
                return false;
            }
        }
        return true;
    }

    public static boolean duplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int q = k / n;
            int r = k % n;
            int[] trace = new int[n];
            int[][] latin = new int[n][n];
            for (int j = 0; j < n; j++) {
                trace[j] = q;
            }
            for (int j = 0; j < r; j++) {
                trace[j]++;
            }
            for (int j = 0; j < n; j++) {
                latin[j][j] = trace[j];
            }
            for (int j = 0; j < n; j++) {
                int num = latin[j][j];
                if (j % 2 == 0) {
                    int c = 1;
                    for (int l = 0; l < n; l++) {
                        if (l != j) {
                            if (c == num) {
                                c++;
                            }
                            latin[j][l] = c;
                            c++;
                        }
                    }
                } else {
                    int c = n;
                    for (int l = 0; l < n; l++) {
                        if (l != j) {
                            if (c == num) {
                                c--;
                            }
                            latin[j][l] = c;
                            c--;
                        }
                    }
                }
            }
            if (latinSquare(latin)) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print(latin[j][l] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}
