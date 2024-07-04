

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		method();
		
	}
	
	public static void method() {
		Scanner c = new Scanner(System.in);
		int cases = c.nextInt();
		int[][] set;
		int dimensions;
		int[] r = new int[cases];
		int[] t = new int[cases];
		int[] co = new int[cases];
		for(int i =0; i< cases; i++) {
			 dimensions = c.nextInt();
			set = new int[dimensions][dimensions];
			fillArr(set, dimensions, c);
			r[i] = calculateRows(set, dimensions);
			co[i] = calculateColumns(set, dimensions);
			t[i] = calculateTrace(set, dimensions);
			
		}
		for(int i =0; i< cases; i++) {
			System.out.println("Case #"+i+": "+t[i]+" "+r[i]+" "+co[i]);
		}
	}
	
	public static void fillArr(int[][] arr, int dimension, Scanner s) {
		for(int i=0; i<dimension;i++) {
			for(int j =0;j<dimension; j++) {
				arr[i][j]= s.nextInt();
			}
		}
	}
	public  static int calculateRows(int[][] arr, int dimension) {
		int count =0;
		for(int i =0;i< arr.length;i++) {
		thisloop:	for(int j=0; j<arr[i].length;j++) {
				for(int k =j+1;k<arr[i].length;k++) {
					if(arr[i][j]==arr[i][k]) {
						count ++;
						break thisloop;
					}
				}
			}
		}
		return count;
	}
	public  static int calculateTrace(int[][] arr, int dimension) {
		int sum =0;
		for(int i =0; i<dimension;i++)
			sum+=arr[i][i];
		return sum;
	}
	public  static int calculateColumns(int[][] arr, int dimension) {
		int count =0;
		for(int i =0;i< arr.length;i++) {
			thisloop:	for(int j=0; j<arr[i].length;j++) {
					for(int k =j+1;k<arr[i].length;k++) {
						if(arr[j][i]==arr[k][i]) {
							count ++;
							break thisloop;
						}
					}
				}
		}
		return count;
	}
}
