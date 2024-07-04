import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();
        
        for (int round = 1; round <= numberOfRounds; round++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            processTestCase(round, size, scanner);
        }
    }

    public static void processTestCase(int index, int size, Scanner scanner) {
        String[] leftParts = new String[size];
        String[] rightParts = new String[size];

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine().replace('*', ' ').trim();
            if (row.isEmpty()) {
                continue;
            }
            String[] parts = row.split(" ", 2);
            if (parts.length == 1) {
                if (row.startsWith(" ")) {
                    leftParts[i] = "";
                    rightParts[i] = parts[0];
                } else {
                    leftParts[i] = parts[0];
                    rightParts[i] = "";
                }
            } else {
                leftParts[i] = parts[0];
                rightParts[i] = parts[1];
            }
        }

        String leftResult = findCommonPart(leftParts);
        String rightResult = findCommonPart(rightParts);

        if (leftResult == null || rightResult == null) {
            System.out.println("Case #" + index + ": *");
        } else {
            System.out.println("Case #" + index + ": " + leftResult + rightResult);
        }
    }

    public static String findCommonPart(String[] parts) {
        String commonPart = "";
        for (String part : parts) {
            if (part == null || part.isEmpty()) continue;
            if (commonPart.isEmpty()) {
                commonPart = part;
            } else if (commonPart.contains(part)) {
                continue;
            } else if (part.contains(commonPart)) {
                commonPart = part;
            } else {
                return null;
            }
        }
        return commonPart;
    }
}