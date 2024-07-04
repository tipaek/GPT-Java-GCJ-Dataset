import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        int queryCount = 0;
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < b; j++) {
                System.out.println(j + 1);
                line.append(scanner.nextLine());
                queryCount++;
            }

            String[] parsed = new String[b / 10];
            for (int j = 0; j < b / 10; j++) {
                parsed[j] = line.substring(10 * j, 10 * j + 10);
            }

            boolean succeeded = false;

            while (!succeeded && queryCount < 150) {
                StringBuilder test = new StringBuilder();
                for (int j = 0; j < 10; j++) {
                    System.out.println(j + 1);
                    test.append(scanner.nextLine());
                }

                if (parsed[0].equals(test.toString())) {
                    System.out.println(line);
                    succeeded = scanner.nextLine().equals("Y");
                } else if (isNeg(parsed[0], test.toString())) {
                    System.out.println(createNeg(line.toString()));
                    succeeded = scanner.nextLine().equals("Y");
                } else if (isRev(parsed[0], test.toString())) {
                    System.out.println(createRev(line.toString()));
                    succeeded = scanner.nextLine().equals("Y");
                } else {
                    System.out.println(createRevNeg(line.toString()));
                    succeeded = scanner.nextLine().equals("Y");
                }
            }
        }
    }

    private static String createRevNeg(String line) {
        return createRev(createNeg(line));
    }

    private static String createRev(String line) {
        return new StringBuilder(line).reverse().toString();
    }

    private static String createNeg(String line) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            int tmp = Math.abs(Character.getNumericValue(line.charAt(i)) - 1);
            output.append(tmp);
        }
        return output.toString();
    }

    private static boolean isNeg(String s, String test) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == test.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRev(String s, String test) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != test.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}