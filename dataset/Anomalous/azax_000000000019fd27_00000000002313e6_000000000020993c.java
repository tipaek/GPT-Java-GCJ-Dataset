import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());
        for (int index = 0; index < numCases; index++) {
            int size = Integer.parseInt(sc.nextLine());
            
            int trace = 0;
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
                trace += matrix[i][i];
            }
            
            int[] badCounts = checkMatrix(matrix);
            int badRows = badCounts[0];
            int badCols = badCounts[1];
            System.out.println("Case #" + (index + 1) + ": " + trace + " " + badRows + " " + badCols);
        }
        sc.close();
    }

    private static int[] checkMatrix(int[][] matrix) {
        int badRows = 0;
        int badCols = 0;
        int size = matrix.length;
    
        for (int i = 0; i < size; i++) {
            boolean[] seenInRow = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                int val = matrix[i][j];
                if (seenInRow[val]) {
                    badRows++;
                    break;
                }
                seenInRow[val] = true;
            }
        }
    
        for (int j = 0; j < size; j++) {
            boolean[] seenInCol = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                int val = matrix[i][j];
                if (seenInCol[val]) {
                    badCols++;
                    break;
                }
                seenInCol[val] = true;
            }
        }
        
        return new int[] { badRows, badCols };
    }
}