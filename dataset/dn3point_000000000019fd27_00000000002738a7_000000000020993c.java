import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }
            int[] result = vestigium(matrix);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] vestigium(int[][] matrix) {
        int[] result = new int[3];
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
        }
        HashSet<Integer> tmp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            boolean repeat = false;
            for (int j = 0; j < n; j++) {
                if (tmp.contains(matrix[i][j])) {
                    repeat = true;
                    break;
                } else {
                    tmp.add(matrix[i][j]);
                }
            }
            if (repeat) {
                result[1]++;
            }
            tmp.clear();
        }
        for (int i = 0; i < n; i++) {
            boolean repeat = false;
            for (int j = 0; j < n; j++) {
                if (tmp.contains(matrix[j][i])) {
                    repeat = true;
                    break;
                } else {
                    tmp.add(matrix[j][i]);
                }
            }
            if (repeat) {
                result[2]++;
            }
            tmp.clear();
        }
        return result;
    }

}