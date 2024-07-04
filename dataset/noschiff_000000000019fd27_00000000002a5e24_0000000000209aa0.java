import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.valueOf(input[0]);
            int K = Integer.valueOf(input[1]);

            if (K % N == N - 1 || K - N == 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int[][] array = new int[N][N];
                Random random = new Random();
                while (true) {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            array[j][k] = random.nextInt(N) + 1;
                        }
                    }
                    if (K == trace(array) && !row(array) && !col(array)) {
                        break;
                    }
                }
                StringBuilder out = new StringBuilder();
                for (int j = 0; j < array.length; j++) {
                    for (int k = 0; k < array[j].length; k++) {
                        out.append(array[j][k]);
                        if (k < array[j].length - 1) {
                            out.append(" ");
                        }
                    }
                    if (j < array.length - 1) {
                        out.append("\n");
                    }
                }
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                System.out.println(out);
            }
        }
    }

    private static int trace(int[][] square) {
        int k = 0;
        for (int i = 0; i < square.length; i++) {
            k += square[i][i];
        }
        return k;
    }

    private static boolean row(int[][] square) {
        ArrayList<Integer> used;
        for (int row = 0; row < square.length; row++) {
            used = new ArrayList<>();
            for (int i = 0; i < square[row].length; i++) {
                if (used.contains(square[row][i])) {
                    return true;
                } else {
                    used.add(square[row][i]);
                }
            }
        }
        return false;
    }

    private static boolean col(int[][] square) {
        ArrayList<Integer> used;
        for (int col = 0; col < square.length; col++) {
            used = new ArrayList<>();
            for (int row = 0; row < square.length; row++) {
                if (used.contains(square[row][col])) {
                    return true;
                } else {
                    used.add(square[row][col]);
                }
            }
        }
        return false;
    }
}
