import java.util.*;
import java.io.*;

public class Solution {
    static boolean isTest = false;

    public static void main(String[] args) throws Exception {
        Scanner scanner = getScanner();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            scanner.nextLine();  // Consume the remaining newline

            System.out.println("Case #" + (i + 1) + ": " + (rows - 1) * (columns - 1));

            for (int j = rows; j > 1; j--) {
                for (int k = 0; k < columns - 1; k++) {
                    System.out.println(((j * columns - j) - k) + " " + (j - 1));
                }
            }
        }
    }

    static Scanner getScanner() throws Exception {
        if (isTest) {
            return new Scanner(new File("input.txt"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    static void debug(String message) {
        if (isTest) {
            System.out.println(message);
        }
    }
}