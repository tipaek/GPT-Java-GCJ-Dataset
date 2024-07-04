import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] N = new int[T];
        int[][] M;
        int[] trace = new int[T];
        int[] rowRepeats = new int[T];
        int[] colRepeats = new int[T];

        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            M = new int[N[i]][N[i]];
            trace[i] = 0;

            for (int j = 0; j < N[i]; j++) {
                for (int k = 0; k < N[i]; k++) {
                    M[j][k] = sc.nextInt();
                    if (j == k) {
                        trace[i] += M[j][k];
                    }
                }
            }

            rowRepeats[i] = countRowRepeats(M, N[i]);
            colRepeats[i] = countColRepeats(M, N[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowRepeats[i] + " " + colRepeats[i]);
        }
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }
        return colRepeats;
    }
}