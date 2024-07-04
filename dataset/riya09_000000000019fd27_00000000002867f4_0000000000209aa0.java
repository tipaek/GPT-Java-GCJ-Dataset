import java.io.*;
class Solution
{
    static int squares[][] = new int[60][60],n,k,t;
    static boolean rows[][] = new boolean[60][60];
    static boolean columns[][] = new boolean[60][60];
    static boolean flag;
    
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    for(t=1;t<=T;t++){
	        String str[] = br.readLine().trim().split("\\s+");
	        n = Integer.parseInt(str[0]);
	        k = Integer.parseInt(str[1]);
	        solve(1, 1, 0);
            if (!flag) {
                System.out.println("Case #" + t  + ": " + "IMPOSSIBLE");
            }
            flag = false;
    	    }
	}
	
	public static void solve(int row, int col, int m){
        if (row == n && col == n + 1 && m == k && !flag) {
        flag = true;
        System.out.println("Case #" + t + ": " + "POSSIBLE");
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print(squares[i][j] + " ");
            }
            System.out.println();
        }
        return;
    } else if (row > n) {
        return;
    } else if (col > n) {
        solve(row + 1, 1, m);
    }
    for (int i = 1; i <= n && !flag; ++i) {
        if (!rows[row][i] && !columns[col][i]) {
            rows[row][i] = columns[col][i] = true;
            if (row == col) {
                m += i;
            }
            squares[row][col] = i;

            solve(row, col + 1, m);

            rows[row][i] = columns[col][i] = false;
            if (row == col) {
                m -= i;
            }
            squares[row][col] = 0;
        }
    }
	}
}