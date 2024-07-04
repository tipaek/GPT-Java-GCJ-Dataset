import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int[][] array = new int[size][size];
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    array[r][c] = sc.nextInt();
                }
            }

            int rows = 0;
            int cols = 0;
            for (int n = 0; n < size; n++) {
                if (!checkRow(array, size, n)) rows += 1;
                if (!checkColumn(array, size, n)) cols += 1;
            }
            System.out.println("Case #" + (i + 1) + ": " + trace(array, size) + " " + rows + " " + cols);
        }
    }

    static int trace(int[][] arr, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += arr[i][i];
        }
        return trace;
    }

    static boolean checkRow(int[][] arr, int size, int row) {
        HashSet<Integer> data = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (arr[row][i] < 1 || arr[row][i] > size) return false;
            data.add(arr[row][i]);
        }
        return data.size() == size;
    }

    static boolean checkColumn(int[][] arr, int size, int col) {
        HashSet<Integer> data = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (arr[i][col] < 1 || arr[i][col] > size) return false;
            data.add(arr[i][col]);
        }
        return data.size() == size;
    }
}