package codejam2020;


import java.util.Scanner;

public class Vestigium {

	public static void main(String args[]) {

		int repRowsCount = 0;
		int repColsCount = 0;
		int sumOfMainDiagnal = 0;
		System.out.println("Enter Number Of Test Case ");
		Scanner tCount = new Scanner(System.in);
		int count = tCount.nextInt();
		tCount.close();
		for (int c = 1; c <= count; c++) {
			int matrix[][] = initMatrix();
			try {
				if (Vestigium.latinSquare(matrix)) {
					System.out.println("This is a Latin Square");
					sumOfMainDiagnal = Vestigium.sumOfMainDiagnal(matrix);
					repRowsCount = Vestigium.repeatedRowsCount(matrix);
					repColsCount = Vestigium.repeatedColsCount(matrix);
					System.out.println(" Test Case #" + c + " sumOfMainDiagnal = " + sumOfMainDiagnal + " repRowsCount = "
							+ repRowsCount + " repColsCount = " + repColsCount);
				} else {
					System.out.println("This is not a Latin Square");
					sumOfMainDiagnal = Vestigium.sumOfMainDiagnal(matrix);
					repRowsCount = Vestigium.repeatedRowsCount(matrix);
					repColsCount = Vestigium.repeatedColsCount(matrix);
					System.out.println(" Test Case #" + c + " sumOfMainDiagnal = " + sumOfMainDiagnal + " repRowsCount = "
							+ repRowsCount + " repColsCount = " + repColsCount);
				}
			} catch (Exception e) {

			}
		}

	}

	public static boolean latinSquare(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			// check for duplicates in each row
			if (duplicates(array[i])) {
				return false;
			}

			// create a column array
			int[] column = new int[array[i].length];
			for (int j = 0; j < array.length; j++) {
				column[j] = array[j][i]; // could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
			}

			// check for duplicates in each column
			if (duplicates(column)) {
				return false;
			}
		}
		return true;
	}

	public static boolean duplicates(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static int repeatedRowsCount(int[][] array) {
		int cRows = 0;

		for (int i = 0; i < array.length; i++) {
			// check for duplicates in each row
			if (duplicates(array[i])) {
				++cRows;
			}

		}

		return cRows;
	}

	public static int sumOfMainDiagnal(int[][] mat) {
		int sum = 0;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (i == j) // this condition checks for main diagonal
				{
					sum = sum + mat[i][j];
				}
			}
		}

		return sum;
	}

	public static int repeatedColsCount(int[][] array) {
		int cCols = 0;
		for (int i = 0; i < array.length; i++) {
			// check for duplicates in each row
			if (duplicates(array[i])) {
				++cCols;
			}

		}
		return cCols;
	}

	public static int[][] initMatrix() {
		int matrix[][];
		Scanner filein = null;
		try {
			
			System.out.println("Enter size and matrix");
			//File path = new File("E:\\Eclipse__Projects\\codejam2020\\matrix.txt");
			filein = new Scanner(System.in);			
			int numRows = (filein.hasNext())?filein.nextInt():0;
			matrix = new int[numRows][];
			parseData(matrix, filein);
			
			filein.close();
			return matrix;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (filein != null) {
				filein.close();
			}
			return null;
		}
	}

	public static void parseData(int matrix[][], Scanner in) {
		for (int r = 0; r < matrix.length; r++) {
			String splitLine[] = in.nextLine().split(" ");
			matrix[r] = new int[splitLine.length];
			for (int c = 0; c < matrix[r].length; c++) {
				matrix[r][c] = Integer.parseInt(splitLine[c]);
			}
		}
		printData(matrix);
	}

	public static void printData(int matrix[][]) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}
}