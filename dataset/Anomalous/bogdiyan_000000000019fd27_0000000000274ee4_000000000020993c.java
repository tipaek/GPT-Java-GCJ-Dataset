import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            int trace = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }

            int r = rowDuplicate(mat, size);
            int c = colDuplicate(mat, size);

            System.out.println("Case #" + z + ": " + trace + " " + r + " " + c);
        }
    }

    public static int rowDuplicate(int[][] arr, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(arr[i][j])) {
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
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(arr[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}