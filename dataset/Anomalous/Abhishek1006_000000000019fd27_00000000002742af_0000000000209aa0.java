import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            processCase(N, K, i);
        }
    }

    private static void processCase(int size, int targetSum, int caseNumber) {
        int[][] latinSquare = new int[size][size];
        
        if (canFormLatinSquare(latinSquare, size, targetSum)) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printSquare(latinSquare, size);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static boolean canFormLatinSquare(int[][] square, int size, int targetSum) {
        int[] position = findEmptyCell(square, size);
        
        if (position == null) {
            return true;
        }

        int row = position[0];
        int col = position[1];

        for (int num = 1; num <= size; num++) {
            if (isValid(square, row, col, num, targetSum)) {
                square[row][col] = num;
                if (canFormLatinSquare(square, size, targetSum)) {
                    return true;
                }
                square[row][col] = 0;
            }
        }
        return false;
    }

    private static int[] findEmptyCell(int[][] square, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (square[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private static boolean isValid(int[][] square, int row, int col, int num, int targetSum) {
        for (int i = 0; i < square.length; i++) {
            if (square[row][i] == num || square[i][col] == num) {
                return false;
            }
        }

        int diagonalSum = 0;
        for (int i = 0; i < square.length; i++) {
            diagonalSum += square[i][i];
        }

        if (diagonalSum > targetSum) {
            return false;
        }

        if (row == square.length - 1 && col == square.length - 1 && diagonalSum + num != targetSum) {
            return false;
        }

        return true;
    }

    private static void printSquare(int[][] square, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(square[row][col] + " ");
            }
            System.out.println();
        }
    }
}