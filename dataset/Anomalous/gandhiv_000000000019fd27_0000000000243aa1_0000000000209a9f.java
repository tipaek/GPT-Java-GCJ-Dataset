import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            List<Character> result = new ArrayList<>();
            char previousChar = '0';

            for (char currentChar : inputString.toCharArray()) {
                if (currentChar != previousChar) {
                    if (previousChar != '0') {
                        result.add(')');
                    }
                    previousChar = currentChar;
                    result.add('(');
                }
                result.add(currentChar);
            }

            if (previousChar != '0') {
                result.add(')');
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}