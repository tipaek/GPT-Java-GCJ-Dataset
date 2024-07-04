import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] N = new int[T];
        int[][][] M = new int[T][100][100];

        for (int i = 0; i < T; i++) {
            N[i] = scanner.nextInt();
            for (int a = 0; a < N[i]; a++) {
                for (int b = 0; b < N[i]; b++) {
                    M[i][a][b] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            boolean[] rowCheck = new boolean[100];
            boolean[] colCheck = new boolean[100];

            for (int a = 0; a < N[i]; a++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowFlag = false;
                boolean colFlag = false;

                for (int b = 0; b < N[i]; b++) {
                    if (a == b) {
                        trace += M[i][a][b];
                    }
                    if (!rowSet.add(M[i][a][b]) && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                    if (!colSet.add(M[i][b][a]) && !colFlag) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}