
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.annotation.Generated;

class Solution{

	public static boolean checkForDuplicates(int[] arr) {
		boolean found = false;
		
		for(int i = 0; i <arr.length && found == false ;i++) {
			for(int j = i+1 ; j< arr.length ; j++) {
				if( arr[i] == arr[j]) {
					found = true;
					break;
				}
			}
		}
		
		return found;
	}
	
	public static int trace(int[][] mat, int n) {
		int sum = 0;
		for(int i=0; i < n; i++) {
			sum += mat[i][i];
		}
		
		return sum;
	}
	
	public static void printingMatrix(int[][] mat, int n) {
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < n; j++) 
				System.out.print(mat[i][j]); 
			System.out.println(""); 
		} 
	}


	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		for(int i = 0; i <testCases; i++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] temp = new String[n];
			for(int j = 0; j< n;j++) {
				temp[j] = br.readLine();
			}
			
			int[][] myArr = new int[n][n];
			
			for(int j = 0; j < n ; j++) {
				String[] tempArr = temp[j].split(" ");
				for(int k = 0 ; k<tempArr.length; k++) {
					myArr[j][k] = Integer.parseInt(tempArr[k]);
				}
			}
			
			int trace = trace(myArr,n);
			
			//for rows
			int r = 0;
			for(int j = 0; j< myArr.length; j++) {
				if(checkForDuplicates(myArr[j]) == true)
					r++;
			}
			
			//for columns
			int c = 0;
			for(int j = 0; j< myArr.length; j++) {
				int[] newArr = new int[n];
				
				for(int k = 0 ; k < n ; k++) {
					newArr[k] = myArr[k][j];

				}
				
				if(checkForDuplicates(newArr) == true)
					c++;
			}
			
			
			
			System.out.println("Case #" + (i+1)+ ": "+ trace + " "+ r + " " + c);
			
			
//			
//			System.out.println("trace: " + trace);
//			System.out.println("r: " + r);
//			System.out.println("c: " + c);
//			
			
			
			//printingMatrix(myArr, n);
			
			
		}


	}
}