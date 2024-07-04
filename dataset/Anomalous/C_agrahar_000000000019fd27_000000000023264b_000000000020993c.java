import java.util.Scanner;

public class LatinSquares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n number: ");
        int n = scanner.nextInt();
        char[][] matrix = new char[n][n];
        
        System.out.println("Enter the characters for the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        
        if (checkLatinSquare(matrix)) {
            System.out.println("The matrix is a Latin square.");
        } else {
            System.out.println("The matrix is not a Latin square.");
        }
    }

    public static boolean checkLatinSquare(char[][] matrix) {
        int n = matrix.length;

        // Check if grid has valid letters
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isValidLetter(matrix[i][j], n)) {
                    return false;
                }
            }
        }

        // Check if every row has unique letters
        for (int i = 0; i < n; i++) {
            if (!isRowValid(matrix, i)) {
                return false;
            }
        }

        // Check if every column has unique letters
        for (int j = 0; j < n; j++) {
            if (!isColumnValid(matrix, j)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRowValid(char[][] matrix, int row) {
        int n = matrix.length;
        boolean[] seen = new boolean[n];
        
        for (int j = 0; j < n; j++) {
            int index = matrix[row][j] - 'A';
            if (seen[index]) {
                return false;
            }
            seen[index] = true;
        }
        
        return true;
    }

    public static boolean isColumnValid(char[][] matrix, int column) {
        int n = matrix.length;
        boolean[] seen = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            int index = matrix[i][column] - 'A';
            if (seen[index]) {
                return false;
            }
            seen[index] = true;
        }
        
        return true;
    }

    public static boolean isValidLetter(char ch, int n) {
        return ch >= 'A' && ch < 'A' + n;
    }
}