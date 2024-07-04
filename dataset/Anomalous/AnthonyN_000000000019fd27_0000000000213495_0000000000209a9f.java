import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCasesCount = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCasesCount; testCase++) {
            String digits = scanner.nextLine();
            String nestedDigits = nestDigits(digits);
            System.out.println("Case #" + testCase + ": " + nestedDigits);
        }
    }
    
    private static String nestDigits(String input) {
        return input.replaceAll("1", "(1)").replaceAll("\\)\\(", "");
    }
}