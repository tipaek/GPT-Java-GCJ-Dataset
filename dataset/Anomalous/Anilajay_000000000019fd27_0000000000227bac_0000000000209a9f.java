import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            String inputString = scanner.next();
            char[] characters = inputString.toCharArray();
            int consecutiveOnesCount = 1;
            
            for (int index = 0; index < characters.length; index++) {
                if (characters[index] == '0') {
                    System.out.print('0');
                } else if (index < characters.length - 1 && characters[index] == '1' && characters[index + 1] == '1') {
                    consecutiveOnesCount++;
                } else {
                    System.out.print('(');
                    for (int k = 0; k < consecutiveOnesCount; k++) {
                        System.out.print('1');
                    }
                    System.out.print(')');
                    consecutiveOnesCount = 1;
                }
            }
            System.out.println();
        }
    }
}