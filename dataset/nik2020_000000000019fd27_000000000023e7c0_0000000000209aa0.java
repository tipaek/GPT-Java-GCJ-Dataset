import java.util.Scanner;


public class Solution {
	

	
	public static boolean canBefilled(int[][] maze,int r,int c,int n, int k, int t, int[][] memoX , int[][] memoY) {
		
		if(r==n-1&&c==n-1) {
			
			
			return true;
		}
		
		if(maze[r][c] != 0) {
			if(c+1>=n) {
				return canBefilled(maze, r+1, 0, n, k, t, memoX, memoY);
			}
			return canBefilled(maze, r, c+1, n, k, t, memoX, memoY);
		}else {
			for(int i =1;i<=n;i++) {
				if(memoX[r][i-1]==0&&memoY[c][i-1]==0) {
					memoX[r][i-1]=1;
					memoY[c][i-1]=1;
					maze[r][c] = i;
					if( canBefilled(maze, r, c, n, k, t, memoX, memoY)) {
						return true;
					}
					maze[r][c] = 0;
					memoX[r][i-1]=0;
					memoY[c][i-1]=0;
					
				}
			}
			
		}
		
		return false;
		
		
	}
	
	
	public static boolean placeDiagnol(int[][] maze,int r, int c,int n, int k,int t,int[][] memoX , int[][] memoY) {
	
		if(r>=n&&c>=n) {
			if(k==0) {
				
				
				
				
				return canBefilled(maze, 0, 0,n, k, t, memoX, memoY);
			}else {
				return false;
			}
		}
		
		for(int i =1;i<=n;i++) {
			maze[r][c] = i;
			memoX[r][i-1]=1;
			memoY[c][i-1]=1;
			if(placeDiagnol(maze, r+1, c+1, n, k-i, t,memoX, memoY)) {
				return true;
			}
			memoX[r][i-1]=0;
			memoY[c][i-1]=0;
		}
		
		
		return false;
	
	}
	
	
	
    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int  t= s.nextInt();
	int k = t;
	while(t>0) {
		int n = s.nextInt();
		int j = s.nextInt();
		
		int[][] maze = new int[n][n];
		int[][] memoX = new int[n][n];
		int[][] memoY = new int[n][n];
		if(placeDiagnol(maze, 0, 0, n, j,k-t+1 ,memoX,memoY)){
			System.out.println("Case #"+(k-t+1)+": POSSIBLE");
			for(int a =0;a<n;a++) {
				for(int b =0;b<n;b++) {
					System.out.print(maze[a][b]+" ");
				}
				System.out.println();
			}
		}else{
			System.out.println("Case #"+(k-t+1)+": IMPOSSIBLE");
		};
		
		
		t--;
	}
	s.close();
	
	
	}

}

