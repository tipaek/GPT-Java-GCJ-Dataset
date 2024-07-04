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

    private static void process(int rows, int columns) {
        int k = (rows * columns) - rows;
        System.out.println((rows - 1) * (columns - 1));
        
        for (int i = rows - 1; i > 0; i--) {
            for (int j = columns - 1; j > 0; j--) {
                System.out.println(k + " " + i);
                k--;
            }
        }
    }
}