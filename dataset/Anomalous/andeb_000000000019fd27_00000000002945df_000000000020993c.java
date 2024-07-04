import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        
        for (int cc = 1; cc <= cases; cc++) {
            int d = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[d][d];
            
            for (int i = 0; i < d; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < d; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < d; i++) {
                trace += matrix[i][i];
            }

            int rowRepeats = 0;
            for (int i = 0; i < d; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < d; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            int colRepeats = 0;
            for (int i = 0; i < d; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < d; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", cc, trace, rowRepeats, colRepeats);
        }
    }
}