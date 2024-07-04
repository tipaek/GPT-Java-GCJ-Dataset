import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;

		while (t-- > 0) {
			int size = sc.nextInt();
			int[][] square = new int[size][size];
			
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					square[i][j] = sc.nextInt();
				}
			}
			
			int trace = computeTrace(size, square);
			int rows = checkRow(size, square);
			int cols = checkCol(size, square);

			System.out.println("Case #" + count + ": " + trace + " " + rows + " " + cols);
			
			count++;
		}

		sc.close();
	}
	
	public static int computeTrace(int size, int[][] square) {
		int trace = 0;
		
		for (int i = 0; i < size; i++) {
			trace += square[i][i];
		}
		
		return trace;
	}
	
	public static int checkRow(int size, int[][] square) {
		int repeated = 0;
		boolean[] elements;
		
		for (int i = 0; i < size; i++) {
			elements = new boolean[size+1];
			
			for (int j = 0; j < size; j++) {
				if(elements[square[i][j]]) {
					repeated++;
					break;
				} else {
					elements[square[i][j]] = true;
				}
			}
		}
		
		return repeated;
	}
	
	public static int checkCol(int size, int[][] square) {
		int repeated = 0;
		boolean[] elements;
		
		for (int i = 0; i < size; i++) {
			elements = new boolean[size+1];
			
			for (int j = 0; j < size; j++) {
				if(elements[square[j][i]]) {
					repeated++;
					break;
				} else {
					elements[square[j][i]] = true;
				}
			}
		}
		
		return repeated;
	}
}
