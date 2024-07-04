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

            int r = countRowDuplicates(mat, size);
            int c = countColumnDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + trace + " " + r + " " + c);
        }
        sc.close();
    }

    public static int countRowDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(mat[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countColumnDuplicates(int[][] mat, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
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