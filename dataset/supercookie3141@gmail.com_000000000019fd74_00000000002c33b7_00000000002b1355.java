import java.util.Scanner;

public class Solution {
	public static int[][] clone(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i += 1) {
			for(int j = 0; j < arr[0].length; j += 1) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int r = kboard.nextInt();
			int c = kboard.nextInt();
			int totalInterest = 0;
			int[][] board = new int[r][c];
			int[][] copy = new int[r][c];
			for(int j = 0; j < r; j += 1) {
				for(int k = 0; k < c; k += 1) {
					board[j][k] = kboard.nextInt();
				}
			}
			copy = clone(board);
			boolean over = false;
			while(!over) {
				over = true;
				for(int j = 0; j < r; j += 1) {
					for(int k = 0; k < c; k += 1) {
						totalInterest += board[j][k];
						if(!(board[j][k] == 0)) {
							int northernNeighbor = 0;
							int easternNeighbor = 0;
							int southernNeighbor = 0;
							int westernNeighbor = 0;
							int horizontal = k - 1;
							int vertical = j - 1;
							//System.out.println(j);
							//System.out.println(k);
							double numOfNeighbors = 0;
							while(horizontal >= 0) {
								//System.out.println(horizontal);
								if(!(board[j][horizontal] == 0)) {
									westernNeighbor = board[j][horizontal];
									numOfNeighbors += 1;
									break;
								}
								horizontal -= 1;
							}
							
							horizontal = k + 1;
							
							while(horizontal < c) {
								if(!(board[j][horizontal] == 0)) {
									easternNeighbor = board[j][horizontal];
									numOfNeighbors += 1;
									break;
								}
								horizontal += 1;
							}
							
							while(vertical >= 0) {
								if(!(board[vertical][k] == 0)) {
									northernNeighbor = board[vertical][k];
									numOfNeighbors += 1;
									break;
								}
								vertical -= 1;
							}
							
							vertical = j + 1;
							
							while(vertical < r) {
								if(!(board[vertical][k] == 0)) {
									southernNeighbor = board[vertical][k];
									numOfNeighbors += 1;
									break;
								}
								vertical += 1;
							}
							
							double average = 0;
									
							if(numOfNeighbors != 0) {
								average = (northernNeighbor + easternNeighbor + southernNeighbor + westernNeighbor) / numOfNeighbors;
							}
							//System.out.println(average);
							if(average > board[j][k]) {
								copy[j][k] = 0;
								over = false;
							}
						}
					}
				}
				board = clone(copy);
			}
			
			System.out.println("Case #" + i + ": " + totalInterest);
		}
	}
}
