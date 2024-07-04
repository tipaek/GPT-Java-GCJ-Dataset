import java.util.*;
import java.io.*;

/**
 * Problem 1
 */
public class Solution2 {
	
	private static List<String> scores = new ArrayList<>();
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			int size = in.nextInt();
			int requiredTrace = in.nextInt();
			findLatinSquare(test, size, requiredTrace);
		}
		in.close();
	}

	private static void findLatinSquare(int testCase, int size, int requiredTrace) {
		int[] integers = new int[size];
		for (int i = 0; i < size; i++) {
			integers[i] = i + 1;
		}
		
		
		List<int[]> diagonalList = findDiagonalElement(size, requiredTrace, integers);
		boolean squareFound = false;
		if (diagonalList.size() > 0) {
			for (int[] diagonalElements : diagonalList) {
				int[][] square = new int[size][size];
				for (int i = 0; i < size; i++) {
					if (diagonalElements[i] != 0) {
						square[i][i] = diagonalElements[i];
					} else {
						System.out.println();
						return;
					}
				}
				//build the main square
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						for (int k = 0; k < size; k++) {
							if (i != j) {
								int numberToInsert = integers[k];
								boolean unique = ifUniqueRowCol(square, size, numberToInsert, i, j);
								if (unique) {
									square[i][j] = numberToInsert;
									break;
								}
							} else {
								continue;
							}
						}
					}
				}
				//printSquare(size, square);
				if (checkSquare(size, square)) {
					System.out.println("Case #" + testCase + ": POSSIBLE");
					printSquare(size, square);
					squareFound = true;
					break;
				} else {
					//printSquare(size, square);
				}
			}
			if (!squareFound) {
				System.out.println("Case #" + testCase + ": IMPOSSIBLE");
			}
		} else {
			System.out.println("Case #" + testCase + ": IMPOSSIBLE");
		}
		
	}

	private static boolean checkSquare(int size, int[][] square) {
		//build the main square
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j && square[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean ifUniqueRowCol(int[][] square, int size, int integer, int hor, int ver) {
		for (int i = 0; i < size; i++) {
			if (square[hor][i] == integer) {
				return false;
			}
		}
		for (int i = 0; i < size; i++) {
			if (square[i][ver] == integer) {
				return false;
			}
		}
		return true;
	}

	private static List<int[]> findDiagonalElement(int size, int requiredTrace, int[] integers) {
		//find score subset
		//List<int[]> list = findScoreSet(integers);
		List<int[]> diagonalList = new ArrayList<int[]>();
		int[] diagonalElements = new int[size];
		partition(requiredTrace, size);
		for (int i = 0; i < scores.size(); i++) {
			String[] stringArray = scores.get(i).trim().split(" ");
			if (stringArray.length != size) {
				continue;
			} else {
				diagonalElements = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
				diagonalList.add(diagonalElements);
			}
		}
		return diagonalList;
	}
	
	public static void partition(int n, int size) {
        partition(n, size, "");
    }
    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
        	scores.add(prefix);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, prefix + " " + i);
        }
    }

	private static void printSquare(int size, int[][] square) {
		//build the main square
		for (int i = 0; i < size; i++) {
			//int counterInt = 0;
			for (int j = 0; j < size; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println("");
		}
		//System.out.println("-------------------");
	}
}