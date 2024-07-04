import java.util.Scanner;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception{
		// For Testing
		//FileReader inputFile = new FileReader(new File(args[0]));
		InputStreamReader inputFile = new InputStreamReader(System.in);
		Scanner in = new Scanner(new BufferedReader(inputFile));

		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int k = 0; // trace
			int r = 0; // rows with repeated elements
			int c = 0; // cols with repeated elements
			int[][] matrix = new int[n][n];

			// build matrix and calculate trace
			for(int rCount = 0; rCount < n; rCount++){ // rows

				for(int cCount = 0; cCount < n; cCount++){ // cols
					int currentNum = in.nextInt();

					// trace addition
					if(rCount == cCount){
						k += currentNum;
					}

					matrix[rCount][cCount] = currentNum;
					//System.out.print(currentNum);
				}

				//System.out.println();
			}
			
			// testing matrix
			/*for(int a = 0; a < n; a++){
				for (int b = 0; b < n; b++) {
					System.out.print(matrix[a][b]);
				}
				System.out.println();
			}*/

			// check for row repeats
			for(int rCount = 0; rCount < n; rCount++){ // rows

				boolean rowRepeat = false;
				for(int cCount = 0; (cCount < n-1) && (rowRepeat == false); cCount++){ // cols
					int currentNum = matrix[rCount][cCount];

					for(int j = cCount+1; (j < n) && (rowRepeat == false); j++){
						int nextNum = matrix[rCount][j];
						if(currentNum == nextNum){
							//System.out.println("ROW REPEAT TRUE : " + currentNum + " " + nextNum + " " + cCount + " " + j);
							rowRepeat = true;
						}
					}
				}
				if(rowRepeat == true){
					r++;
				}
			}

			// check for col repeats
			for(int cCount = 0; cCount < n; cCount++){ // cols

				boolean colRepeat = false;
				for(int rCount = 0; (rCount < n-1) && (colRepeat == false); rCount++){ // rows
					int currentNum = matrix[rCount][cCount];

					for(int j = rCount+1; (j < n) && (colRepeat == false); j++){
						int nextNum = matrix[j][cCount];
						if(currentNum == nextNum){
							//System.out.println("COL REPEAT TRUE : " + currentNum + " " + nextNum + " " + rCount + " " + j);
							colRepeat = true;
						}
					}
				}
				if(colRepeat == true){
					c++;
				}
			}

			// output
			System.out.print("Case #" + (i+1) + ": ");
			System.out.print(k + " ");
			System.out.print(r + " ");
			System.out.print(c);
			System.out.println();
		}

	}
}
