
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int T = ni();
        int B = ni();
        for (int i = 1; i <= T; i++) {
            boolean[] base = new boolean[B];
            int nextIndex = 1;
            while (nextIndex < B) {
                System.out.println(1);
                int first = ni();
                for (int j = 0; j < 9 && nextIndex < B; j++) {
                    System.out.println(nextIndex + 1);
                    base[nextIndex] = ni() == first;
                    nextIndex++;
                }
            }
            System.out.println(1);
            int first = ni();
            StringBuilder ans = new StringBuilder();
            ans.append(first);
            for (int j = 1; j < B; j++) {
                ans.append(base[j] ? first : (1 - first));
            }
            System.out.println(ans.toString());
            String result = ns();
            if (result.equals("N")) {
                return;
            }
        }
    }

    static Scanner io = new Scanner(System.in);

    static int ni() {
        return io.nextInt();
    }

    static long nl() {
        return io.nextLong();
    }

    static String ns() {
        return io.next();
    }

    static int[] nia(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = ni();
        }
        return array;
    }

    static int[][] nim(int N, int cols) {
        int[][] matrix = new int[N][cols];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }
}
