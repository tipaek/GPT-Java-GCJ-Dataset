import java.util.Scanner;
public class Solution {
	static boolean[] isRowTaken;
	public static int[] checkIfAvailable(int[][] matrix, int val, int pos, int n) {
		//System.out.println("Checking for "+val + " in pos="+pos+ " n="+n);
		int pos_copy = pos;
		int steps, mirrorsteps;
		if(pos< val-1) {
			steps = n-(val-1) + pos;
		} else {
			steps = pos - (val - 1);
		}
		int mirrorpos = n-1-pos;
		if(mirrorpos< val-1) {
			mirrorsteps = n-(val-1) + mirrorpos;
		} else {
			mirrorsteps = mirrorpos - (val - 1);
		}
		int[] result = {0, 0};
		//System.out.println("Steps = "+steps +" Mirror = "+mirrorsteps);
		if(!isRowTaken[steps]) {
			isRowTaken[steps] = true;
			result[0] = 1;
			result[1] = steps+1;
		} else if(!isRowTaken[mirrorsteps] && n>2) {
			isRowTaken[mirrorsteps] = true;
			result[0] = 1;
			result[1] = -1*(mirrorsteps+ 1);
		} else {
			result[0] = 0;
			result[1] = -1;
		}
		//System.out.println("Checking for "+val + " in pos="+pos_copy+" -> {"+result[0]+", "+result[1]+"}");
		return result;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		int[][] matrix = new int[50][50];
		for (int i = 0; i < t; i++ ) {
			int n = in.nextInt();
			int k = in.nextInt();
			int k_copy = k;
			in.nextLine();
			int curr = n;
			int lastinsertpos = -1;
			String output = "";
			int[][] rotated_matrix = new int[n][n];
			isRowTaken = new boolean[n];
			for (int j =0; j < n; j++) {
				rotated_matrix[0][j] = j + 1;
				isRowTaken[j] = false;
			}
			for (int j =1; j < n; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					rotated_matrix[j][(k1+1)%n] = rotated_matrix[j-1][k1];
				}	
			}
			/*
			System.out.println("********rotated_matrix ********");
			for (int j =0; j < n; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					System.out.print(rotated_matrix[j][k1]+ " ");
				}
				System.out.println();	
			}
			System.out.println("***************************");
			*/
			lastinsertpos = -1;
			while (true) {
				if(k_copy > curr) {
					matrix[++lastinsertpos][lastinsertpos] = curr;
					k_copy -= curr;
					//System.out.println("Inserting " + curr + "New k= "+k_copy);
				} else if(k_copy < curr) {
					curr--;
					//System.out.println("Reducing insert factor to" + curr + "New k= "+k_copy);
				} else {
					matrix[++lastinsertpos][lastinsertpos] = curr;
					k_copy -= curr;
					//System.out.println("Inserting " + curr + "New k= "+k_copy);
					break;
				}
			}
			//System.out.println("LastOInsertPos = " + lastinsertpos);
			if(lastinsertpos >=0 && lastinsertpos < n-1) {
				int amountToreduce = 0;
				for(int j = lastinsertpos + 1; j < n; j++) {
					matrix[j][j] = 1;
					//System.out.println("Inserting 1");
					amountToreduce++;
				}

				while (amountToreduce > 0 && lastinsertpos >=0) {
					int f = (amountToreduce > matrix[lastinsertpos][lastinsertpos] - 1)? matrix[lastinsertpos][lastinsertpos] - 1 : amountToreduce;
					matrix[lastinsertpos][lastinsertpos] -= f;
					//System.out.println("Updating to " + matrix[lastinsertpos][lastinsertpos]);
					amountToreduce -= f;
					lastinsertpos -= 1;
				}

				if(amountToreduce > 0 && lastinsertpos <0) {
					output = "IMPOSSIBLE";
				} else {
					output = "POSSIBLE";
				}
			} else {
				output = "POSSIBLE";
			}
			if(output.equals("POSSIBLE")) {
				for(int j = 0; j < n; j++) {
					int[] result = checkIfAvailable(rotated_matrix, matrix[j][j], j, n);
					if(result[0] == 0) {
						output = "IMPOSSIBLE";
						break;
					} else {
						if (result[1] > 0) {
							for(int k1 = 0; k1 < n ; k1++) {
								matrix[j][k1] = rotated_matrix[result[1]-1][k1];
							}
						} else {
							for(int k1 = 0; k1 < n ; k1++) {
								matrix[j][k1] = rotated_matrix[(-1*result[1])-1][n-k1-1];
							}
						}
					}
					//System.out.println();
				}
				if(output.equals("POSSIBLE")) {
					//System.out.println("********final matrix ********");
					System.out.println("Case #" + (i+1) +": POSSIBLE");
					for (int j =0; j < n; j++) {
						for (int k1 = 0; k1 < n; k1++) {
							System.out.print(matrix[j][k1]+ " ");
						}
						System.out.println();	
					}
					//System.out.println("***************************");
				} else {
					System.out.println("Case #" + (i+1) +": IMPOSSIBLE");
				}	
			} else {
				System.out.println("Case #" + (i+1) +": IMPOSSIBLE");
			}		
		}
	}
}