import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LatinSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(scanner.nextLine());
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
                int[] rowOccurrences = new int[size + 1];
                int[] columnOccurrences = new int[size + 1];
                
                for (int j = 0; j < size; j++) {
                    rowOccurrences[matrix[i][j]]++;
                    columnOccurrences[matrix[j][i]]++;
                    
                    if (rowOccurrences[matrix[i][j]] == 2) {
                        repeatedRows++;
                    }
                    
                    if (columnOccurrences[matrix[j][i]] == 2) {
                        repeatedColumns++;
                    }
                }
            }
            
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
        
        scanner.close();
    }
}