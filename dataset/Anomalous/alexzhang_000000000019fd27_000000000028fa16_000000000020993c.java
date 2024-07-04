import java.io.*;
import java.util.*;

public class GCJ {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            System.out.print("Case #" + testCase + ": ");
            int trace = 0;

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            System.out.print(trace + " ");
            int duplicateColumns = 0;
            int duplicateRows = 0;

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();

                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }

                for (int j = 0; j < size; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println(duplicateRows + " " + duplicateColumns);
        }
    }
}