import java.io.*;
public class Solution
{
    static int n, m, t;
    static int[][] arr = new int[100][100];
    static boolean[][] rowValid = new boolean[100][100];
    static boolean[][] colValid = new boolean[100][100];
   
    static int flag = 0;
    static void check(int r, int c, int s) {
    if (r == n && c == n + 1 && s == m && flag==0) {
        flag = 1;
        System.out.println("Case #"+(t+1)+":"+"POSSIBLE"); 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return;
    } else if (r > n) {
        return;
    } else if (c > n) {
        check(r+1, 1, s);
    }
    for (int i = 1; i <= n && flag==0; i++) {
        if (rowValid[r][i]==false && colValid[c][i]==false) {
            rowValid[r][i] = true;
            colValid[c][i] = true;
            if (r == c) {
                s += i;
            }
            arr[r][c] = i;

            check(r, c+1,s);

            rowValid[r][i] = false;
            colValid[c][i] = false;
            if (r == c) {
                s -= i;
            }
            arr[r][c] = 0;
        }
    }
}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int input = Integer.parseInt(br.readLine());
	    int t = 0;
	    while(t<input)
	    {
	        String[] str = br.readLine().split(" ");
	        n = Integer.parseInt(str[0]);
	        m = Integer.parseInt(str[1]);
	        check(1,1,0);
	        if(flag==0)
	            System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
	       flag = 0;
	       t++;
	    }
		
	}
}