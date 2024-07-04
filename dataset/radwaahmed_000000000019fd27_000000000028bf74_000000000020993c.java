import java.util.Scanner;

public class Solution {
	
	public static int DiagonalSum(int[][] M) {
		int sum =0;
		for(int j =0 ;j< M.length;j++) {
			sum += M[j][j];
		}
		return sum;
	}
	public static boolean down (int row,int column,int[][] M) {
		if(row==M.length-1) {return false;}
		for(int i=row+1 ;i<M.length;i++) {
			if(M[row][column]==M[i][column]) {
				return true;
			}
		}
		return false;
	}
	public static boolean right (int row,int column,int[][] M) {
		if(column==M.length-1) {return false;}
		for(int i=column+1 ;i<M.length;i++) {
			if(M[row][column]==M[row][i]) {
				return true;
			}
		}
		return false;
	}
	public static int[] ReapetedRowsColumns (int[][] M) {
		int R=0,C=0;
		int[][] N = new int[2][M.length];
		for(int i =0;i<M.length;i++) {
			for(int j=0;j<M.length;j++) {
				if(down(i,j,M)) {
					N[1][j]=N[1][j]+1;
				}
				if(right(i,j,M)) {
					N[0][i]=N[0][i]+1;
				}
			}
		}
		for(int i=0;i<M.length;i++) {
			if(N[0][i]>0) {
				R++;
			}
			if(N[1][i]>0) {
				C++;
			}
		}
		int[] i = {R,C};
		return i;
	}
	public static void main(String[] args) {
		Scanner input=new Scanner (System .in);
		int Cases = input.nextInt();
		int[][] cases = new int[Cases][3];
		for(int k =0;k<Cases;k++) {
			int Size = input.nextInt();
			int[][] M = new int[Size][Size];
			for(int i=0;i<Size ;i++) {
				for(int j =0 ;j< Size ;j++) {
					M[i][j]=input.nextInt();
				}
				System.out.println();
			}
			cases[k][0]= DiagonalSum(M);
			int[] t= ReapetedRowsColumns(M); 
			cases[k][1]= t[0];
			cases[k][2] =t[1];
			
		}
		for(int i =0 ;i<cases.length;i++) {
			System.out.println("Case #"+(i+1)+":"+" "+cases[i][0]+" "+cases[i][1]+" "+cases[i][2]);
		}
	}

}
