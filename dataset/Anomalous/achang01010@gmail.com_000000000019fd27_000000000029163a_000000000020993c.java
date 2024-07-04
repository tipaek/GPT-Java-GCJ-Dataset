import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            
            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            // Calculate the number of rows with repeated elements
            int rowRepeats = 0;
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            // Calculate the number of columns with repeated elements
            int colRepeats = 0;
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            // Print the result for the current case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}