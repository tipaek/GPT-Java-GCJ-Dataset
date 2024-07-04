import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner fs=new Scanner(System.in);
		int T=fs.nextInt();
		for (int tt=1; tt<=T; tt++) {
			int n=fs.nextInt();
			int[][] a=new int[n][n];
			for (int i=0; i<n; i++) 
				for (int j=0; j<n; j++)
					a[i][j]=fs.nextInt();
			int sum=0;
			for (int i=0; i<n; i++) sum+=a[i][i];
			int illegalRows=0;
			for (int y=0; y<n; y++) {
				boolean[] seen=new boolean[n];
				for (int x=0; x<n; x++) {
					if (seen[a[x][y]-1]) {
						illegalRows++;
						break;
					}
					seen[a[x][y]-1]=true;
				}
			}
			int illegalCols=0;
			for (int x=0; x<n; x++) {
				boolean[] seen=new boolean[n];
				for (int y=0; y<n; y++) {
					if (seen[a[x][y]-1]) {
						illegalCols++;
						break;
					}
					seen[a[x][y]-1]=true;
				}
			}
			System.out.println("Case #"+tt+": "+sum+" "+illegalCols+" "+illegalRows);
		}
	}

}
