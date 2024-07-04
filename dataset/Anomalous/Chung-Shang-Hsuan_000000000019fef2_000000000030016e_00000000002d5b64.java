import java.util.Scanner;

public class Solution {

    public Solution(int caseNumber, int rows, int size) {
        if (rows == 2) {
            handleCaseForTwoRows(caseNumber, size);
        } else if (rows == 3) {
            handleCaseForThreeRows(caseNumber, size);
        } else if (rows == 4) {
            handleCaseForFourRows(caseNumber, size);
        } else {
            handleDefaultCase(caseNumber);
        }
    }

    private void handleCaseForTwoRows(int caseNumber, int size) {
        System.out.println("Case #" + caseNumber + ": " + (size - 1));
        int k = size * 2 - 3;
        for (int i = 0; i < size - 1; i++) {
            System.out.println("2 " + k);
            k--;
        }
    }

    private void handleCaseForThreeRows(int caseNumber, int size) {
        System.out.println("Case #" + caseNumber + ": " + (size * 2 - 2));
        int k = size * 3 - 4;
        for (int i = 0; i < size - 1; i++) {
            System.out.println("3 " + k);
            k--;
        }
        k = size * 2 - 3;
        for (int i = 0; i < size - 1; i++) {
            System.out.println("2 " + k);
            k--;
        }
    }

    private void handleCaseForFourRows(int caseNumber, int size) {
        if (size == 2) {
            System.out.println("Case #" + caseNumber + ": 3");
            System.out.println("4 3");
            System.out.println("3 2");
            System.out.println("2 1");
        } else if (size == 3) {
            System.out.println("Case #" + caseNumber + ": 6");
            System.out.println("4 7");
            System.out.println("4 6");
            System.out.println("3 5");
            System.out.println("3 4");
            System.out.println("2 3");
            System.out.println("2 2");
        }
    }

    private void handleDefaultCase(int caseNumber) {
        System.out.println("Case #" + caseNumber + ": 4");
        System.out.println("5 4");
        System.out.println("4 3");
        System.out.println("3 2");
        System.out.println("2 1");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            int rows = scanner.nextInt();
            int size = scanner.nextInt();
            new Solution(i, rows, size);
        }
    }
}