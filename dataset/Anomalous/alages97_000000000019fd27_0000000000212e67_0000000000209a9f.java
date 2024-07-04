import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder modifiedString = new StringBuilder(input);
            int oneStartIndex = -1;
            int parenInsertCount = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1' && oneStartIndex == -1) {
                    oneStartIndex = i;
                } else if (input.charAt(i) == '0' && oneStartIndex != -1) {
                    parenInsertCount++;
                    modifiedString.insert(i + parenInsertCount - 1, ')');
                    modifiedString.insert(oneStartIndex + parenInsertCount - 1, '(');
                    oneStartIndex = -1;
                }
            }

            if (oneStartIndex != -1) {
                modifiedString.append(')');
                modifiedString.insert(oneStartIndex, '(');
            }

            System.out.println("Case #" + caseNum + ": " + modifiedString.toString());
        }

        scanner.close();
    }
}