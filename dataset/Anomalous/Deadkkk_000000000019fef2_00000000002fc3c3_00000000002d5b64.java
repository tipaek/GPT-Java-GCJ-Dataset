import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[] rows = new int[testCases];
        int[] columns = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            rows[i] = scanner.nextInt();
            columns[i] = scanner.nextInt();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            process(rows[i], columns[i]);
        }
    }

    private static void process(int rowCount, int columnCount) {
        int totalOperations = (rowCount * columnCount) - rowCount;
        System.out.println((rowCount - 1) * (columnCount - 1));

        for (int i = rowCount - 1; i > 0; i--) {
            for (int j = columnCount - 1; j > 0; j--) {
                System.out.println(totalOperations + " " + i);
                totalOperations--;
            }
        }
    }
}