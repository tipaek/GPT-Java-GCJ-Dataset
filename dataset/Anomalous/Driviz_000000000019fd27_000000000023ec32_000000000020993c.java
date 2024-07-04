import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() != size) {
                    rowDuplicates++;
                }
                if (colSet.size() != size) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}