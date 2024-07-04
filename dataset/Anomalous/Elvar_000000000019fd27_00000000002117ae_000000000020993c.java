import java.util.Scanner;

public class CodeJamVestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int[][] matrix = new int[N][N];
            boolean[][] seenInColumn = new boolean[N + 1][N];
            boolean[] columnHasDuplicate = new boolean[N];
            boolean[][] seenInRow = new boolean[N][N + 1];
            boolean[] rowHasDuplicate = new boolean[N];
            
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int value = sc.nextInt();
                    matrix[row][col] = value;
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (seenInColumn[value][col] && !columnHasDuplicate[col]) {
                        columnDuplicates++;
                        columnHasDuplicate[col] = true;
                    }
                    seenInColumn[value][col] = true;
                    
                    if (seenInRow[row][value] && !rowHasDuplicate[row]) {
                        rowDuplicates++;
                        rowHasDuplicate[row] = true;
                    }
                    seenInRow[row][value] = true;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        sc.close();
    }
}