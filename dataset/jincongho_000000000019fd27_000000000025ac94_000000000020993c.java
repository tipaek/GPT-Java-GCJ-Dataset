import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int cases = input.nextInt();
		
		for(int i=0; i<cases; i++)
		{
			int truce = 0;
			int rrepeat = 0;
			int crepeat = 0;
		
			int n = input.nextInt();
			int[][] rel = new int[n][n];
			int[][] cel = new int[n][n];
			boolean[] rdup = new boolean[n];
			boolean[] cdup = new boolean[n];
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					int el = input.nextInt();
					
					if(r==c)
						truce += el;
					
					rel[r][el-1]++;
					if(rel[r][el-1]>1)
						rdup[r] = true;
					cel[c][el-1]++;
					if(cel[c][el-1]>1)
						cdup[c] = true;
				}
			}
			
			for(int j=0;j<n;j++) {
				rrepeat += rdup[j] ? 1 : 0;
				crepeat += cdup[j] ? 1 : 0;
			}
			
			System.out.println(String.format("Case #%d: %d %d %d", (i+1), truce, rrepeat, crepeat));
		}
		
	}

}
