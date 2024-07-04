import java.util.*;
import java.io.*;

class Solution {

	static int[][] printLatin(int n) {

		int k = n + 1;
		int matrix[][] = new int[n][n];
		int counter = 0;
		
		for (int i = 1; i <= n; i++) {

			int temp = k;

			while (temp <= n) {
				matrix[counter / n][counter % n] = temp;
				counter++;

				temp++;
			}

			for (int j = 1; j < k; j++) {
				matrix[counter / n][counter % n] = j;
				counter++;
			}

			k--;
		}

		return matrix;
	}

	public static int[][] swapRows(int array[][], int rowA, int rowB) {
		int tmpRow[] = array[rowA];
		array[rowA] = array[rowB];
		array[rowB] = tmpRow;
		return array;
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int value) {
		
		int num[] = new int[value];
		for (int i = 0; i < num.length; i++) {
			num[i] = i;
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 	result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				for (int j = 0; j < l.size()+1; j++) {
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
					l.remove(j);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}

	public static void main(String[] args) {

		int testCase, testCounter = 1;

		Scanner inputScanner = new Scanner(System.in);

		testCase = inputScanner.nextInt();

		while (testCounter <= testCase) {

			int N = inputScanner.nextInt();
			int K = inputScanner.nextInt();

			int result[][] = printLatin(N);

			boolean isFound = false;
			int swappedResult[][] = new int[N][N];
			
			ArrayList<ArrayList<Integer>> swappedPermute = permute(N);
			for (int i = 0; i < swappedPermute.size(); i++) {
				ArrayList<Integer> currentSwapp = swappedPermute.get(i);
				for (int j = 0; j < N; j++) {
					swappedResult[j] = result[currentSwapp.get(j)];
				}
				
				int total = 0;
				for (int l = 0; l < N; l++) {
					total += swappedResult[l][l];
				}
				
				if(total == K) {
					isFound = true;
					break;
				}
			}
			
			if (isFound == true) {
				System.out.println("Case #"+testCounter+": POSSIBLE");
				for (int i = 0; i < swappedResult.length; i++) {
					for (int j = 0; j < swappedResult.length; j++) {
						System.out.print(swappedResult[i][j] +" ");
					}
					System.out.println();
				}
					
			}else {
				System.out.println("Case #"+testCounter+": IMPOSSIBLE");
			}
			
			testCounter++;
		}
	}
}
