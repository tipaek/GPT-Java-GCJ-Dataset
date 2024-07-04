import java.util.Scanner;
public class Solution {
	static boolean[] isRowTaken1, isRowTaken2;
	public static int[] checkIfAvailable(int[][] matrix, int val, int pos, int n) {
		//System.out.println("Checking for "+val + " in pos="+pos+ " n="+n);
		int pos_copy = pos;
		int steps, mirrorsteps;
		if(pos< val-1) {
			steps = n-(val-1) + pos;
		} else {
			steps = pos - (val - 1);
		}
		
		int[] result = {0, 0};
		//System.out.println("Steps = "+steps +" Mirror = "+mirrorsteps);
		if(!isRowTaken1[steps]) {
			isRowTaken1[steps] = true;
			result[0] = 1;
			result[1] = steps+1;
		} else {
			result[0] = 0;
			result[1] = -1;
		}
		//System.out.println("Checking for "+val + " in pos="+pos_copy+" -> {"+result[0]+", "+result[1]+"}");
		return result;
	}
	public static int[] checkIfAvailableinRotated(int[][] matrix, int val, int pos, int n) {
		//System.out.println("Checking for "+val + " in pos="+pos+ " n="+n);
		int pos_copy = pos;
		int steps, mirrorsteps;
		if(pos< n -1 - (val-1)) {
			steps = n-(n -1 - (val-1)) + pos;
		} else {
			steps = pos - (n -1 - (val-1));
		}
		
		int[] result = {0, 0};
		//System.out.println("Steps = "+steps +" Mirror = "+mirrorsteps);
		if(!isRowTaken2[steps]) {
			isRowTaken2[steps] = true;
			result[0] = 1;
			result[1] = steps+1;
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
			int[][] rotated_matrix1 = new int[n][n];
			int[][] rotated_matrix2 = new int[n][n];
			isRowTaken1 = new boolean[n];
			isRowTaken2 = new boolean[n];
			for (int j =0; j < n; j++) {
				rotated_matrix1[0][j] = j + 1;
				rotated_matrix2[0][j] = n - j;
				isRowTaken1[j] = false;
				isRowTaken2[j] = false;
			}
			for (int j =1; j < n; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					rotated_matrix1[j][(k1+1)%n] = rotated_matrix1[j-1][k1];
					rotated_matrix2[j][(k1+1)%n] = rotated_matrix2[j-1][k1];
				}	
			}
			/*
			System.out.println("********rotated_matrix1 ********");
			for (int j =0; j < n; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					System.out.print(rotated_matrix1[j][k1]+ " ");
				}
				System.out.println();	
			}
			System.out.println("***************************");

			System.out.println("********rotated_matrix2 ********");
			for (int j =0; j < n; j++) {
				for (int k1 = 0; k1 < n; k1++) {
					System.out.print(rotated_matrix2[j][k1]+ " ");
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
				int flag = 0;
				for(int j = 0; j < n; j++) {
					int[] result = checkIfAvailable(rotated_matrix1, matrix[j][j], j, n);
					if(result[0] == 0) {
						flag = 1;
						break;
					} else {
						if (result[1] > 0) {
							for(int k1 = 0; k1 < n ; k1++) {
								matrix[j][k1] = rotated_matrix1[result[1]-1][k1];
							}
						} else {
							for(int k1 = 0; k1 < n ; k1++) {
								matrix[j][k1] = rotated_matrix1[(-1*result[1])-1][n-k1-1];
							}
						}
					}
					//System.out.println();
				}
				if(flag == 1) {
					//System.out.println("Checking rotated");
					for(int j = 0; j < n; j++) {
						int[] result = checkIfAvailableinRotated(rotated_matrix2, matrix[j][j], j, n);
						if(result[0] == 0) {
							flag = 2;
							break;
						} else {
							if (result[1] > 0) {
								for(int k1 = 0; k1 < n ; k1++) {
									matrix[j][k1] = rotated_matrix2[result[1]-1][k1];
								}
							} else {
								for(int k1 = 0; k1 < n ; k1++) {
									matrix[j][k1] = rotated_matrix2[(-1*result[1])-1][n-k1-1];
								}
							}
						}
						//System.out.println();
					}
				}
				if(flag != 2 ) {
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