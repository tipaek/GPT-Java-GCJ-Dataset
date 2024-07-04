import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int intArray[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    intArray[j][k] = in.nextInt();
                }
            }
            int repeatedRow = 0;
            int repeatedColumn = 0;
            int trace = 0;
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(temp, 0);
                if (isRowRepeated(intArray, j, temp)) repeatedRow++;
                Arrays.fill(temp, 0);
                if (isColumnsRepeated(intArray, j, temp)) repeatedColumn++;
                trace += intArray[j][j];
            }
            String result = String.format("Case #%d: %d %d %d", i, trace, repeatedRow, repeatedColumn);
            System.out.println(result);
        }
    }

    private static boolean isRowRepeated(int arr[][], int rowIndex, int temp[]) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[rowIndex][i];
            int dstIndex = num - 1;
            if (temp[dstIndex] != 0) {
                return true;
            }
            temp[dstIndex] = num;
        }
        return false;
    }

    private static boolean isColumnsRepeated(int array[][], int columnIndex, int temp[]) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i][columnIndex];
            int dstIndex = num - 1;
            if (temp[dstIndex] != 0) {
                return true;
            }
            temp[dstIndex] = num;
        }
        return false;
    }
}
