import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 4/4/2020 AD
 * Time: 17:04
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0;
        while (x < t) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }

            int r = numRowOfRepeatedElements(mat);
            int c = numColOfRepeatedElements(mat);

            System.out.println("Case #" + (x + 1) + ": " + trace + " " + r + " " + c);
            x++;
        }
    }

    private static int numRowOfRepeatedElements(int[][] mat) {
        int n = mat.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet();
            for (int j = 0; j < n; j++) {
                if (set.contains(mat[i][j])) {
                    count++;
                    break;
                } else {
                    set.add(mat[i][j]);
                }
            }
        }

        return count;
    }

    private static int numColOfRepeatedElements(int[][] mat) {
        int n = mat.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet();
            for (int j = 0; j < n; j++) {
                if (set.contains(mat[j][i])) {
                    count++;
                    break;
                } else {
                    set.add(mat[j][i]);
                }
            }
        }

        return count;
    }
}
