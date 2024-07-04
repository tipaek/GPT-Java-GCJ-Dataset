import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            int rows = 0;
            int columns = 0;
            int trace = 0;

            // Read the matrix
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int j = 0; j < size; j++) {
                trace += arr[j][j];
            }

            // Check for duplicate values in rows
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> check = new ArrayList<>();
                boolean repeat = false;
                for (int k = 0; k < size; k++) {
                    if (check.contains(arr[j][k])) {
                        rows++;
                        repeat = true;
                        break;
                    }
                    check.add(arr[j][k]);
                }
            }

            // Check for duplicate values in columns
            for (int k = 0; k < size; k++) {
                ArrayList<Integer> check = new ArrayList<>();
                boolean repeat = false;
                for (int j = 0; j < size; j++) {
                    if (check.contains(arr[j][k])) {
                        columns++;
                        repeat = true;
                        break;
                    }
                    check.add(arr[j][k]);
                }
            }

            // Print the result for the current case
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns);
        }
    }
}