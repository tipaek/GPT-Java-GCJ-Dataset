import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
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
if(board==null) {r=new StringBuilder("IMPOSSIBLE");}
else {
if (solver()) {
	r=handlePrint();

} else {
	r=new StringBuilder("IMPOSSIBLE");
}
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
      // we search an empty cell
      if (board[row][col] == EMPTY) {
        // we try possible numbers
        for (int number = 1; number <= SIZE; number++) {
          if (isOk(row, col, number)) {
            // number ok. it respects sudoku constraints
            board[row][col] = number;

            if (solver()) { // we start backtracking recursively
              return true;
            } else { // if not a solution, we empty the cell and we continue
              board[row][col] = EMPTY;
            }
         }
        }

        return false; // we return false
       }
      }
     }

     return true; // sudoku solved
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
	if(isLegal(a)) {
	return a;}
	else {
		int changed=0;
		for(int i=0;i<a.length;i++) {
			changed=a[i][i];
			if(a[i][i]>1) {
				a[i][i]=a[i][i]-1;
			for(int k=0;k<a.length;k++) {
				if(a[k][k]<a.length && a[k][k]+1!=changed && k!=i) {
					a[k][k]=a[k][k]+1;
					if(isLegal(a) &&sumMat(a)==t ) {
						return a;
					}
				}
			}
			}
		}
		return null;
	}
}
public static int sumMat(int [][] a) {
	int sum=0;
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a[i].length;j++) {
			if(i==j) sum+=a[i][j];
		}
	}
	return sum;
}
//class Pair{
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	int x,y;
//	public Pair(int x,int y) {
//		this.x=x;
//		this.y=y;
//	}
//}
public static boolean isLegal(int a[][]) {
	Hashtable<Integer,Integer> h = new Hashtable<Integer,Integer>();
	for(int i=0;i<a[0].length;i++) {
		if(h.containsKey(a[i][i])) {
			h.put(a[i][i], h.get(a[i][i])+1);
		}else {
			h.put(a[i][i], 1);
		}
	}
	for(int i=0;i<h.size();i++) {
		if(h.get(a[i][i])==a.length-1)
			return false;
	}
	return true;
}
	
}