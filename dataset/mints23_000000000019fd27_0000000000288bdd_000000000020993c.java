import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] myArray = new int[n][n];
		 	in.nextLine();		          

			 for (int k=0; k<myArray.length; k++) {
				 	String ln = in.nextLine();
		          String[] line = ln.trim().split(" ");
		          for (int j=0; j<line.length; j++) {
		             myArray[k][j] = Integer.parseInt(line[j]);
		          }
				 
		       }


			System.out.println("Case #" + i + ": " + calculateTrace(myArray, n) + " " + ifRepeatingRow(myArray) + " " +ifRepeatingCol(myArray));
		}
	}
	



	public static int ifRepeatingRow(int arr[][]) {
		int size = arr.length;
		int count=0;
		int[] countArray;
		for (int r = 0; r < size; r++) {
			countArray=new int[size+1];
		for (int c = 0; c < size; c++) {
			countArray[arr[r][c]]=arr[r][c]+countArray[arr[r][c]];
            if (countArray[arr[r][c]] > arr[r][c]) {
			count++;
            break;
			}
		}
		}

		return count;
	}
	
	public static int ifRepeatingCol(int arr[][]) {
		int size = arr.length;
		int count=0;
		int[] countArray;
		for (int c = 0; c < size; c++) {
			countArray=new int[size+1];
		for (int r = 0; r < size; r++) {
			countArray[arr[r][c]]=arr[r][c]+countArray[arr[r][c]];
            if (countArray[arr[r][c]] > arr[r][c]) {
			count++;
            break;
			}
		}
		}

		return count;
	}

	public static int calculateTrace(int matrix[][], int len) {

		int res = 0;

		for (int i = 0; i < len; i++) {

			res = +res + matrix[i][i];

		}

		return res;

	}

}
