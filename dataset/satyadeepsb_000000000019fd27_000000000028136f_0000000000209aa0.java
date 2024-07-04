import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

	public static boolean loopCount = true;
	public static String result = "IMPOSSIBLE" ;

	public static long getSummation(long endPoint) {
		return LongStream.rangeClosed(1, endPoint).reduce(0, Long::sum);
	}
	public static long getAddition(long number, long n) {
		return number * n;
	}
	public static long[][] rotateMatrix(int N, long mat[][]) { 
		// Consider all squares one by one 
		for (int x = 0; x < N / 2; x++) { 
			// Consider elements in group of 4 in 
			// current square 
			for (int y = x; y < N - x - 1; y++) { 
				// store current cell in temp variable 
				long temp = mat[x][y]; 

				// move values from right to top 
				mat[x][y] = mat[y][N - 1 - x]; 

				// move values from bottom to right 
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y]; 

				// move values from left to bottom 
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x]; 

				// assign temp to left 
				mat[N - 1 - y][x] = temp; 
			} 
		} 
		return mat;
	} 

	public static String isLatinSquare(long[][] array, int k) {

		long diagonalSumLeftToRight = 0;
		long diagonalSumRightToLeft = 0;
		boolean isLatin= true;
		for (int i = 0; i<array.length ;i++) {
			// check for duplicates in each row
			if(isDuplicates(array[i]) && isLatin){
				isLatin  = false;
			}
			// create a column array
			long[] column = new long[array[i].length]; 
			for(int j = 0; j<array.length; j++) {
				column[j] = array[j][i]; 
				if(i == j) {
					diagonalSumLeftToRight += array[j][i];
				}
				if(j == (array.length - 1 - i)) {
					diagonalSumRightToLeft += array[j][i];
				}
				// could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
			}
			// check for duplicates in each column
			if(isDuplicates(column) && isLatin){
				isLatin  = false;
			}
		}
		if(isLatin && (diagonalSumLeftToRight == k)) {
			loopCount  = false;
			return "POSSIBLE";
		}
		return "IMPOSSIBLE";
	}

	public static boolean isDuplicates(long[] array){
		for (int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++){
				if (i != j && array[i] == array[j]){
					return true;
				}
			}    
		}
		return false;
	}

	public static long[][] parseD(Scanner in) {
		long matrix[][];
		String splitLine[] = in.nextLine().split(" ");
		List<int[]> rowList = new ArrayList<>();
		rowList.add(Arrays.stream(splitLine).mapToInt(Integer::parseInt).toArray());
		matrix = new long[splitLine.length][];
		for(int r = 1; r < matrix.length; r++) {
			splitLine = in.nextLine().split(" ");
			rowList.add(Arrays.stream(splitLine).mapToInt(Integer::parseInt).toArray());
		}
		for(int r =0; r < rowList.size(); r++) {
			int[] ac = rowList.get(r);
			matrix[r] = new long[ac.length];
			for(int c = 0 ; c < ac.length; c++) {
				matrix[r][c] = ac[c];
			}
		}
		return matrix;
	}

	public static long[][] parseData(Scanner in){
		long matrix[][];
		int lineCount = 0;
		String firstLine[] = in.nextLine().split(" ");

		System.out.println("firstLine " + Arrays.toString(firstLine));
		int size  = firstLine.length;
		matrix = new long[size][];
		lineCount = 1;
		String splitLine[] = new String[size];
		for(int r = 0; r < matrix.length; r++) {
			if(lineCount > 1) {
				splitLine = in.nextLine().split(" ");
			}
			matrix[r] = new long[size];
			for(int c = 0; c < matrix[r].length; c++){
				if(lineCount == 1) {
					matrix[r][c] = Integer.parseInt(firstLine[c]);
				} else {			
					matrix[r][c] = Integer.parseInt(splitLine[c]);
				}
			}
			lineCount++;
		}
		return matrix;
	}

	public static boolean isMatrixOfEqualSize(long matrix[][]){
		boolean isEqual = true;
		for(int r = 0; r < matrix.length; r++){
			if(matrix[r].length != matrix.length) {
				isEqual = false;
			}
		}
		System.out.println(" \n isEqual " + isEqual ) ;
		return isEqual;
	}

	public static void printData(long matrix[][]){
		for(int r = 0; r < matrix.length; r++){
			for(int c = 0; c < matrix[r].length; c++){
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}

	static final int MAX = 100; 
	static long[][] mat = new long[MAX][MAX]; 

	// Fills non-one entries in column j 
	// Given that there is a "1" at  
	// position mat[i][j], this function  
	// fills other entries of column j. 
	static void fillRemaining(int i, int j, int n) 
	{ 
		// Initialize value to be filled 
		int x = 2; 

		// Fill all values below i as 2, 3, ...p 
		for (int k = i + 1; k < n; k++) 
			mat[k][j] = x++; 

		// Fill all values above i  
		// as p + 1, p + 2, .. n 
		for (int k = 0; k < i; k++) 
			mat[k][j] = x++; 
	} 

	// Fills entries in mat[][]  
	// with the given set of rules 
	static void constructMatrix(int n) { 
		// Alternatively fill 1s starting from 
		// rightmost and leftmost columns. For 
		// example for n = 3, we get { {_ _ 1}, 
		// {1 _ _} {_ 1 _}} 
		int right = n - 1, left = 0; 
		for (int i = 0; i < n; i++)  { 
			// If i is even, then fill 
			//  next column from right 
			if (i % 2 == 0) 
			{ 
				mat[i][right] = 1; 

				// After filling 1, fill remaining  
				// entries of column "right" 
				fillRemaining(i, right, n); 

				// Move right one column back 
				right--; 
			} 

			// Fill next column from left 
			else
			{ 
				mat[i][left] = 1; 

				// After filling 1, fill remaining  
				// entries of column "left" 
				fillRemaining(i, left, n); 

				// Move left one column forward 
				left++; 
			} 
		} 
	} 

	public static long[][] assignToMatrix(int n) {
		long matrix[][] = new long[n][];
		for (int i = 0; i < n; i++) { 
			matrix[i] = new long[n];
			for (int j = 0 ; j < n; j++) {
				matrix[i][j] = mat[i][j];
			}
		} 
		return matrix;
	}

	public static List<Long> getFinalList(int n){
		List<Long> list = new ArrayList<>();
		LongStream.rangeClosed(1, n).forEach(num -> {
			list.add(getAddition(num, n));
		});
		if(n > 2) {
			list.add(getSummation(n));
		}
		return list.stream().distinct().collect(Collectors.toList());
	}

	public static long[][] constructAndAssignMatrix(int n){
		constructMatrix(n);
		return assignToMatrix(n);
	}

	public static long[][] getRes(int N, int K, long[][] matrix){
		int rotCnt =0;
		for(int i =0; i< (N*N); i++) {
			if(rotCnt == N-1) {
				constructAndAssignMatrix(N);
				result =  isLatinSquare(matrix, K);
			}
			for(rotCnt =0; rotCnt< N-1; rotCnt++) {
				if(result.equals("IMPOSSIBLE")) {
					rotateMatrix(N, matrix);
					result =  isLatinSquare(matrix, K);
				}
			} 
		}
		return matrix;
	}

	public static void main(String[] args) {
		long matrix[][];
		int N, K;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = sc.nextInt();

		for (int t = 1; t <= testCount; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			List<Long> additionList = getFinalList(N);
			if(additionList.contains((long)K)) {
				matrix = constructAndAssignMatrix(N);
				printData(matrix);
				result =  isLatinSquare(matrix, K);
				getRes(N,K,matrix);
				System.out.println("Case #" + t + ": "+  result);
				if(result.equals("POSSIBLE")) {
					printData(matrix);
				}
			} else {
				System.out.println("Case #" + t + ": "+  result);
			}
		}
	}
}