import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();
            int sum = number1 + number2;
            int product = number1 * number2;
            
            System.out.println("Case #" + caseNumber + ": " + sum + " " + product);
        }
        
        scanner.close();
    }
}