import java.util.*;
import java.io.*;
import java.util.Arrays;

/**
 * Problem 1
 */
public class Solution2 {
	
	private static List<String> scores = new ArrayList<>();
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//in.nextLine();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			int size = in.nextInt();
			//String[] details = size.split(" ");
			
			int requiredTrace = in.nextInt();
			findLatinSquare(test, size, requiredTrace);
			scores = new ArrayList<>();
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
		int[][] square = new int[size][size];
		buildSquare(size, square);
		if (diagonalList.size() > 0) {
			for (int[] diagonalElements : diagonalList) {
				shuffleSquare(size, square, diagonalElements);
				//printSquare(size, square);
				if (checkTrace(size, square, requiredTrace)) {
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
	
	private static boolean checkTrace(int size, int[][] square, int requiredTrace) {
		int trace = 0;
		for (int i = 0; i < size; i++) {
			trace += square[i][i];
		}
		if (trace == requiredTrace) {
			return true;
		}
		return false;
	}

	private static void shuffleSquare(int size, int[][] square, int[] diagonalElements) {
		for (int i = 0; i < size; i++) {
			int traceElement = diagonalElements[i];
			int index = findTraceIndex(square, size, i, traceElement);
			if (i != index) {
				swapRows(i, index, size, square);
				//printSquare(size, square);
			}
		}
	}

	private static void swapRows(int traceindex, int index, int size, int[][] square) {
		for (int i = 0; i < size; i++) {
			int temp = square[i][traceindex];
			square[i][traceindex] = square[i][index];
			square[i][index] = temp;
		}
	}
	
	private static int findTraceIndex(int[][] square, int size, int hor, int element) {
		for (int i = 0; i < size; i++) {
			if (square[hor][i] == element) {
				return i;
			}
		}
		return 0;
	}

	// Function to print n x n Latin Square 
    static void buildSquare(int n, int[][] square) 
    { 
    	for (int line = 0; line < n; line++) {
    		for (int col = 0; col < n; col++) {
    		    int o = n - line;
    		    int v = (o + col) % n + 1;
    		    square[line][col] = v;
    		}
    	}
    }  

	private static void buildSquareLeftRight(int size, int[] integers, int[] diagonalElements, int[][] square) {
		for (int i = 0; i < size; i++) {
			square[i][i] = diagonalElements[i];
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
		List<int[]> diagonalList = new ArrayList<int[]>();
		partition(requiredTrace, size);
		for (int i = 0; i < scores.size(); i++) {
			String[] stringArray = scores.get(i).trim().split(" ");
			if (stringArray.length != size) {
				continue;
			} else {
				int[] validData = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
				for(int k = 0; k < validData.length / 2; k++)
				{
				    int temp = validData[k];
				    validData[k] = validData[validData.length - k - 1];
				    validData[validData.length - k - 1] = temp;
				}
				diagonalList.add(validData);
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