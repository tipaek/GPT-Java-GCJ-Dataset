import java.util.Scanner;

public class Solution {
	static int board[][] = new int[9][];
	static boolean col[][],row[][] ,grid[][][];
	public static void main(String[] args)
	{
		int T;
		Scanner scan  = new Scanner(System.in);
		T=scan.nextInt();
		for(int ca=1;ca<=T;ca++) {
			col =new boolean[9][10];  
			row =new boolean[9][10];  
			grid =new boolean[3][3][10];  
			for(int i=0;i<9;i++) {
				board[i]=partition(scan.nextInt());
				for(int j=0;j<9;j++) {
					row[i][board[i][j]]=true;
					col[j][board[i][j]]=true;
					grid[i/3][j/3][board[i][j]]=true;
				}
			}
		}
		dfs(0,0);   
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		scan.close();
	}
	private static boolean dfs(int currX,int currY) {
		if(currX>=9) {  
			return true;
		}
		if(board[currX][currY]!=0) {
			return dfs(currX+(currY+1)/9,(currY+1)%9);   
		}
		int gridX=currX/3,gridY=currY/3;   
		for(int i=1;i<=9;i++) {          
			if(!(col[currY][i]||row[currX][i]||grid[gridX][gridY][i])) {
				col[currY][i]=true;        
				row[currX][i]=true;
				grid[gridX][gridY][i]=true;
				board[currX][currY]=i;
				if(dfs(currX+(currY+1)/9,(currY+1)%9)) {
					return true;
				}
				col[currY][i]=false;
				row[currX][i]=false;
				grid[gridX][gridY][i]=false;
				board[currX][currY]=0;
			}
		}
		return false;
	}
	private static int[] partition(int n) {
		int[] result = new int[9];
		for (int i = 0; i < 9; i++) {
			result[9 - 1 - i] = n % 10;
			n = n / 10;
		}
		return result;
	}
}
