import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

public static void main(String [] args) {
	Scanner sc = new Scanner(System.in);
	int t= sc.nextInt();
	StringBuilder sb = new StringBuilder("");

	for(int c=0;c<t;c++) {
		StringBuilder r = new StringBuilder("");

		int n=sc.nextInt();
		int k=sc.nextInt();
		int row [] = new int[n];
		for(int i=1;i<=n;i++) {
			row[i-1]=i;
		}
		int org [] [] =  new int[n][n];
		org[0]=row;
		for(int i=1;i<n;i++) {
			org[i]=shiftOne(org[i-1]);
		}
		while(n>0) {
			if(sumMat(org)==k) {
				r=handlePrint(org);
				break;
			}
			else {
				org=shiftOne(org);
				n--;
			}
		}
		if(r.toString().equals("")) {
			r= new StringBuilder("IMPOSSIBLE"+"\n");
		}
		sb.append("Case #"+(c+1)+": " +r);
	}
	
	System.out.println(sb);
	
	
	
	
}
public static StringBuilder handlePrint(int [][]board) {
	StringBuilder r= new StringBuilder("");
	r.append("POSSIBLE"+"\n");
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board.length;j++) {
			r.append(board[i][j]+" ");
		}
		r.append("\n");
	}
	return r;
	
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
public static int [] shiftOne(int []a) {
	int [] r= new int[a.length];
	r[0]=a[a.length-1];
	for(int i=0;i<a.length-1;i++) {
	r[i+1]=a[i];
	}
	return r;
}
public static int [][] shiftOne(int [][]a) {
	int [][] r= new int[a.length][a.length];
	r[0]=a[a.length-1];
	for(int i=0;i<a.length-1;i++) {
	r[i+1]=a[i];
	}
	return r;
}
public static void display(int [][]a) {
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a.length;j++) {
			System.out.print(a[i][j]+" ");
		}
		System.out.println();
	}
}
	
}