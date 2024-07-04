import java.util.Scanner;

public class Solution {

    private void printPairs(int rows, int columns) {
        int decrementValue = columns * rows - rows - 1;
        for (int count = 0; count < columns - 1; count++) {
            System.out.println(rows + " " + decrementValue);
            decrementValue--;
        }
    }

    public Solution(int caseNumber, int rows, int columns) {
        System.out.println("Case #" + caseNumber + ": " + (columns - 1) * (rows - 1));
        for (int i = rows; i >= 2; i--) {
            printPairs(i, columns);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            new Solution(caseIndex, rows, columns);
        }
        scanner.close();
    }
}