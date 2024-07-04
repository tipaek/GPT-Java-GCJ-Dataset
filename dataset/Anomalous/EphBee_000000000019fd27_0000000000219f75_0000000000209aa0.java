import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
            int N = scanner.nextInt();
            int trace = scanner.nextInt();

            int[][] matrix = new int[N][N];
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
                for (int j = 1; j <= N; j++) {
                    rows.get(i).add(j);
                    columns.get(i).add(j);
                }
            }

            int remainingTrace = trace;
            for (int i = 0; i < N; i++) {
                int value = (int) ((remainingTrace / 2.0) + 0.5);
                matrix[i][i] = value;
                remainingTrace -= value;
                rows.get(i).remove(value);
                columns.get(i).remove(value);
            }

            boolean isImpossible = false;
            for (int i = 0; i < N && !isImpossible; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    int value = 1;
                    while (!rows.get(i).contains(value) || !columns.get(j).contains(value)) {
                        value++;
                        if (value > N) {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) break;

                    matrix[i][j] = value;
                    rows.get(i).remove(value);
                    columns.get(j).remove(value);
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}