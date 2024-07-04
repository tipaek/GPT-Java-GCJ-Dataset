import java.util.*;
import java.io.*;
public class Solution {
    public static void vestigium(int index, int[][] matrix) {
        int N = matrix.length;
        int k = 0;
        for (int i = 0; i < N; i++) k += matrix[i][i];
        int r = 0;
        int c = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.clear();
            for (int j = 0; j < N; j++) {
                int val = matrix[i][j];
                if (!set.add(val)) {
                    r++;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            set.clear();
            for (int j = 0; j < N; j++) {
                int val = matrix[j][i];
                if (!set.add(val)) {
                    c++;
                    break;
                }
            }
        }
        System.out.println("Case #" + index + ": " + k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++)
                    matrix[x][y] = sc.nextInt();
            }
            vestigium(i, matrix);
        }

    }
}

