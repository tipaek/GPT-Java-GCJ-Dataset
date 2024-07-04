
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder finalAns = new StringBuilder();

		int noOfTestCases = in.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {

			StringBuilder ans = new StringBuilder();
			int sizeOfMatrix = in.nextInt();
			int trace = in.nextInt();
			boolean solPosible = false;
			int diagNumber = 0, sum = 0;

			int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

			HashMap<Integer, Integer> h = new HashMap<>();
			for (int j = 1; j <= sizeOfMatrix; j++) {
				h.put(j, j * sizeOfMatrix);
				sum = sum + j;
			}

			if (sum == trace && sizeOfMatrix !=2) {
				ans.append("POSSIBLE");
				ans.append('\n');

				matrix = printStanMatrix(matrix, sizeOfMatrix);

				for (int a = 0; a < sizeOfMatrix; a++) {
					for (int b = 0; b < sizeOfMatrix; b++) {
						ans.append(matrix[a][b]);
					}
					ans.append('\n');
				}
			} else {
				for (Entry<Integer, Integer> e : h.entrySet()) {
					if (e.getValue() == trace) {
						solPosible = true;
						diagNumber = e.getKey();
						break;
					}
				}

				if (!solPosible) {
					ans.append("IMPOSSIBLE");
				} else {
					ans.append("POSSIBLE");
					ans.append('\n');

					matrix = formMatrix(matrix, diagNumber, sizeOfMatrix);

					for (int a = 0; a < sizeOfMatrix; a++) {
						for (int b = 0; b < sizeOfMatrix; b++) {
							ans.append(matrix[a][b]);
						}
						ans.append('\n');
					}

				}
			}

			finalAns.append("Case #" + (i + 1) + ": " + ans.toString().trim());
			finalAns.append('\n');

		}
		System.out.println(finalAns.toString().trim());
		in.close();

	}

	public static int[][] formMatrix(int[][] matrix, int diagNumber, int sizeOfMatrix) {

		for(int i=0;i<sizeOfMatrix;i++){
			if(i!=0)
			diagNumber--;
			for(int j=0;j<sizeOfMatrix;j++){
				if(i==0 && j==0){
					matrix[i][j] = diagNumber;
				}
				else if(diagNumber == sizeOfMatrix){
					diagNumber =0;
					matrix[i][j] = ++diagNumber;					
				}
				else{
					matrix[i][j] =  ++diagNumber;
				}
				
			}
		}
		
		return matrix;
	}

	public static int[][] printStanMatrix(int[][] matrix, int sizeOfMatrix) {

		
		for(int i=0;i<sizeOfMatrix;i++){
			for(int j=0;j<sizeOfMatrix;j++){
				
				
			}
		}
		return matrix;
	}

}
