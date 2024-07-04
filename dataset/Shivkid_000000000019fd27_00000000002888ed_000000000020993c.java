import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int count=0;
		while(t>0) {
			count++;
			int N=s.nextInt();
			int[][] matrix=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					matrix[i][j]=s.nextInt();
				}
			}
			TreeSet<Integer> rowredundency=new TreeSet<Integer>();
			TreeSet<Integer> colredundency=new TreeSet<Integer>();
			int rowcount=0;
			int colcount=0;
			int sum=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					rowredundency.add(matrix[i][j]);
					colredundency.add(matrix[j][i]);
				}
				if(rowredundency.size()!=N) {
					rowcount++;
				}
				if(colredundency.size()!=N) {
					colcount++;
				}
				rowredundency.clear();
				colredundency.clear();
			}
			for(int i=0;i<N;i++) {
				sum=sum+matrix[i][i];
			}
			System.out.println("Case #"+count+": "+sum+" "+rowcount+" "+colcount);
			t--;
		}

	}

}
