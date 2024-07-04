import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += A[i][i];
            }

            int rowRepeats = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    uniqueElements.add(A[i][j]);
                }
                if (uniqueElements.size() < N) {
                    rowRepeats++;
                }
            }

            int colRepeats = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    uniqueElements.add(A[j][i]);
                }
                if (uniqueElements.size() < N) {
                    colRepeats++;
                }
            }

            writer.printf("Case #%d: %d %d %d%n", cs, trace, rowRepeats, colRepeats);
        }
        writer.flush();
        writer.close();
    }
}