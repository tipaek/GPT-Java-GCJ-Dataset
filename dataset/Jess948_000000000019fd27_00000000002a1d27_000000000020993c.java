import java.utils.Scanner;
import java.utils.HashMap;

public class Solution {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in());
        
        int T = scan.nextInt();
        scan.nextLine();
        
        for (int k = 1; k <= T; k++) {
            
            int N = scan.nextInt();
            scan.nextLine();
            
            int diag = 0;
            int inp = 0;
            int[][] M = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    inp = scan.nextInt();
                    M[i][j] = inp;
                    
                    if (i == j) {
                        diag += inp;
                    }
                }
                scan.nextLine();
            }
            
            int row = 0;
            int col = 0;
            boolean rowRep = false;
            boolean colRep = false;
            
            for (int r = 0; r < N; r++) {
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (rowRep != true) {
                        rowRep = row.add(new Integer(M[r][c]));
                        if (rowRep == true) {
                            row++;
                        }                        
                    }
                    if (colRep != true) {
                        colRep = col.add(new Integer(M[c][r]));
                        if (colRep == true) {
                            row++;
                        }                        
                    }
                }
            }
            
            System.out.println("Case #" + k + ": " +
                diag + " " + row + " " + col);
        }
    }
}