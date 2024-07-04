import java.io.*;
public class Main
{
    static int sqr[][] = new int[60][60],n,k,t;
    static boolean row_safe[][] = new boolean[60][60];
    static boolean col_safe[][] = new boolean[60][60];
    static boolean solved;
    
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    for(t=1;t<=T;t++){
	        String str[] = br.readLine().trim().split("\\s+");
	        n = Integer.parseInt(str[0]);
	        k = Integer.parseInt(str[1]);
	        solver(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + t  + ": " + "IMPOSSIBLE");
            }
            solved = false;
    	    }
	}
	
	public static void solver(int row, int col, int m){
        if (row == n && col == n + 1 && m == k && !solved) {
        solved = true;
        System.out.println("Case #" + t + ": " + "POSSIBLE");
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print(sqr[i][j] + " ");
            }
            System.out.println();
        }
        return;
    } else if (row > n) {
        return;
    } else if (col > n) {
        solver(row + 1, 1, m);
    }
    for (int i = 1; i <= n && !solved; ++i) {
        if (!row_safe[row][i] && !col_safe[col][i]) {
            row_safe[row][i] = col_safe[col][i] = true;
            if (row == col) {
                m += i;
            }
            sqr[row][col] = i;

            solver(row, col + 1, m);

            row_safe[row][i] = col_safe[col][i] = false;
            if (row == col) {
                m -= i;
            }
            sqr[row][col] = 0;
        }
    }
	}
}