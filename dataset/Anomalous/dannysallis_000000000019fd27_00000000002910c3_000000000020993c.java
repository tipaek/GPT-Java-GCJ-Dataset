import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LatinSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine()); // number of test cases
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = Integer.parseInt(scanner.nextLine()); // size of the matrix
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[size + 1];
                boolean[] columnCheck = new boolean[size + 1];
                
                for (int j = 0; j < size; j++) {
                    // Check for repeated elements in the row
                    if (rowCheck[matrix[i][j]]) {
                        repeatedRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                    
                    // Check for repeated elements in the column
                    if (columnCheck[matrix[j][i]]) {
                        repeatedColumns++;
                        break;
                    }
                    columnCheck[matrix[j][i]] = true;
                }
            }
            
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}