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

    public static void processTestCase(int caseIndex, int size, Scanner scanner) {
        String[] leftParts = new String[size];
        String[] rightParts = new String[size];

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine().replace('*', ' ').trim();

            if (row.isEmpty()) {
                continue;
            }

            if (row.startsWith(" ")) {
                leftParts[i] = "";
                rightParts[i] = row.trim();
            } else if (row.endsWith(" ")) {
                leftParts[i] = row.trim();
                rightParts[i] = "";
            } else {
                String[] splitRow = row.split(" ");
                leftParts[i] = splitRow[0];
                rightParts[i] = splitRow[1];
            }
        }

        boolean isInvalid = false;
        String leftResult = "";

        for (String leftPart : leftParts) {
            if (leftResult.isEmpty()) {
                leftResult = leftPart;
            } else if (leftResult.contains(leftPart)) {
                continue;
            } else if (leftPart.contains(leftResult)) {
                leftResult = leftPart;
            } else {
                isInvalid = true;
                break;
            }
        }

        String rightResult = "";
        if (!isInvalid) {
            for (String rightPart : rightParts) {
                if (rightResult.isEmpty()) {
                    rightResult = rightPart;
                } else if (rightResult.contains(rightPart)) {
                    continue;
                } else if (rightPart.contains(rightResult)) {
                    rightResult = rightPart;
                } else {
                    isInvalid = true;
                    break;
                }
            }
        }

        String result = leftResult + rightResult;

        if (isInvalid || result.length() > 10000) {
            System.out.println("Case #" + caseIndex + ": *");
        } else {
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}