import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int times=sc.nextInt();
		for(int i=1; i<=times; i++) { //case number
			int n=sc.nextInt();
			int[][] matrix=new int[n][n];
			for(int x=0; x<matrix.length; x++)
				for(int y=0; y<matrix.length; y++)
					matrix[x][y]=sc.nextInt();
			int k=0; //trace
			for(int j=0; j<matrix.length; j++)
				k+=matrix[j][j];
			int r=0;
			for(int[] a: matrix) {
				for(int z=0; z<a.length-1; z++)
					for(int o=z+1; o<a.length; o++)
						if(a[z]==a[o]) {
							r++;
							z=a.length;
							o=a.length;
						}
			}
			int c=0;
			for(int col=0; col<matrix.length; col++)
				for(int row=0; row<matrix.length-1; row++)
					for(int row2=row+1; row2<matrix.length; row2++)
						if(matrix[row][col]==matrix[row2][col]) {
							c++;
							row=matrix.length;
							row2=matrix.length;
						}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);
		}
		sc.close();
	}
}
