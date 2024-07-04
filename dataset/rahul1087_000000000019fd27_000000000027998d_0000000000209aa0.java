import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class Solution {

    public static void main(String args[] ) throws Exception {
        //BufferedReader
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for(int x=1;x<=t;x++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(k>=n && k%n == 0){
int[][] ar = new int[n][n];
int val = k/n;
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        if(i == j){
        ar[i][j]=val;
        }
    }
}

Solution sl = new Solution();
if(sl.solve(ar)==true)
		{      
System.out.println("Case #" + x + ": " + "POSSIBLE");
		for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
		System.out.print(ar[i][j]+" ");
		}System.out.println();
		}

	}
            }else{
System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
            }
        }
    }

     int r1=0;int c1=0;
	boolean solve(int[][] grid){
	int row=0,column=0;
	if(!isTherenNoPalceToFill(grid))
		return true;
	row=r1;column=c1;
	for(int i=1;i<=grid.length;i++)
		{
	    if(canPlace(grid,row,column,i)){
		grid[row][column]=i;
		if(solve(grid))
			return true;
		grid[row][column]=0;
		}
	}
	return false;
	}


      boolean isTherenNoPalceToFill(int[][] grid){
	 for(int i=0;i<grid.length;i++)
		 for(int j=0;j<grid[0].length;j++)
		 if(grid[i][j]==0)
		 {r1=i;c1=j;return true;}
	 return false;
	 }


      boolean canPlace(int[][] grid,int row,int col,int num){
	 if(!isInRow(grid,row,num)&&!isInCol(grid,col,num))
		 return true;
	 return false;
	 }

     
	 boolean isInRow(int[][] grid,int r,int num){
	 for(int i=0;i<grid.length;i++){
	 if(grid[r][i]==num)
		 return true;
	 }
	 return false;
	 }
	 
	 
	 boolean isInCol(int[][] grid,int c,int num){
	 for(int i=0;i<grid.length;i++){
	 if(grid[i][c]==num)
		 return true;
	 }
	 return false;
	 }


}
