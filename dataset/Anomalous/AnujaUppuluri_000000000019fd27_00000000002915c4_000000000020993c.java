import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
    }

    public static int calculateTrace(int[][] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static int countRowDuplicates(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(arr[i])) {
                count++;
            }
        }
        return count;
    }

    public static int countColDuplicates(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int[] col = new int[size];
            for (int j = 0; j < size; j++) {
                col[j] = arr[j][i];
            }
            if (hasDuplicates(col)) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(value)) {
                return true;
            }
            map.put(value, true);
        }
        return false;
    }
}