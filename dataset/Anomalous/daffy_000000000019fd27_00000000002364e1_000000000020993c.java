import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(in.nextLine());
            int trace = 0;
            int[][] matrix = new int[n][n];
            int[] check = new int[n];
            int rowRepeats = 0;
            int colRepeats = 0;
            
            for (int j = 0; j < n; j++) {
                String[] row = in.nextLine().split(" ");
                boolean rowHasDuplicate = false;
                Arrays.fill(check, 0);
                
                for (int k = 0; k < n; k++) {
                    int value = Integer.parseInt(row[k]);
                    matrix[j][k] = value;
                    if (j == k) {
                        trace += value;
                    }
                    if (++check[value - 1] > 1) {
                        rowHasDuplicate = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }
            
            for (int k = 0; k < n; k++) {
                boolean colHasDuplicate = false;
                Arrays.fill(check, 0);
                
                for (int j = 0; j < n; j++) {
                    int value = matrix[j][k];
                    if (++check[value - 1] > 1) {
                        colHasDuplicate = true;
                    }
                }
                
                if (colHasDuplicate) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        in.close();
    }
}