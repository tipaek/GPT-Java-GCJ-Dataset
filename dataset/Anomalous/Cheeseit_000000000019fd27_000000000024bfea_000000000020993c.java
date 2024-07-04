import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] inputArray = new String[size];
            
            for (int j = 0; j < size; j++) {
                inputArray[j] = scanner.nextLine();
            }
            
            int[][] matrix = createMatrix(inputArray);
            printSolution(i, matrix);
        }
        
        scanner.close();
    }

    private static void printSolution(int testCase, int[][] matrix) {
        int diagSum = calculateDiagonalSum(matrix);
        int rowDuplicates = countRowDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        System.out.printf("Case #%d: %d %d %d\n", testCase, diagSum, rowDuplicates, columnDuplicates);
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            
            for (int j = 0; j < matrix.length; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            
            for (int j = 0; j < matrix.length; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }

    private static int[][] createMatrix(String[] input) {
        int size = input.length;
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            String[] elements = input[i].split(" ");
            
            for (int j = 0; j < elements.length; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
        
        return matrix;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        
        return sum;
    }
}