import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for(int i=1;i<=testCases;i++) {
			int row = scanner.nextInt();
			int cols = scanner.nextInt();
			int[][] matrix = new int[row][cols];
			for(int j=0;j<row;j++) {
				for(int k=0;k<cols;k++) {
					matrix[j][k] = scanner.nextInt();
				}
			}
			System.out.println("Case #"+i+": "+runTestCase(matrix,row,cols));
		}
	}
	
	private static int runTestCase(int[][] matrix,int row,int cols) {
		int score = 0;
		int prevTotal = -1;
		int currTotal = 0;
		while(currTotal!=prevTotal) {
			List<int[]> removeList = new ArrayList<int[]>();
			int tempTotal = 0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<cols;j++) {
					if(matrix[i][j]<0) {
						continue;
					}
					tempTotal += matrix[i][j];
					int nabCount = 0;
					int nabsTotal = 0;
					if(i-1>=0) {
						for(int k=i-1;k>=0;k--) {
							int temp = matrix[k][j];
							if(temp>=0) {
								nabsTotal += temp; 
								nabCount++;
								break;
							}
						}
					}
					if(j-1>=0) {
						for(int k=j-1;k>=0;k--) {
							int temp = matrix[i][k];
							if(temp>=0) {
								nabsTotal += temp; 
								nabCount++;
								break;
							}
						}
					}
					if(i+1<=row-1) {
						for(int k=i+1;k<row;k++) {
							int temp = matrix[k][j];
							if(temp>=0) {
								nabsTotal += temp; 
								nabCount++;
								break;
							}
						}
					}
					if(j+1<=cols-1) {
						for(int k=j+1;k<cols;k++) {
							int temp = matrix[i][k];
							if(temp>=0) {
								nabsTotal += temp; 
								nabCount++;
								break;
							}
						}
					}
					float avg = ((float)nabsTotal) / nabCount;
					if(matrix[i][j]>=avg) {
						//win
					}
					else {
						//eliminate
						int[] removeA = {i,j};
						removeList.add(removeA);
					}
				}
			}
			for(int l=0;l<removeList.size();l++) {
				matrix[removeList.get(l)[0]][removeList.get(l)[1]] = -1;
			}
			score += tempTotal;
			prevTotal = currTotal;
			currTotal = tempTotal;
		}		
		score = score - currTotal * 2;
		return score;
	}
	
}
