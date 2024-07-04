import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		int testCase = 0;
		int matrixSize = 0;
		int flag = 0;
		ArrayList<int[][]> input= new ArrayList<int[][]>();
		testCase = scanner.nextInt();

		while( flag < testCase) {
			matrixSize = scanner.nextInt();
			input.add(saveMatrix(matrixSize));			
			flag++;
		}


		for(int i = 0; i < input.size(); i++) {
			System.out.println(calcOutput(input.get(i), i + 1));
			
		}
	}
	
	public static int[][] saveMatrix(int matrixSize) {
		int[][] matrixInput = new int[matrixSize][matrixSize];
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				matrixInput[i][j] = scanner.nextInt();
			}
		}
		
		return matrixInput;
	}
	
	public static String calcOutput(int[][] input, int outPutCase) {
		StringBuilder result = new StringBuilder("Case #");
		result.append(outPutCase).append(": ");
		
		int k = 0;
		int r = 0;
		int c = 0;
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				if(i==j) {
				k += input[i][j];
				}
			}
		}
		
		int[] row = new int [input.length];
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
					row[j] = input[i][j]; 					
			}
			r += searchDuplicate(row);
		}

		int[] col = new int [input.length];

		for(int j = 0; j < input.length; j++) {
			for(int i = 0; i < input[j].length; i++) {
					col[i] = input[i][j]; 				
			}
			c += searchDuplicate(col);
		}
		
		
		result.append(k).append(" ").append(r).append(" ").append(c);
		return result.toString();
		
	}
	
	static int searchDuplicate(int[] input) {

		 for (int i = 0; i < input.length; i++) {
		     for (int j = i + 1 ; j < input.length; j++) {
		          if (input[i] == input[j]) {
		                  return 1;
		          }
		     }
		 }
		
		return 0;
	}

}
