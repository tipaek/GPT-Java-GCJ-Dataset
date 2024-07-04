import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TraceMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tests = br.readLine();
        if (tests == null) return;
        
        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                String line = br.readLine();
                matrix[row] = Stream.of(line.split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            }
            
            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);
            
            sb.append("case #").append(i).append(": ")
              .append(trace).append(" ")
              .append(duplicateRows).append(" ")
              .append(duplicateColumns).append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }
    
    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}