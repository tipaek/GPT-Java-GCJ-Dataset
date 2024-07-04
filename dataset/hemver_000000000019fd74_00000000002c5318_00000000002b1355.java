import java.util.*;
import java.io.*;

/**
 * Problem 1
 */
public class Solution {
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			int lines = in.nextInt();
			int columns = in.nextInt();
			
			Solution sol = new Solution();
			
			Part[][] matrix = new Part[lines][columns];
		
			for (int i = 0; i < lines; i++) {
				for (int j = 0; j < columns; j++) {
					int number = in.nextInt();
					Part element = sol.new Part();
					element.setSkill(number);
					matrix[i][j] = element;
				}
			}
		findCompetetionInterestLevel(test, lines, columns, matrix);
		}
		in.close();
	}

	private static void findCompetetionInterestLevel(int number, int lines, int columns, Part[][] matrix) {
		int competetionScore = 0;
		int roundScore = 0;
		int counter = 1;
		boolean noMoreParticipants = true;
		int previousScore = 0;
		while (noMoreParticipants) {
			int partWithNeighbor = 0;
			if (lines == 1 && columns == 1) {
				competetionScore = matrix[lines - 1][columns - 1].getSkill();
				break;
			} else {
				roundScore = calculateRoundScore(lines,  columns,  matrix);
				if (previousScore == roundScore) {
					break;
				}
				previousScore = roundScore;
				System.out.println("round score: " + roundScore + ": round =  " + counter);
				competetionScore += roundScore;
				for (int i = 0; i < lines; i++) {
						for (int j = 0; j < columns; j++) {
							if (matrix[i][j] != null) {
								int participant = matrix[i][j].getSkill();
								partWithNeighbor += eliminateParticipant(i, j, matrix, lines, columns);
							}
						}
					}
				if (partWithNeighbor == 0 && counter != 1) {
					noMoreParticipants = false;
				}
				counter++;
				cleanMatrix(lines,  columns,  matrix);
			}
		}
		System.out.println("Case #" + number + ": " + competetionScore);
	}

	private static void cleanMatrix(int lines, int columns, Part[][] matrix) {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] != null && matrix[i][j].isEliminated()) {
					matrix[i][j] = null;
				}
			}
		}
	}

	private static int eliminateParticipant(int index1, int index2, Part[][] matrix, int lines, int columns) {
		int participant = matrix[index1][index2].getSkill();
		double sum = 0;
		int count = 0;
		//left
		if (index2 > 0) {
			int leftcompass = findLeftCompass(matrix, index1, index2);
			//Part left = matrix[index1][index2 - 1];
			if (leftcompass != 0) {
				sum += leftcompass;
				count++;
			}
		}
		//right
		if (index2 < columns - 1) {
			int rightcompass = findRightCompass(matrix, index1, index2, columns);
			//Part left = matrix[index1][index2 - 1];
			if (rightcompass != 0) {
				sum += rightcompass;
				count++;
			}
		}
		//up
		if (index1 > 0) {
			int leftcompass = findUpCompass(matrix, index1, index2);
			//Part left = matrix[index1][index2 - 1];
			if (leftcompass != 0) {
				sum += leftcompass;
				count++;
			}
		}
		//down
		if (index1 < lines - 1) {
			int leftcompass = findDownCompass(matrix, index1, index2, lines);
			//Part left = matrix[index1][index2 - 1];
			if (leftcompass != 0) {
				sum += leftcompass;
				count++;
			}
		}
		
		if (sum/count > participant) {
			matrix[index1][index2].setEliminated(true);
		}
		return count;
	}

	private static int findLeftCompass(Part[][] matrix, int index1, int index2) {
		for (int i = index2 - 1; i >= 0; i--) {
			if (matrix [index1][i] != null) {
				return matrix [index1][i].getSkill();
			}
		}
		return 0;
	}
	
	private static int findRightCompass(Part[][] matrix, int index1, int index2, int columns) {
		for (int i = index2 + 1; i <= columns - 1; i++) {
			if (matrix [index1][i] != null) {
				return matrix [index1][i].getSkill();
			}
		}
		return 0;
	}
	
	private static int findUpCompass(Part[][] matrix, int index1, int index2) {
		for (int i = index1 - 1; i >= 0; i--) {
			if (matrix [i][index2] != null) {
				return  matrix [i][index2].getSkill();
			}
		}
		return 0;
	}
	
	private static int findDownCompass(Part[][] matrix, int index1, int index2, int lines) {
		for (int i = index1 + 1; i <= lines - 1; i++) {
			if (matrix [i][index2] != null) {
				return matrix [i][index2].getSkill();
			}
		}
		return 0;
	}

	private static int calculateRoundScore(int lines, int columns, Part[][] matrix) {
		//int[] array = new int[2];
		int roundScore = 0;
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] != null && !matrix[i][j].isEliminated()) {
					roundScore += matrix[i][j].getSkill();
				}
			}
		}
		return roundScore;
	}
	
	class Part {
		int skill;
		boolean eliminated;
		public int getSkill() {
			return skill;
		}
		public void setSkill(int skill) {
			this.skill = skill;
		}
		public boolean isEliminated() {
			return eliminated;
		}
		public void setEliminated(boolean eliminated) {
			this.eliminated = eliminated;
		}
	}
}