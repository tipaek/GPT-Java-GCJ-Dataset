import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for(int k=0; k<tc; k++){
			int size=sc.nextInt();
			int[][] mat = new int[size][size];
			for(int i=0; i<size; i++)
				for(int j=0; j<size; j++)
					mat[i][j]=sc.nextInt();
			findlatinsquere(mat, size, k+1);
		}
	}

	private static void findlatinsquere(int[][] mat, int size, int k) {
		// TODO Auto-generated method stub
		int diag=0;
		Set<Integer> colSet; 
		Set<Integer> rowSet;
		int rowCount=0;
		int colCount=0;
		boolean row=false, col=false;
		for(int i=0; i<size; i++){
			rowSet = new HashSet<Integer>();
			colSet = new HashSet<Integer>();
			row=false; col=false;
			for(int j=0; j<size; j++){
				if(i==j){
					diag=diag+mat[i][j];
				}
				if(rowSet.contains(mat[i][j]) && row==false){
					rowCount++;
					row=true;
				}
				rowSet.add(mat[i][j]);
				if(colSet.contains(mat[j][i]) && col==false){
					colCount++;
					col=true;
				}
				colSet.add(mat[j][i]);
			}
			}
		System.out.println("Case #"+k+": "+diag+" "+rowCount+" "+colCount);
	}

}
