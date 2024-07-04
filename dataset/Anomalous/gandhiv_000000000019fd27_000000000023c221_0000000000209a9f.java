import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            List<Character> result = new ArrayList<>();
            boolean isOpen = false;

            for (char ch : input.toCharArray()) {
                if (ch == '1' && !isOpen) {
                    result.add('(');
                    result.add(ch);
                    isOpen = true;
                } else if (ch == '0' && isOpen) {
                    result.add(')');
                    result.add(ch);
                    isOpen = false;
                } else {
                    result.add(ch);
                }
            }

            if (isOpen) {
                result.add(')');
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }

        scanner.close();
    }
}