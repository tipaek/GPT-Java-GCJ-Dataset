import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int[][] flist = new int[d][d];
            int k = 0, r = 0, c = 0;

            for (int j = 0; j < d; j++) {
                for (int l = 0; l < d; l++) {
                    flist[j][l] = scanner.nextInt();
                }
                if (hasDuplicates(flist[j])) {
                    r++;
                }
            }

            for (int j = 0; j < d; j++) {
                k += flist[j][j];
            }

            for (int j = 0; j < d; j++) {
                int[] column = new int[d];
                for (int l = 0; l < d; l++) {
                    column[l] = flist[l][j];
                }
                if (hasDuplicates(column)) {
                    c++;
                }
            }

            results.add(new int[]{i + 1, k, r, c});
        }

        for (int[] result : results) {
            System.out.printf("Case #%d: %d %d %d%n", result[0], result[1], result[2], result[3]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}