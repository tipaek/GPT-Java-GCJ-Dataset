import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	private static int[][] board;
	public static final int EMPTY = 0; // empty cell
	public static  int SIZE ; // size of our Sudoku grids

public static void main(String [] args) {
Scanner sc = new Scanner(System.in);
int t=sc.nextInt();
StringBuilder sb = new StringBuilder("");


for(int c=0;c<t;c++) {
	StringBuilder r = new StringBuilder("");
int n=sc.nextInt();
int k=sc.nextInt();
SIZE=n;
board=handleTrace(n, k);
if (solveSudoku(n)) {
	r=handlePrint();

} else {
	r=new StringBuilder("IMPOSSIBLE");
}
	
	if(r.toString().equals("IMPOSSIBLE")) {
	sb.append("Case #"+(c+1)+": "+r+"\n");}
	else {
		sb.append("Case #"+(c+1)+": "+r);
	}
	
	
	}
System.out.println(sb);
	
}
public static StringBuilder handlePrint() {
	StringBuilder r= new StringBuilder("");
	r.append("POSSIBLE"+"\n");
	for(int i=0;i<SIZE;i++) {
		for(int j=0;j<SIZE;j++) {
			r.append(board[i][j]+" ");
		}
		r.append("\n");
	}
	return r;
	
}
public static void display() {
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			System.out.print(" " + board[i][j]);
		}
	
		System.out.println();
	}
	
	System.out.println();
}
private static boolean isInRow(int row, int number) {
	for (int i = 0; i < SIZE; i++)
		if (board[row][i] == number)
			return true;
	
	return false;
}
private static boolean isInCol(int col, int number) {
	for (int i = 0; i < SIZE; i++)
		if (board[i][col] == number)
			return true;
	
	return false;
}
public static boolean solver() {
    for (int row = 0; row < SIZE; row++) {
     for (int col = 0; col < SIZE; col++) {
      if (board[row][col] == EMPTY) {
        for (int number = 1; number <= SIZE; number++) {
          if (isOk(row, col, number)) {
            board[row][col] = number;

            if (solver()) { 
              return true;
            } else { // 
              board[row][col] = EMPTY;
            }
         }
        }

        return false; 
       }
      }
     }

     return true;
}
private static boolean  isOk(int row, int col, int number) {
	return !isInRow(row, number)  &&  !isInCol(col, number)  ;
}
public static int [] [] handleTrace(int n,int t){
	int [] []  a = new int[n][n];
	ArrayList<Integer>x = new ArrayList<Integer>();
	int rem=0;
	for(int i=0;i<n;i++) {
		x.add(1);
	}
	rem=t-n;
	int j=0;
	while(rem!=0) {
		x.set(j, x.get(j)+1);
		j++;
		rem--;
		if(j==x.size()) {
			j=0;
		}
	}
	for(int i=0;i<x.size();i++) {
		a[i][i]=x.get(i);
	}
	return a;
}
public static boolean isSafe(int[][] board,  
        int row, int col,  
        int num)  
{ 
// row has the unique (row-clash) 
for (int d = 0; d < board.length; d++)  
{ 
// if the number we are trying to  
// place is already present in  
// that row, return false; 
if (board[row][d] == num)  
{ 
return false; 
} 
} for (int r = 0; r < board.length; r++) { 

if (board[r][col] == num) { 
return false; 
} } 
return true; 
}
public static boolean solveSudoku(int n)  
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
  
    // no empty space left 
    if (isEmpty)  
    { 
        return true; 
    } 
  
    // else for each-row backtrack 
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(board, row, col, num)) 
        { 
            board[row][col] = num; 
            if (solveSudoku( n))  
            { 
                // print(board, n); 
                return true; 
            }  
            else
            { 
                board[row][col] = 0; // replace it 
            } 
        } 
    } 
    return false; 
} 
	
}