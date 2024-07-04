import java.util.*;
import java.io.*;

public class Solution {
    static boolean isTest = false;

    public static void main(String[] args) throws Exception {
        Scanner scanner = getScanner();
        int T = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < T; i++) {
            boolean isFound = false;
            for (int x = -5; x <= 5; x++) {
                for (int y = -5; y <= 5; y++) {
                    System.out.println(x + " " + y);
                    String verdict = scanner.nextLine();
                    if (verdict.equals("CENTER") || verdict.equals("WRONG")) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) break;
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