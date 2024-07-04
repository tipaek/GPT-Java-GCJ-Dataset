import java.util.*;
import java.io.*;

class ProblemInstance {
	int i;
	int j;
	int[] nestingDepth;
	public ProblemInstance(int i,  int j, String digits) {
		this.i = i;
		this.j = j;
		nestingDepth = new int[digits.length()];

		for (int index = 0; index < nestingDepth.length; index++) {
			nestingDepth[index] = Character.getNumericValue(digits.charAt(index));
		}
	}
	@Override
	public boolean equals(Object o) {
		ProblemInstance other = (ProblemInstance) o;
		return Objects.equals(i, other.i) && Objects.equals(j, other.j) &&
		nestingDepthAreEqual(other);

	}
	private boolean nestingDepthAreEqual(ProblemInstance other) {

		for (int index = i; index <= j; index++) {
			if (other.nestingDepth[index] != other.nestingDepth[index]) {
				return false;
			}
		}

		return true;
	}
	@Override
	public int hashCode() {
		return Objects.hash(i, j, nestingDepthHash());
	}
	private int nestingDepthHash() {
		int overallSumHash = 0;
		for (int index = i; index <= j; index++) {
			overallSumHash += Objects.hash(nestingDepth[index]);
		}
		return Objects.hash(overallSumHash);
	}
}
public class Solution {

	public static String sPrime(String digits) {
		ProblemInstance mainProblem = new ProblemInstance(0, digits.length() - 1, digits);
		String digitsPrime = sPrime(digits, mainProblem, new HashMap<>());
		return digitsPrime;
	}

	private static String sPrime(String digits, ProblemInstance currentProblem, Map<ProblemInstance, String> memo) {

		// base case
		if (currentProblem.i == currentProblem.j) {
			String output = "" + digits.charAt(currentProblem.i);
			for (int i = 0; i < currentProblem.nestingDepth[currentProblem.i]; i++) {
				output = "(" + output + ")";

			}
			return output;
		}

		int minIndex = indexWithMinNestingDepth(digits, currentProblem);
		if (currentProblem.nestingDepth[minIndex] == 0) {
			// parition into two if possible arround min index and recurse
			if (minIndex == currentProblem.i) {
				//new sub problem
				currentProblem.i = minIndex + 1;
				String solution = digits.charAt(minIndex) +  (memo.containsKey(currentProblem) ? memo.get(currentProblem) : sPrime(digits, currentProblem, memo)); // (memo.containsKey(currentProblem) ? memo.get(currentProblem) :

				currentProblem.i = minIndex;
				memo.put(currentProblem, solution);
				return solution;
			} else if (minIndex == currentProblem.j) {
				currentProblem.j = minIndex - 1;
				String solution =  memo.containsKey(currentProblem) ? memo.get(currentProblem) + digits.charAt(minIndex) : sPrime(digits, currentProblem, memo) + digits.charAt(minIndex); //
				currentProblem.j = minIndex;
				// System.out.println("Current problem's i" + currentProblem.i + " and it's j " + currentProblem.j + "and it's hashcode" + currentProblem.hashCode() + " mapped to solution: " + solution);
				memo.put(currentProblem, solution);
				return solution;
			} else {
				// two new subproblems split around min index
				// from i ... min - 1
				int oldJ = currentProblem.j;
				currentProblem.j = minIndex - 1;
				String firstsolution =  memo.containsKey(currentProblem) ? memo.get(currentProblem) : sPrime(digits, currentProblem, memo); //
				currentProblem.j = oldJ;

				// from min + 1 ... j
				int oldI = currentProblem.i;
				currentProblem.i = minIndex + 1;
				String secondSolution =  memo.containsKey(currentProblem) ? memo.get(currentProblem) : sPrime(digits, currentProblem, memo); //
				currentProblem.i = oldI;

				String solution = firstsolution + digits.charAt(minIndex) + secondSolution;
				memo.put(currentProblem, solution);

				return solution;
			}
 
		} else {

			int[] currentNestingDepth = currentProblem.nestingDepth;
			// first subproblem: first substring + (minDigit) + secondSubstring
			currentNestingDepth[minIndex] -= 1;

			String firstSolution =  memo.containsKey(currentProblem) ? memo.get(currentProblem) : sPrime(digits, currentProblem, memo); 
			int minIndexInSolution = getMinDigitIndex(minIndex - currentProblem.i, firstSolution);

			// System.out.println("Target index in digit string: " + (minIndex - currentProblem.i) + " & in firstSolution is " + minIndexInSolution);
			firstSolution = firstSolution.substring(0, minIndexInSolution) + "(" + firstSolution.charAt(minIndexInSolution) + ")" + firstSolution.substring(minIndexInSolution + 1);
			//undo change
			currentNestingDepth[minIndex] += 1;

			// second sub prolem (whole string)
			for (int i = currentProblem.i; i <= currentProblem.j; i++) {
				currentProblem.nestingDepth[i] -= 1;
			}

			String secondSolutionPriorToDecoration = sPrime(digits, currentProblem, memo);
			// System.out.println("	second solution prior to decoration is: " + secondSolutionPriorToDecoration);

			String secondSolution = memo.containsKey(currentProblem) ? "(" + memo.get(currentProblem) + ")" : "(" + secondSolutionPriorToDecoration + ")"; 
			// System.out.println("	currentProblem.i " + currentProblem.i + " and currentProblem.j " + currentProblem.j);

			// undo move made for second sub problem
			for (int i = currentProblem.i; i <= currentProblem.j; i++) {
				currentProblem.nestingDepth[i] += 1;
			}


			// System.out.println("	firstSolution is: " + firstSolution);
			// System.out.println("	second solution is: " + secondSolution);
			String currentSolution = firstSolution.length() > secondSolution.length() ? secondSolution : firstSolution;
			// System.out.println("Current problem's i" + currentProblem.i + " and it's j " + currentProblem.j + "and it's hashcode" + currentProblem.hashCode() + "mapped to solution " + currentSolution);
			memo.put(currentProblem, currentSolution);
			return currentSolution;

		}


	}

	private static int getMinDigitIndex(int targetIndex, String str) { 
		int digitIndex = 0;
		for (int strIndex = 0; strIndex < str.length(); strIndex++) {
			if (Character.isDigit(str.charAt(strIndex)) && 
				targetIndex == digitIndex) {
				return strIndex;
			} else if (Character.isDigit(str.charAt(strIndex))) {
				digitIndex+=1;
			}
		}
		return digitIndex;

	}

	private static int indexWithMinNestingDepth(String digits, ProblemInstance currentProblem) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int index = currentProblem.j; index >= currentProblem.i; index--) {
			if (currentProblem.nestingDepth[index] <= min) {
				minIndex = index;
				min = currentProblem.nestingDepth[index];
			}

		}
		return minIndex;

	}

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String s = in.nextLine().trim();
          String primeS = sPrime(s);
          System.out.println("Case #" + i + ": " + (primeS));
        }
	}
	
}