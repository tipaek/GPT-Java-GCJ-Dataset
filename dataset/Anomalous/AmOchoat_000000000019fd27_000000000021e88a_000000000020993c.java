import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixAnalysis {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[][] matrix;
        
        try {
            System.out.println("Enter number of cases:");
            int cases = Integer.parseInt(reader.readLine().trim());
            
            for (int i = 0; i < cases; i++) {
                System.out.println("Enter matrix size:");
                int n = Integer.parseInt(reader.readLine().trim());
                matrix = new Integer[n][n];
                
                for (int row = 0; row < n; row++) {
                    System.out.println("Enter row " + (row + 1) + ":");
                    String[] rowData = reader.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(rowData[col]);
                    }
                }
                
                int diagonalSum = 0;
                for (int j = 0; j < n; j++) {
                    diagonalSum += matrix[j][j];
                }
                
                int duplicateColumns = 0;
                for (int col = 0; col < n; col++) {
                    boolean[] seen = new boolean[n + 1];
                    for (int row = 0; row < n; row++) {
                        if (seen[matrix[row][col]]) {
                            duplicateColumns++;
                            break;
                        }
                        seen[matrix[row][col]] = true;
                    }
                }
                
                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    boolean[] seen = new boolean[n + 1];
                    for (int col = 0; col < n; col++) {
                        if (seen[matrix[row][col]]) {
                            duplicateRows++;
                            break;
                        }
                        seen[matrix[row][col]] = true;
                    }
                }
                
                System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateColumns + " " + duplicateRows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}