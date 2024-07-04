import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scan.nextInt();
		
		for(int i=0;i<t;i++){
		int n = scan.nextInt();
		int k = scan.nextInt();
		boolean flag = true;
		int x = n + 1;
		int y = n*n - 1;
		
		if(k==x || k==y || (n==3 && (k==5 || k==7))){
		    flag=false;
		}

		if(flag){
			int pointer=0;
			int ans[][] = new int[n][n];
			for(int a=0;a<n;a++) {
				ans[a][a] =1;				
			}
			while(k-n>0){
				++ans[pointer][pointer];
				--k;
				++pointer;
				if(pointer>=n) {
					pointer=0;
				}
			}
			
			if(ans[n-1][n-1]==ans[n-2][n-2]-1) {
				++ans[n-2][n-2];
				--ans[n-3][n-3];
			}else if(ans[0][0]==ans[1][1]+1) {
				++ans[0][0];
				--ans[1][1];
				if(ans[0][0]>n) {
					--ans[0][0];
					++ans[2][2];
				}
			}

			System.out.println("Case #"+(i+1)+": POSSIBLE");
		    // Sudoku backtracking solution taken from geeks for geeks
		    // https://www.geeksforgeeks.org/sudoku-backtracking-7/
		    solveSudoku(ans, n);
			print(ans, n);
		}else{
		    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
		}
		}
	}
	
public static boolean isSafe(int[][] board,  
                             int row, int col,  
                             int num)  
{ 
    for (int d = 0; d < board.length; d++)  
    { 
        if (board[row][d] == num)  
        { 
            return false; 
        } 
    } 
      
    for (int r = 0; r < board.length; r++) 
    { 
        if (board[r][col] == num) 
        { 
            return false; 
        } 
    } 
    
    return true; 
} 
  
public static boolean solveSudoku(int[][] board, int n)  
{ 
    int row = -1; 
    int col = -1; 
    boolean isEmpty = true; 
    for (int i = 0; i < n; i++) 
    { 
        for (int j = 0; j < n; j++)  
        { 
            if (board[i][j] == 0)  
            { 
                row = i; 
                col = j; 
                  
                isEmpty = false;  
                break; 
            } 
        } 
        if (!isEmpty) 
        { 
            break; 
        } 
    } 
  
    if (isEmpty)  
    { 
        return true; 
    } 
  
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(board, row, col, num)) 
        { 
            board[row][col] = num; 
            if (solveSudoku(board, n))  
            { 
                return true; 
            }  
            else
            { 
                board[row][col] = 0;
            } 
        } 
    } 
    return false; 
} 
  
public static void print(int[][] board, int N) 
{ 
    for (int r = 0; r < N; r++) 
    { 
        for (int d = 0; d < N; d++) 
        { 
            System.out.print(board[r][d]); 
            System.out.print(" "); 
        } 
        System.out.print("\n"); 
          
        if ((r + 1) % (int) Math.sqrt(N) == 0)  
        { 
            System.out.print(""); 
        } 
    } 
} 

}
