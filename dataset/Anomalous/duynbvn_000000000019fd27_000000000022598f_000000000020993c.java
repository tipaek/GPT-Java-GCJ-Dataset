import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
                int firstNumber = scanner.nextInt();
                int secondNumber = scanner.nextInt();
                int sum = firstNumber + secondNumber;
                int product = firstNumber * secondNumber;
                System.out.println("Case #" + caseNumber + ": " + sum + " " + product);
            }
        }
    }
}