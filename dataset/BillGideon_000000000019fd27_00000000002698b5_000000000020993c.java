package GoogleCodeJam2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	 //has repeated numbers:true
	static boolean hasRowRepeated(int[][] matrix,int x,int row) {
		Set<Integer> temp = new HashSet<>();
//		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int m = 0;m < row;m++) {
//			if(temp.contains((Integer)matrix[row][i])) {
//				return true;
//			}else {
				temp.add(matrix[x][m]);
//			}
		}
//		if(temp.le)
		System.out.println(temp); 
		if(temp.size() == row)return false;
		else return true;
	}
	
	 //has repeated numbers:true
	static boolean hasColRepeated(int[][] matrix,int x,int row) {
//		Set<Integer> temp = new HashSet();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int m = 0;m < row;m++) {
			if(temp.contains((Integer)matrix[m][x])) {
				return true;
			}else {
				temp.add(matrix[m][x]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number = scan.nextInt();
        for(int i = 0;i < number;i++) {
        	int row = scan.nextInt();
        	int[][] a = new int[row][row];
        	
        	int trace = 0;
        	int rowRepeat=0;
        	int colRepeat=0;
        	for(int j = 0;j < row;j++) {
        		for(int k = 0;k < row;k++) {
        			a[j][k] = scan.nextInt();
        			if(j == k) {
        				trace += a[j][k];
        			}
	        	}
        	}
        	for(int j = 0;j < row;j++) {
        		rowRepeat += hasRowRepeated(a,j,row)?1:0;
//        		System.out.println(rowRepeat);
//        		System.out.println(hasRowRepeated(a,j));
        	}
        	
        	for(int j = 0;j < row;j++) {
        		colRepeat += hasColRepeated(a,j,row)?1:0;
//        		System.out.println(colRepeat);
        	}
//        	System.out.println();
//        	for(int j = 0;j < row;j++) {
//        		for(int k = 0;k < row;k++) {
//        			System.out.print(a[j][k]);
//        		}
//        		System.out.println();
//        	}
        	System.out.format("Case #%d: %d %d %d\n", i+1,trace,rowRepeat,colRepeat);
        	
        }
	}
}
