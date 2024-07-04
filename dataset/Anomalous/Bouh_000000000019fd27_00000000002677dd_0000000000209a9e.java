import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            processInput(scanner);
        }
    }

    private static void processInput(Scanner scanner) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            handleTestCase(scanner, bitLength);
        }
    }

    private static void handleTestCase(Scanner scanner, int bitLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= bitLength; i++) {
            System.out.println(i);
            result.append(scanner.next());
        }
        System.out.println(result.toString());
        String response = scanner.next();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Unexpected response");
        }
    }
}