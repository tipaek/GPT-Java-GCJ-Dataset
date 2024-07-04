import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                rows.add(new HashSet<>());
                if (columns.size() < N) {
                    for (int j = 0; j < N; j++) {
                        columns.add(new HashSet<>());
                    }
                }
                
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    rows.get(i).add(value);
                    columns.get(j).add(value);
                }
                if (i < N - 1) {
                    scanner.nextLine(); // Consume the remaining newline
                }
            }
            
            for (Set<Integer> row : rows) {
                if (row.size() < N) {
                    rowRepeats++;
                }
            }
            
            for (Set<Integer> column : columns) {
                if (column.size() < N) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}