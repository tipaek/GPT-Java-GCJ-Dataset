import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            int[][] matrix = new int[size][size];
            
            // Reading matrix and calculating trace
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = true;
                
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    if (!rowSet.add(matrix[i][j]) && rowFlag) {
                        rowFlag = false;
                        rowRepeats++;
                    }
                }
            }
            
            // Checking for column repeats
            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}