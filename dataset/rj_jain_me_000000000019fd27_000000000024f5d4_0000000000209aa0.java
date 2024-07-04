import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			int N = s.nextInt();
			int K = s.nextInt();
			int[][] myArray = new int[N][N];
			int diagonalElement = 1;
			boolean check = false;
			while(diagonalElement <= N) {
				if(diagonalElement*N == K) {
					check = true;
					break;
				}
				diagonalElement++;
			}
			if(!check) {
				System.out.println("Case #"+x+": IMPOSSIBLE");
			} else {
				int value = 1;
				int valueFilled = 1;
				int j = 1;
				myArray[0][0] = diagonalElement;
				while(j<N) {
					valueFilled++;
					myArray[0][j] = value;
					value++;
					if(value == 2) {
						value++;
					}
					j++;
				}
				j = 0;
				while(valueFilled<N) {
					myArray[0][j] = value;
					value++;
					if(value == 2) {
						value++;
					}
					valueFilled++;
				}
				
				int[] tempArray = new int[N];
				for(int i = 0; i<N; i++) {
					tempArray[i] = myArray[0][i];
				}
				int row = 1;
				while(row<N) {
					rotate(tempArray);
					for(int i = 0; i<N; i++) {
						myArray[row][i] = tempArray[i];
					}
					row++;
				}
				System.out.println("Case #"+x+": POSSIBLE");
				for(int i = 0; i<N; i++ ) {
					for(int k = 0; k<N; k++) {
						System.out.print(myArray[i][k]+" ");
					}
					System.out.println();
				}
			}
			
			x++;
			T--;
		}
	}
	
	private static void rotate(int[] array) {
		int temp = array[array.length - 1];
		for(int i = array.length - 1; i>0; i--) {
			array[i] = array[i-1];
		}
		array[0] = temp;
	}

}
