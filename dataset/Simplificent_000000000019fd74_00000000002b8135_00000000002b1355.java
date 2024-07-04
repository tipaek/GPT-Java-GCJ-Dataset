
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int mumCases = sc.nextInt();
		sc.nextLine();
		for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
			pw.print("Case #" + (caseNumber + 1) + ": ");
			solve(sc, pw);
//			pw.println();
		}
		pw.println();
		pw.flush();
		pw.close();
		sc.close();
	}

	private static void solve(Scanner sc, PrintWriter pw) {
		final int R = sc.nextInt();
		final int C = sc.nextInt();

		final int[][] skillLevel = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				skillLevel[r][c] = sc.nextInt();
			}
		}

		// determine interest level of the competition

		// The interest level of a round is the sum of skill levels of the competitors dancing in that round
		// (even any competitors that are to be eliminated between that round and the next).
		// The interest level of the competition is the sum of the interest levels of all of the rounds.
		int interestLevel = calculateInterestLevel(skillLevel, R, C);
		int numEliminated = runRound(skillLevel, R, C);
		while (numEliminated > 0) {
			interestLevel += calculateInterestLevel(skillLevel, R, C);
			numEliminated = runRound(skillLevel, R, C);
		}

		pw.println(interestLevel);
	}

	private static int runRound(int[][] skillLevel, final int R, final int C) {
		int numEliminated = 0;
		boolean[][] eliminated = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// find the compass neighbors for the competitor at r, c and take the average of their skill levels
				// if the average is > this competitor's skill level, then this competitor is eliminated.
				// we'll want to make a separate notation of which competitors are eliminated and eliminate them
				// at the end because we need the competitors to say put for the entire round while we do these calculations.
				int competitor = skillLevel[r][c];
				if (competitor != 0) {
					float sum = 0;
					float numCompassNeighbors = 0;

					// find neighbor to the north
					int northNeighbor = 0;
					int tryRow = r - 1;
					while (tryRow >= 0 && northNeighbor == 0) {
						northNeighbor = skillLevel[tryRow--][c];
					}
					if (northNeighbor > 0) {
						sum += northNeighbor;
						numCompassNeighbors++;
					}

					// find neighbor to the east
					int eastNeighbor = 0;
					int tryColumn = c + 1;
					while (tryColumn < C && eastNeighbor == 0) {
						eastNeighbor = skillLevel[r][tryColumn++];
					}
					if (eastNeighbor > 0) {
						sum += eastNeighbor;
						numCompassNeighbors++;
					}

					// find neighbor to the south
					int southNeighbor = 0;
					tryRow = r + 1;
					while (tryRow < R && southNeighbor == 0) {
						southNeighbor = skillLevel[tryRow++][c];
					}
					if (southNeighbor > 0) {
						sum += southNeighbor;
						numCompassNeighbors++;
					}

					// find neighbor to the west
					int westNeighbor = 0;
					tryColumn = c - 1;
					while (tryColumn >= 0 && westNeighbor == 0) {
						westNeighbor = skillLevel[r][tryColumn--];
					}
					if (westNeighbor > 0) {
						sum += westNeighbor;
						numCompassNeighbors++;
					}

					if (numCompassNeighbors > 0) {
						// take the average
						float average = sum / numCompassNeighbors;

						// if the average is > us then we are eliminated
						if (average > competitor) {
							eliminated[r][c] = true;
						}
					}
				}
			}
		}

		// postprocess remove the eliminated by setting them to zero
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (eliminated[r][c]) {
					skillLevel[r][c] = 0;
					numEliminated++;
				}
			}
		}

		return numEliminated;
	}

	private static int calculateInterestLevel(int[][] skillLevel, final int R, final int C) {
		int result = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				result += skillLevel[r][c];
			}
		}
		return result;
	}

}
