import java.util.HashMap;
import java.util.Scanner;

public class Temp {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	int numberOfTestCases = input.nextInt();

	for (int i = 1; i <= numberOfTestCases; i++) {

	    int matrixSize = input.nextInt();

	    int trace = 0;

	    int[][] matrix = new int[matrixSize][matrixSize];

	    int duplicatesInRow = 0;
	    int duplicatesInColumn = 0;

	    for (int row = 0; row < matrixSize; row++) {
		for (int column = 0; column < matrixSize; column++) {
		    int num = input.nextInt();
		    matrix[row][column] = num;
		    if (row == column)
			trace += num;
		}
	    }

	    for (int row = 0; row < matrixSize; row++) {

		HashMap<Integer, Integer> duplicates = new HashMap<Integer, Integer>();

		for (int column = 0; column < matrixSize; column++) {
		    int num = matrix[row][column];
		    if (duplicates.containsKey(num)) {
			duplicatesInRow++;
			break;
		    } else {
			duplicates.put(num, num);
		    }
		}

	    }

	    for (int column = 0; column < matrixSize; column++) {

		HashMap<Integer, Integer> duplicates = new HashMap<Integer, Integer>();

		for (int row = 0; row < matrixSize; row++) {
		    int num = matrix[row][column];
		    if (duplicates.containsKey(num)) {
			duplicatesInColumn++;
			break;
		    } else {
			duplicates.put(num, num);
		    }
		}

	    }

	    for (int row = 0; row < matrixSize; row++) {
		for (int column = 0; column < matrix.length; column++) {
		    System.out.print(matrix[row][column] + " ");
		}
		System.out.println();
	    }

	    System.out.println("Case #" + i + ": " + trace + " " + duplicatesInRow + " " + duplicatesInColumn);

	}

    }
}