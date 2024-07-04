import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int nCases = Integer.parseInt(br.readLine());

            for (int i = 0; i < nCases; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] mat = new int[N][N];
                int trace = 0, rowDuplicates = 0, colDuplicates = 0;

                for (int r = 0; r < N; r++) {
                    String[] rowValues = br.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();

                    for (int c = 0; c < N; c++) {
                        int num = Integer.parseInt(rowValues[c]);
                        mat[r][c] = num;
                        if (r == c) trace += num;
                        if (!rowSet.add(num)) {
                            rowDuplicates++;
                            break;
                        }
                    }
                }

                for (int c = 0; c < N; c++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int r = 0; r < N; r++) {
                        if (!colSet.add(mat[r][c])) {
                            colDuplicates++;
                            break;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}