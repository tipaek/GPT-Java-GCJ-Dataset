import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            String[] inputArray = new String[size];
            
            for (int j = 0; j < size; j++) {
                inputArray[j] = scanner.nextLine();
            }
            
            int[][] matrix = createMatrix(inputArray);
            printSolution(i, matrix);
        }

        scanner.close();
    }

    public static void printSolution(int testCase, int[][] matrix) {
        int diag = calculateDiagonalSum(matrix);
        int rowDuplicates = countRowDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        System.out.printf("Case #%d: %d %d %d\n", testCase, diag, rowDuplicates, columnDuplicates);
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int counter = 0;
        int size = matrix.length;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                if (!set.add(matrix[j][i])) {
                    counter++;
                    break;
                }
            }
        }
        
        return counter;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int counter = 0;
        int size = matrix.length;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                if (!set.add(matrix[i][j])) {
                    counter++;
                    break;
                }
            }
        }
        
        return counter;
    }

    public static int[][] createMatrix(String[] input) {
        int size = input.length;
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            String[] temp = input[i].split(" ");
            
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        
        return matrix;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        
        return sum;
    }
}