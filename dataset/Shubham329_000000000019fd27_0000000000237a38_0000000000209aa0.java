import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] matrix = new int[N][N];
            String str = "";

            for (int j = 1; j <= N; j++) {
                str += j;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    matrix[j][k] = str.charAt(k) - '0';
                str = str.substring(str.length() - 1) + str.substring(0, str.length() - 1);
            }

            if (possible(matrix, new HashSet<>(), 0, K, 0)) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(matrix[list.get(j)][k]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean possible(int[][] matrix, Set<Integer> set, int c, int K, int sum) {
        if (c >= matrix.length) {
            return sum == K;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(i);
                if (possible(matrix, set, c + 1, K, sum + matrix[i][c])) {
                    return true;
                }
                list.remove(list.size() - 1);
                set.remove(i);
            }
        }
        return false;
    }
}
