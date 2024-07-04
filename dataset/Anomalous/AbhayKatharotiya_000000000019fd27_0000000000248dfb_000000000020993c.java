import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            List<String> inputLines = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                inputLines.add(scanner.nextLine());
            }
            
            List<List<Integer>> matrix = new ArrayList<>();
            for (String line : inputLines) {
                String[] values = line.split(" ");
                List<Integer> row = new ArrayList<>();
                
                for (String value : values) {
                    row.add(Integer.parseInt(value));
                }
                
                matrix.add(row);
            }
            
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix.get(i).get(i);
            }
            
            int rowDuplicates = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!seen.add(matrix.get(i).get(j))) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            int colDuplicates = 0;
            for (int j = 0; j < size; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!seen.add(matrix.get(i).get(j))) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            results.add(String.format("Case #%d: %d %d %d", t, trace, rowDuplicates, colDuplicates));
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}