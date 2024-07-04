import java.util.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            int[][] matrix = new int[n][n];
            
            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Checking for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scan.close();
    }
}