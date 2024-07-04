import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        
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
            boolean rowRep;
            boolean colRep;
            
            for (int r = 0; r < N; r++) {
                HashSet<Integer> rowSet = new HashSet<>();
                rowRep = true;
                for (int c = 0; c < N; c++) {
                    rowRep = rowSet.add(new Integer(M[r][c]));
                    if (rowRep == false) {
                        row++;
                        break;
                    }
                }
            }
            
            for (int r = 0; r < N; r++) {
                HashSet<Integer> colSet = new HashSet<>();
                colRep = true;
                for (int c = 0; c < N; c++) {
                    colRep = colSet.add(new Integer(M[c][r]));
                    if (colRep == false) {
                        col++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + k + ": " +
                diag + " " + row + " " + col);
        }
    }
}