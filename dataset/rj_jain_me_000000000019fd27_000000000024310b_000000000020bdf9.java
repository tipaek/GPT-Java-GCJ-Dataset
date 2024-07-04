import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			int N = s.nextInt();
			int[][] myArray = getInput(N);
			String str = getString(myArray);
			System.out.println("Case #"+x+": "+str.toString());
			x++;
			T--;
		}
	}
	
	private static String getString(int[][] myArray) {
		char[] arr = new char[myArray.length];
		
		int cBusy = 0;
		int jBusy = 0;
		int row = 0;
		int[] doneArray = new int[myArray.length];
		for(int i = 0; i<doneArray.length; i++) {
			doneArray[i] = 0;
		}
		
		while(row<myArray.length) {
			int minIndex = 0;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<myArray.length; i++) {
				if(myArray[i][1] < min && doneArray[i] != 1) {
					min = myArray[i][1];
					minIndex = i;
				}
			}
			if(cBusy<=myArray[minIndex][0]) {
				arr[minIndex] = 'C';
				cBusy = min;
			} else if (jBusy<=myArray[minIndex][0]) {
				arr[minIndex] = 'J';
				jBusy = min;
			} else {
				return "IMPOSSIBLE";
			}
			doneArray[minIndex] = 1;
			row++;
		}
		
	
		String str = new String(arr);
		return str;
	}
	
	private static int[][] getInput(int N) {
		int [][] myArray = new int[N][2];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<2; j++) {
				myArray[i][j] = s.nextInt();
			}
		}
		return myArray;
	}

}
