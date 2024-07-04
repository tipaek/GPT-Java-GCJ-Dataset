import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine().trim());
            List<List<Integer>> matrix = new ArrayList<>(N);

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                List<Integer> row = new ArrayList<>(N);
                while (st.hasMoreTokens()) {
                    row.add(Integer.parseInt(st.nextToken()));
                }
                matrix.add(row);
            }

            int trace = calculateTrace(matrix, N);
            int repX = calculateRowRepeats(matrix, N);
            int repY = calculateColumnRepeats(matrix, N);

            out.println("Case #" + (i + 1) + ": " + trace + " " + repX + " " + repY);
        }
        out.close();
    }

    private static int calculateTrace(List<List<Integer>> matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix.get(i).get(i);
        }
        return trace;
    }

    private static int calculateRowRepeats(List<List<Integer>> matrix, int N) {
        int repX = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                int value = matrix.get(i).get(j);
                if (seen[value]) {
                    repX++;
                    break;
                }
                seen[value] = true;
            }
        }
        return repX;
    }

    private static int calculateColumnRepeats(List<List<Integer>> matrix, int N) {
        int repY = 0;
        for (int j = 0; j < N; j++) {
            boolean[] seen = new boolean[N + 1];
            for (int i = 0; i < N; i++) {
                int value = matrix.get(i).get(j);
                if (seen[value]) {
                    repY++;
                    break;
                }
                seen[value] = true;
            }
        }
        return repY;
    }
}