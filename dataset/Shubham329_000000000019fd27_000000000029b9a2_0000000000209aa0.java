import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] matrix = new int[N][N];
            list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    matrix[j][k] = (j + k) % N + 1;
            }
            if (rows(matrix, new HashSet<>(), K, 0)) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(matrix[list.get(j)][k] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean rows(int[][] matrix, Set<Integer> set, int K, int cnt) {
        if (possible(matrix, new HashSet<>(), 0, K, 0))
            return true;
        if (cnt >= matrix.length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (!set.contains(j)) {
                    set.add(j);
                    change(i + 1, j + 1, matrix);
                    if (rows(matrix, set, K, cnt + 1))
                        return true;
                    change(j + 1, i + 1, matrix);
                    set.remove(j);
                }
            }
        }
        return false;
    }

    private static void change(int a, int b, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == a)
                    matrix[i][j] = b;
                else if (matrix[i][j] == b)
                    matrix[i][j] = a;
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
