import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            processRanks(scanner.nextInt(), scanner.nextInt());
        }
    }

    private static void processRanks(int r, int s) {
        int operationsCount = (s - 1) * (r - 1);
        System.out.println(operationsCount);

        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < s - 1; j++) {
                int firstValue = (s - 1) * (r - i) - j;
                int secondValue = r - i - 1;
                System.out.println(firstValue + " " + secondValue);
            }
        }
    }
}