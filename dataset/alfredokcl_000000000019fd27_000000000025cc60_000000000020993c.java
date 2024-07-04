import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int row = in.nextInt();
            int col = row;
            in.nextLine();

            int arr[][] = buildMatrix(in, row);

            System.out.println("Case #" + i + ": " + findTrace(arr, row) + " "
                    + countRowsWithDuplicates(arr, row) + " " + countColWithDuplicates(arr, row));
        }
    }

    private static int[][] buildMatrix(Scanner scanner, int rows) {
        int array[][] = new int[rows][rows];
        for(int index = 0; index < rows; index++) {
            String row = scanner.nextLine();

            String[] numbers = row.trim().split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                array[index][j] = Integer.parseInt(numbers[j]);
            }
        }
        return array;
    }

    private static int findTrace(int array[][], int row) {
        int sum = 0;
        for (int i=0; i < row; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    private static int countRowsWithDuplicates(int[][] inArray, int rows) {
        int repeated = 0;
        int repeatingRow = 0;
        boolean rep = false;
        for (int row = 0; row < rows; row++) {
            int[] selectedRow = new int[inArray[row].length];
            System.arraycopy(inArray[row], 0, selectedRow, 0, inArray[row].length);

            for (int i = 0; i < selectedRow.length; i++) {
                for (int j = i + 1; j < selectedRow.length; j++) {
                    if (selectedRow[i] == selectedRow[j]) {
                        repeated++;
                        rep = true;
                    }
                }
            }
            if (repeated > 0 && rep) {
                repeatingRow++;
            }
            rep = false;
        }
        return repeatingRow;
    }

    private static int countColWithDuplicates(int[][] inArray, int rows) {
        int repeated = 0;
        int repeatingCol = 0;
        boolean rep = false;
        for (int col = 0; col < rows; col++) {
            int[] column = new int[rows];
            for(int i = 0; i < column.length; i++) {
                column[i] = inArray[i][col];
            }

            for (int i = 0; i < column.length; i++) {
                for (int j = i + 1; j < column.length; j++) {
                    if (column[i] == column[j]) {
                        repeated++;
                        rep = true;
                    }
                }
            }
            if (repeated > 0 && rep) {
                repeatingCol++;
            }
            rep = false;
        }
        return repeatingCol;
    }
}
