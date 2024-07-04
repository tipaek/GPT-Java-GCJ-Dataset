import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution{
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}
	
	public void run() throws Exception
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(file.readLine());
		for(int z = 0;z<T;z++)
		{
			int N = Integer.parseInt(file.readLine());
			int[][] mat = new int[N][N];
			for(int i = 0;i<N;i++)
			{
				st = new StringTokenizer(file.readLine());
				for(int j = 0;j<N;j++)
				{
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int diag = 0;
			int R = 0;
			int C = 0;
			boolean[] row = new boolean[N];
			boolean[] col = new boolean[N];
			for(int i = 0;i<mat.length;i++)
			{
				Arrays.fill(row, false);
				Arrays.fill(col, false);
				diag += mat[i][i];
				boolean rflag = false;
				boolean cflag = false;
				for(int j = 0;j<N;j++)
				{
					if(row[mat[i][j] - 1] && !rflag) {
						rflag = true;
						R++;
					}
					row[mat[i][j] - 1] = true;
					if(col[mat[j][i]-1] && !cflag) {
						C++;
						cflag = true;
					}
					col[mat[j][i] - 1] = true;
				}
			}
			System.out.printf("Case #%d: %d %d %d%n", z+1, diag, R, C);
		}
	}
	
}
