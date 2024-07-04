import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		for(int t=1;t<=test;t++) {
			int ans_add=0;
			int n=in.nextInt();
			int mat[][]=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					mat[i][j]=in.nextInt();
					if(i==j) ans_add+=mat[i][j];
				}
			}
			int max_row=0, max_col=0;
			for(int i=0;i<n;i++) {
				int cnt_row[]=new int[n+1];
				int cnt_col[]=new int[n+1];
				for(int j=0;j<n;j++) {
					cnt_row[mat[i][j]]++;
					cnt_col[mat[j][i]]++;
				}
				Arrays.parallelSort(cnt_row);
				Arrays.parallelSort(cnt_col);
				if(cnt_row[n]!=1 && max_row<cnt_row[n])
					max_row=cnt_row[n];
				if(cnt_col[n]!=1 && max_col<cnt_col[n])
					max_col=cnt_col[n];
			}
			System.out.println("Case #"+t+": "+ans_add+" "+max_row+" "+max_col);
		}
	}
}
