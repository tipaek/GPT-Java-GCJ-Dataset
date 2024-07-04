import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        for (int x = 0; x < n; x++) {
            int m = input.nextInt();
            input.nextLine(); // Consume the newline character
            int[][] a = new int[m][m];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Read the matrix and calculate trace
            for (int y = 0; y < m; y++) {
                String[] s = input.nextLine().split(" ");
                for (int z = 0; z < m; z++) {
                    a[y][z] = Integer.parseInt(s[z]);
                    if (z == y) {
                        trace += a[y][z];
                    }
                }
            }
            
            // Check for duplicate rows
            for (int y = 0; y < m; y++) {
                boolean[] seen = new boolean[m + 1];
                for (int z = 0; z < m; z++) {
                    if (seen[a[y][z]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[a[y][z]] = true;
                }
            }
            
            // Check for duplicate columns
            for (int y = 0; y < m; y++) {
                boolean[] seen = new boolean[m + 1];
                for (int z = 0; z < m; z++) {
                    if (seen[a[z][y]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[a[z][y]] = true;
                }
            }
            
            System.out.println("Case #" + (x + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}