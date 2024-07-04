import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            System.out.println("CASE #" + (t + 1) + ":");
            int[][] pascalTriangle = generatePascalTriangle(35);
            
            if (N == 1) {
                System.out.println("1 1");
            } else if (N == 2) {
                System.out.println("1 1");
                System.out.println("2 1");
            } else if (N <= 124252) {
                solveForN(N);
            }
        }
    }
    
    private static int[][] generatePascalTriangle(int size) {
        int[][] triangle = new int[size][];
        triangle[1] = new int[] { 0, 1 };
        
        for (int r = 2; r < size; r++) {
            int[] row = new int[r + 1];
            row[1] = 1;
            row[r] = 1;
            
            for (int c = 2; c < r; c++) {
                row[c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
            }
            
            triangle[r] = row;
        }
        
        return triangle;
    }
    
    private static void solveForN(int N) {
        System.out.println("1 1");
        int remaining = N - 1;
        int row = 2;
        
        while (true) {
            int value = row - 1;
            if (remaining >= value) {
                System.out.println(row + " " + (row - 1));
                remaining -= value;
                row++;
            } else {
                row--;
                break;
            }
        }
        
        if (remaining > 0) {
            System.out.println(row + " " + row);
            row++;
            remaining--;
        }
        
        while (remaining > 0) {
            System.out.println(row + " " + row);
            row++;
            remaining--;
        }
    }
}