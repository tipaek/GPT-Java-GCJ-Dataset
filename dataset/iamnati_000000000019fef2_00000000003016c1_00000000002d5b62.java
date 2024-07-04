
import java.util.*;
import java.io.*;

class ProblemSolution {
	boolean isPossible;
	StringBuilder directions;
	int numJumps;
	public ProblemSolution(boolean isPossible, int numJumps) {
		this.isPossible = isPossible;
		directions = new StringBuilder();
		this.numJumps = numJumps;
	}
	public ProblemSolution(boolean isPossible, int numJumps, String str) {
		this.isPossible = isPossible;
		directions = new StringBuilder(str);
		this.numJumps = numJumps;
	}
}
class Move {
	int x;
	int y;
	String direction;

	public Move(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}
public class Solution {

	public static ProblemSolution isReachable(int xTarget, int yTarget) {
		if (xTarget == 0 && yTarget == 0) {
			return new ProblemSolution(true, 0);
		}
		Map<Character, Character> directionCompliments = new HashMap<>();
		directionCompliments.put('S', 'N');
		directionCompliments.put('N', 'S');
		directionCompliments.put('E', 'W');
		directionCompliments.put('W', 'E');
		if (xTarget  < 0 && yTarget < 0) {
			ProblemSolution result = isReachable(0, 0, Math.abs(xTarget), Math.abs(yTarget), 1, new HashMap<>());
			if (result.isPossible) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < result.directions.toString().length(); i++) {
					char currentChar = result.directions.toString().charAt(i);
					builder.append(directionCompliments.get(currentChar));


				}
				result.directions = builder;

			}
			if (!result.isPossible) {
				return new ProblemSolution(false, result.numJumps, "IMPOSSIBLE");
			}
			return result;
			
		} else if (xTarget  < 0 && yTarget > 0) {
			ProblemSolution result = isReachable(0, 0, Math.abs(xTarget), Math.abs(yTarget), 1, new HashMap<>());
			if (result.isPossible) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < result.directions.toString().length(); i++) {
					char currentChar = result.directions.toString().charAt(i);
					if (currentChar == 'E' || currentChar == 'W') {
						builder.append(directionCompliments.get(currentChar));
					} else {
						builder.append(currentChar);
					}
				
				}
				result.directions = builder;

			}
			if (!result.isPossible) {
				return new ProblemSolution(false, result.numJumps, "IMPOSSIBLE");
			}
			return result;
		} else if (xTarget > 0 && yTarget < 0) {
			ProblemSolution result = isReachable(0, 0, Math.abs(xTarget), Math.abs(yTarget), 1, new HashMap<>());
			if (result.isPossible) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < result.directions.toString().length(); i++) {
					char currentChar = result.directions.toString().charAt(i);
					if (currentChar == 'N' || currentChar == 'S') {
						builder.append(directionCompliments.get(currentChar));
					} else {
						builder.append(currentChar);
					}
				
				}
				result.directions = builder;

			}
			if (!result.isPossible) {
				return new ProblemSolution(false, result.numJumps, "IMPOSSIBLE");
			}
			return result;
		}
		ProblemSolution result = isReachable(0, 0, xTarget, yTarget, 1, new HashMap<>());
		if (!result.isPossible) {
			return new ProblemSolution(false, result.numJumps, "IMPOSSIBLE");
		}
		return result;
	}

	private static ProblemSolution isReachable(int currX, int currY, int xTarget, int yTarget, int i,
											 Map<Integer, Map<Integer, Map<Integer, ProblemSolution>>> memo) {
		if (currX == xTarget && currY == yTarget) {
			return new ProblemSolution(true, 0);
		}

		if (Math.abs(currX) > (int)(Math.pow(2, xTarget)) ||
			Math.abs(currY) > (int)(Math.pow(2, yTarget))) {
			return new ProblemSolution(false, 0);
		}

		int minJumps = Integer.MAX_VALUE;
		String directionChangesAsAResultOfMinJump = "IMPOSSIBLE";
		boolean solutionIsPossible = false;
		for (Move move : nextvalidMoves(currX, currY, i)) {
			//System.out.println("Moved to: (" + move.x + ", " + move.y + ") " + move.direction);

			ProblemSolution subProblemSoln = memo.containsKey(move.x) && memo.get(move.x).containsKey(move.y) && memo.get(move.x).get(move.y).containsKey(i)  ? 
							memo.get(move.x).get(move.y).get(i) : isReachable(move.x, move.y, xTarget, yTarget, i + 1, memo);
			// System.out.println(subProblemSoln.isPossible);
			if (subProblemSoln.isPossible) {
				solutionIsPossible = true;
				directionChangesAsAResultOfMinJump = subProblemSoln.numJumps + 1 < minJumps ?
												move.direction + subProblemSoln.directions : directionChangesAsAResultOfMinJump;
				minJumps = Math.min(subProblemSoln.numJumps + 1, minJumps);
			}		
		}

		ProblemSolution currentSolution = new ProblemSolution(solutionIsPossible, minJumps);
		currentSolution.directions.append(directionChangesAsAResultOfMinJump);
		Map<Integer, ProblemSolution> iToSolutionMap = new HashMap<>();
		iToSolutionMap.put(i, currentSolution);
		Map<Integer, Map<Integer, ProblemSolution>> yToSolutionMap = new HashMap<>();
		yToSolutionMap.put(currY, iToSolutionMap);
		memo.put(currX, yToSolutionMap);

		// System.out.println(directionChangesAsAResultOfMinJump);
		return currentSolution;
	}




	private static int jump(int i) {
		int newValue =  (int)Math.pow(2, i - 1);
		// System.out.println("New value" + newValue + " value: " + value + "i=" + i);
		return newValue;
	}

	private static List<Move> nextvalidMoves(int currX, int currY, int i) {

		// List<Move> nextMoves = new ArrayList<>();
		Move nextMoveEast = new Move(currX + jump(i), currY, "E");
		Move nextMoveNorth = new Move(currX, currY + jump(i), "N");
		Move nextMoveWest = new Move(currX - jump(i), currY, "W");
		Move nextMoveSouth = new Move(currX, currY - jump(i), "S");
		return Arrays.asList(nextMoveEast, nextMoveSouth, nextMoveWest, nextMoveNorth);
		// // Possible moves for quadrant 1
		// if (quadrant.equals(Quadrant.ONE)) {
		// 	// System.out.println("Next East: " + nextMoveEast.x);
		// 	// System.out.println("Next North: " + nextMoveEast.y);
		// 	nextMoves.add(nextMoveEast);
		// 	nextMoves.add(nextMoveNorth);
		// } else if (quadrant.equals(Quadrant.TWO)) {
		// 	nextMoves.add(nextMoveWest);
		// 	nextMoves.add(nextMoveNorth);

		// } else if (quadrant.equals(Quadrant.THREE)) {
		// 	nextMoves.add(nextMoveWest);
		// 	nextMoves.add(nextMoveSouth);

		// } else {
		// 	nextMoves.add(nextMoveEast);
		// 	nextMoves.add(nextMoveSouth);

		// }

		// return nextMoves;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String[] targets = in.nextLine().split(" ");
          ProblemSolution sol = isReachable(Integer.parseInt(targets[0]), Integer.parseInt(targets[1]));

          System.out.println("Case #" + i + ": " + (sol.directions));
      }
	}
	

}