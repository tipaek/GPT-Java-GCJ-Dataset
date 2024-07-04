import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        int testCasesCount = scanner.nextInt();
        while(i <= testCasesCount){
            int sizeOfMatrix = scanner.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            solution.populateMatrix(matrix, scanner);

            int trace = solution.computeTrace(matrix);
            int columnsWithDuplicates = solution.countColumnsWithDuplicates(matrix);
            int rowsWithDuplicates = solution.countRowsWithDuplicates(matrix);

            System.out.print("Case #" + i + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
            System.out.println();
            i++;
        }
    }

    public int countColumnsWithDuplicates(int[][] matrix){
        int duplicateValColCount = 0;
        for(int j = 0; j < matrix[0].length; j++){
            Set<Integer> valsInCol = new HashSet<Integer>();
            for(int i = 0; i < matrix.length; i++){
                if(valsInCol.contains(matrix[i][j])){
                    duplicateValColCount++;
                    break;
                }
                valsInCol.add(matrix[i][j]);
            }
        }
        return duplicateValColCount;
    }

    public int countRowsWithDuplicates(int[][] matrix){
        int duplicateValRowCount = 0;
        for(int i = 0; i < matrix.length; i++){
            Set<Integer> valsInRow = new HashSet<Integer>();
            for(int j = 0; j < matrix[0].length; j++){
                if(valsInRow.contains(matrix[i][j])){
                    duplicateValRowCount++;
                    break;
                }
                valsInRow.add(matrix[i][j]);
            }
        }
        return duplicateValRowCount;
    }

    public int computeTrace(int[][] matrix){
        int trace = 0;
        for(int i = 0; i < matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;
    }

    public void populateMatrix(int[][] matrix, Scanner scanner){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
