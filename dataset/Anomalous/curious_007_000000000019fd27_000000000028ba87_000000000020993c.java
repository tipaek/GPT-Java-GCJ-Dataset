import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            
            int sum = firstNumber + secondNumber;
            int product = firstNumber * secondNumber;
            
            System.out.println("Case #" + caseNumber + ": " + sum + " " + product);
        }
    }
}