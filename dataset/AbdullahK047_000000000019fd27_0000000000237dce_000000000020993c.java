import java.util.Scanner;

public class Vestigium {
    private static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] mtx = new int[y][y];
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                mtx[i][j] = scanner.nextInt();
            }
        }
        
        int trace = traceFunc(mtx);
        
        
        
    }
    
    public int traceFunc(int[][] mrx) {
        int z;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                if (i=j) {
                    z += mrx[i][j];
                }
            }
        }
        return z;
    }
    
    public int rowRpt(int[] row) {
        int z;
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if (i != j) {
                    if (row[i] == row[j]) {
                        z++;
                    }
                }
            }
            
        }
        
        
    }
    
}