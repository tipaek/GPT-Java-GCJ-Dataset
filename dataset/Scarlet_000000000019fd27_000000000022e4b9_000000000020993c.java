import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int testcount=scan.nextInt();
		int N=0;
		String output="";
		for(int i=1;i<=testcount;i++) {
			int T=0;
			N=scan.nextInt();
			int[][] matr = new int[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					matr[j][k] = scan.nextInt();
					if(j==k)
						T=T+matr[j][k];
				}
			}
			output=vestigium(N,matr);
		System.out.println("Case #"+i+": "+T+" "+output);
		}
		scan.close();
	}	
	public static String vestigium(int N,int[][] matr) {
		int rows=0,cols=0;
		int[] sortedrow = new int[N];
		int[] sortedcol = new int[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sortedrow[j] = matr[i][j];
				sortedcol[j] = matr[j][i];
			}
			Arrays.sort(sortedrow);
			Arrays.sort(sortedcol);
			for(int k=1;k<N;k++) {
				if(sortedrow[k-1]==sortedrow[k]) {
					rows++;
					break;
				}
			}
			for(int k=1;k<N;k++) {
				if(sortedcol[k-1]==sortedcol[k]) {
					cols++;
					break;
				}
			}
				
		}
		return rows+" "+cols ;
	}
}