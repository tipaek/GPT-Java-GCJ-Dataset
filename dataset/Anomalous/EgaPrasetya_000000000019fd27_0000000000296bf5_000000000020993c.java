package Main.java;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = calculateTrace(mat, size);
            int r = countRowDuplicates(mat, size);
            int c = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
        sc.close();
    }

    private static int calculateTrace(int[][] mat, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(mat[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countColDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(mat[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}