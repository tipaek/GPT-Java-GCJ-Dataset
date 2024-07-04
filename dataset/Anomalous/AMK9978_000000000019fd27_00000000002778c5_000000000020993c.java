import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            int sum = 0, row = 0, column = 0;

            // Read matrix and calculate diagonal sum
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    arr[j][k] = scanner.nextInt();
                    if (j == k) {
                        sum += arr[j][k];
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < size; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (!hashSet.add(arr[k][j])) {
                        column++;
                        break;
                    }
                }
            }

            // Check for duplicate values in rows
            for (int j = 0; j < size; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (!hashSet.add(arr[j][k])) {
                        row++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + row + " " + column);
        }
    }
}