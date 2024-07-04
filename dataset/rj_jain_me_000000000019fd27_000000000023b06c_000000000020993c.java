import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			int N = s.nextInt();
			int[][] myArray = getInput(N);
			int diagonalSum = getSum(myArray);
			int rowSame = getRowSame(myArray);
			int colSame = getColSame(myArray);
			
			System.out.println("Case #"+x+": "+diagonalSum+" "+rowSame+" "+colSame);
			x++;
			T--;
		}
	}
	
	private static int getRowSame(int[][] myArray) {
		int same = 0;
		
		int row = 0;
		while(row<myArray.length) {
			for(int i = 0; i<myArray.length; i++) {
				boolean check = false;
				for(int j = i+1; j<myArray.length; j++) {
					if(myArray[row][i] == myArray[row][j]) {
						check = true;
						break;
					}
				}
				if(check == true) {
					same++;
					break;
				}
			}
			row++;
		}
		
		return same;
	}
	
	private static int getColSame(int[][] myArray) {
		int same = 0;
		
		int col = 0;
		while(col<myArray.length) {
			for(int i = 0; i<myArray.length; i++) {
				boolean check = false;
				for(int j = i+1; j<myArray.length; j++) {
					if(myArray[i][col] == myArray[j][col]) {
						check = true;
						break;
					}
				}
				if(check == true) {
					same++;
					break;
				}
			}
			col++;
		}
		
		return same;
	}
	
	private static int getSum(int[][] myArray) {
		int sum = 0;
		
		int i = 0, j = 0;
		while(i<myArray.length) {
			sum = sum + myArray[i][j];
			i++;
			j++;
		}
		
		return sum;
	}
	
	private static int[][] getInput(int N) {
		int [][] myArray = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				myArray[i][j] = s.nextInt();
			}
		}
		
		return myArray;
	}

}
