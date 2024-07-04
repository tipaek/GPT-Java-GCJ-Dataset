
import java.util.Scanner;

public class Solution {

    static int max(int[] digits) {
        int max = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > max) max = digits[i];
        }
        return max;
    }

    static String solve(String S) {
        int[] digits = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            digits[i] = S.charAt(i) - '0';
        }
        int max = max(digits);
        int[] opening = new int[S.length()];
        int[] closing = new int[S.length()];
        while (max > 0) {
            boolean opened = false;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == max) {
                    if (opened) {
                        // noop
                    } else {
                        opened = true;
                        opening[i]++;
                    }
                    digits[i]--;
                } else {
                    if (opened) {
                        opened = false;
                        closing[i-1]++;
                    }
                }
            }
            if (opened) {
                closing[digits.length - 1]++;
            }
            max = max(digits);
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < opening[i]; j++) {
                builder.append('(');
            }
            builder.append(S.charAt(i));
            for (int j = 0; j < closing[i]; j++) {
                builder.append(')');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int T = ni();
        for (int i = 1; i <= T; i++) {
            String S = ns();
            System.out.println("Case #" + i + ": " + solve(S));
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
