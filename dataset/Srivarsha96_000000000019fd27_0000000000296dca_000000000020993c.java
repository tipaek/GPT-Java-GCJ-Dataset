package linkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a;
		int degree;
		Scanner sc=new Scanner(System.in);
		int test_cases = sc.nextInt();
		System.out.println("\ntest_cases:"+test_cases);
		for(int i=1;i<=test_cases;i++) {
			 degree = sc.nextInt();
			 a = new int[degree][degree];
			 System.out.println("degree of "+i+"th case: "+degree);
			 for(int j=0;j<degree;j++)
			 {
				for(int k=0;k<degree;k++) {
					a[j][k]=sc.nextInt();
					System.out.print(a[j][k]+" ");}
				
				System.out.println();
			 }
			 System.out.println("case#"+i+": "+calculate_the_trace(a,degree)+" "+calculate_the_row_repeatitions(a,degree)+" "+calculate_the_col_repeatitions(a,degree));
		}
	}

	private static int calculate_the_row_repeatitions(int[][] a, int degree) {
		// TODO Auto-generated method stub
		int row_repeatitions=0;
		Set<Integer> s = new HashSet<Integer>();
		for(int row_degree=0;row_degree<degree;row_degree++) {
			for(int col_degree=0;col_degree<degree;col_degree++) {
				if(s.contains(a[row_degree][col_degree])) {
					row_repeatitions++;break;
				}
				else
					s.add(a[row_degree][col_degree]);
			}
			s.clear();
		}
		return row_repeatitions;
	}
	private static int calculate_the_col_repeatitions(int[][] a, int degree) {
		// TODO Auto-generated method stub
		int col_repeatitions=0;
		Set<Integer> s = new HashSet<Integer>();
		for(int col_degree=0;col_degree<degree;col_degree++) {
			for(int row_degree=0;row_degree<degree;row_degree++) {
				if(s.contains(a[row_degree][col_degree]))
				{
					col_repeatitions++;break;
				}
				else
					s.add(a[row_degree][col_degree]);
			}
			s.clear();
		}
		return col_repeatitions;
	}

	private static int calculate_the_trace(int[][] a,int degree) {
		// TODO Auto-generated method stub
		int trace=0;
		for(int current_degree=0;current_degree<degree;current_degree++) {
			trace+=a[current_degree][current_degree];
		}
		return trace;
	}

}
