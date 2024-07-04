import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> output = new ArrayList<String>();
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int[][] field = new int[r][c];
			int[][] elemField = new int[r][c];
			int firstRoundScore = 0;
			int elemination = 1;
			int round = 1;
			for(int k = 0; k < r; k++) {
				for(int m = 0; m < c; m++) {
					field[k][m] = scanner.nextInt();
					firstRoundScore += field[k][m];
				}
			}
			while(elemination > 0) {
				elemination = 0;
				int roundScore = 0;
				for(int k = 0; k < r; k++) {
					for(int m = 0; m < c; m++) {
						if(elemField[k][m] == 0) {
							int neighborScore = 0;
							int neighbors = 0; 
							if(k != 0) {
								if(elemField[k - 1][m] == 0 || elemField[k - 1][m] == round) {
									neighborScore += field[k - 1][m];
									neighbors++;
								}
							}
							if(m != 0) {
								if(elemField[k][m - 1] == 0 || elemField[k][m - 1] == round) {
									neighborScore += field[k][m - 1];
									neighbors++;
								}
							}
							if(m != c - 1) {
								if(elemField[k][m + 1] == 0 || elemField[k][m + 1] == round) {
									neighborScore += field[k][m + 1];
									neighbors++;
								}
							}
							if(k != r - 1) {
								if(elemField[k + 1][m] == 0 || elemField[k + 1][m] == round) {
									neighborScore += field[k + 1][m];
									neighbors++;
								}
							}
							if(neighbors != 0 && field[k][m] < (((float)neighborScore)/neighbors)) {
								elemination++;
								elemField[k][m] = round;
							} else {
								roundScore += field[k][m];
							}
						}
					}
				}
				if(elemination > 0) {
					firstRoundScore += roundScore;
				}
				round++;
			}
			output.add("" + firstRoundScore);
		}
		for(int i = 0; i < output.size(); i++) {
			System.out.println("Case #" + (i + 1) + ": " +output.get(i));
		}
		scanner.close();
	}
}