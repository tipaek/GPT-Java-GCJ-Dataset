import java.util.Scanner;
import java.io.*;

class Solution {
    public static int[][] M;
    public static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= T; ++i) {
            String[] in = input.nextLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int K = Integer.parseInt(in[1]);
            M = new int[N][N];
            result.append(solve(i, K, N)).append("\n");
        }
        System.out.print(result);
    }

    public static String solve(int num, int K, int N) {
        int trace = 0;
        int check = 0;
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            check += K / N;
        }
        
        if (check != K) {
            return "Case #" + num + ": IMPOSSIBLE";
        }

        int k = N;
        for (int i = 1; i <= N; i++) {
            int temp = k;
            while (temp <= N) {
                out.append(temp).append(" ");
                temp++;
            }
            for (int j = 1; j < k; j++) {
                out.append(j).append(" ");
            }
            k--;
            out.append("\n");
        }

        String[] rows = out.toString().split("\n");
        String[][] table = new String[rows.length][rows.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = rows[i].split(" ");
            for (int j = 0; j < table.length; j++) {
                M[i][j] = Integer.parseInt(table[i][j]);
            }
        }

        flipInPlace(M);
        out = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                out.append(M[i][j]).append(" ");
            }
            if (i != table.length - 1)
                out.append("\n");
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i == j) {
                    trace += M[i][j];
                }
            }
        }

        if (trace != K) {
            return "Case #" + num + ": IMPOSSIBLE";
        }

        for (int i = 0; i < M.length; i++) {
            if (hasDuplicates(M[i])) {
                return "Case #" + num + ": IMPOSSIBLE";
            }
            int[] column = new int[M[i].length];
            for (int j = 0; j < M.length; j++) {
                column[j] = M[j][i];
            }
            if (hasDuplicates(column)) {
                return "Case #" + num + ": IMPOSSIBLE";
            }
        }

        return "Case #" + num + ": POSSIBLE\n" + out.toString();
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void flipInPlace(int[][] theArray) {
        int n = theArray.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = theArray[i];
            theArray[i] = theArray[n - i - 1];
            theArray[n - i - 1] = temp;
        }
    }
}