import java.util.Scanner;

public class Solution {
    
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        
        int currentNum = Character.getNumericValue(characters[0]);
        for (int i = 0; i < currentNum; i++) {
            result.append("(");
        }
        result.append(currentNum);

        for (int i = 1; i < characters.length; i++) {
            int nextNum = Character.getNumericValue(characters[i]);
            if (nextNum > currentNum) {
                for (int j = 0; j < (nextNum - currentNum); j++) {
                    result.append("(");
                }
            } else if (nextNum < currentNum) {
                for (int j = 0; j < (currentNum - nextNum); j++) {
                    result.append(")");
                }
            }
            result.append(nextNum);
            currentNum = nextNum;
        }

        for (int i = 0; i < currentNum; i++) {
            result.append(")");
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}