import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();
        
        for (int round = 1; round <= numberOfRounds; round++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            processTestCase(round, size, scanner);
        }
    }

    public static void processTestCase(int roundIndex, int size, Scanner scanner) {
        boolean patternNotFound = false;
        String commonPattern = "";

        for (int i = 0; i < size; i++) {
            String row = scanner.nextLine();
            String rowPattern = row.substring(1);

            if (row.length() == 0) {
                continue;
            }

            if (commonPattern.isEmpty()) {
                commonPattern = rowPattern;
            } else if (commonPattern.contains(rowPattern)) {
                // Do nothing, commonPattern already contains rowPattern
            } else if (rowPattern.contains(commonPattern)) {
                commonPattern = rowPattern;
            } else {
                patternNotFound = true;
                break;
            }

            if (commonPattern.length() > 10000) {
                break;
            }
        }

        if (patternNotFound || commonPattern.length() > 10000) {
            System.out.println("Case #" + roundIndex + ": *");
        } else {
            System.out.println("Case #" + roundIndex + ": " + commonPattern);
        }
    }
}