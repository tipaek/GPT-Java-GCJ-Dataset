import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();
        
        for (int i = 1; i <= numberOfRounds; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            processTestCase(i, size, scanner);
        }
    }

    private static void processTestCase(int caseIndex, int size, Scanner scanner) {
        boolean mismatchFound = false;
        String leftPart = "";
        String rightPart = "";

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine().replace('*', ' ').trim();

            if (row.isEmpty()) {
                continue;
            }

            String leftSegment = "";
            String rightSegment = "";

            if (row.startsWith(" ")) {
                rightSegment = row.trim();
            } else if (row.endsWith(" ")) {
                leftSegment = row.trim();
            } else {
                String[] parts = row.split(" ");
                leftSegment = parts[0];
                rightSegment = parts[1];
            }

            if (leftPart.isEmpty()) {
                leftPart = leftSegment;
            } else if (!leftPart.contains(leftSegment) && !leftSegment.contains(leftPart)) {
                mismatchFound = true;
                break;
            } else if (leftSegment.contains(leftPart)) {
                leftPart = leftSegment;
            }

            if (rightPart.isEmpty()) {
                rightPart = rightSegment;
            } else if (!rightPart.contains(rightSegment) && !rightSegment.contains(rightPart)) {
                mismatchFound = true;
                break;
            } else if (rightSegment.contains(rightPart)) {
                rightPart = rightSegment;
            }
        }

        String result = leftPart + rightPart;

        if (mismatchFound || result.length() > 10000) {
            System.out.println("Case #" + caseIndex + ": *");
        } else {
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}