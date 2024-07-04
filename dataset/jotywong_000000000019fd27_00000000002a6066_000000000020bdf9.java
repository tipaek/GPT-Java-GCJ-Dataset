import java.util.Scanner;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception{
		//FileReader inputFile = new FileReader(new File(args[0])); // TESTING
		InputStreamReader inputFile = new InputStreamReader(System.in); // uncomment this
		Scanner in = new Scanner(new BufferedReader(inputFile));

		int t = in.nextInt();
		for(int i = 0; i < 0; i++){
			int n = in.nextInt();
			String str = new String();
			int[][] matrix = new int[n][2];

			// create 2d array
			for(int j = 0; j < n; j++){
				matrix[j][0] = in.nextInt();
				matrix[j][1] = in.nextInt();
			}

			for(int j = 0; j < n; j++){
				if(j == 0){
					str += 'C';
				} else { 
					if(matrix[j][1] > matrix[j+1][0]){
						str += 'J';
					} else {
						str = "IMPOSSIBLE";
					}
				}
			}

			// output
			System.out.println("Case #" + (i+1) + ": " + str);
		}
	}
}