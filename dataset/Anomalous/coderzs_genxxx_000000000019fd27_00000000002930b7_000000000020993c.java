import java.util.Scanner;
import java.util.HashSet;

class Solution {
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

            int k = trace(mat, size);
            int r = rowDuplicate(mat, size);
            int c = colDuplicate(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
        sc.close();
    }

    public static int trace(int[][] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    public static int rowDuplicate(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(arr[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int colDuplicate(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(arr[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}