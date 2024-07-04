import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Writer writer = new PrintWriter(System.out);
        
        int testCaseCount = scanner.nextInt();
        
        for (int t = 0; t < testCaseCount; t++) {
            int matrixSize = scanner.nextInt();
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();
            
            for (int i = 0; i < matrixSize; i++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }
            
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int element = scanner.nextInt();
                    rows.get(i).add(element);
                    columns.get(j).add(element);
                    if (i == j) {
                        trace += element;
                    }
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                if (rows.get(i).size() < matrixSize) {
                    rowDuplicates++;
                }
                if (columns.get(i).size() < matrixSize) {
                    columnDuplicates++;
                }
            }
            
            writer.write(String.format("Case #%d: %d %d %d", t + 1, trace, rowDuplicates, columnDuplicates));
            writer.write(System.lineSeparator());
            writer.flush();
        }
        
        writer.close();
        scanner.close();
    }
}