import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder op = new StringBuilder();
            int openCount = 0;
            int closeCount = 0;

            for (int x = 0; x < s.length(); x++) {
                int currentDigit = Character.getNumericValue(s.charAt(x));
                int balance = openCount - closeCount;

                if (currentDigit == 0) {
                    appendCharacters(op, ')', balance);
                    closeCount += balance;
                    op.append(0);
                } else {
                    int requiredOpen = currentDigit - balance;
                    if (requiredOpen >= 0) {
                        appendCharacters(op, '(', requiredOpen);
                        openCount += requiredOpen;
                    } else {
                        appendCharacters(op, ')', -requiredOpen);
                        closeCount -= requiredOpen;
                    }
                    op.append(currentDigit);
                }
            }

            appendCharacters(op, ')', openCount - closeCount);
            System.out.println("Case #" + (i + 1) + ": " + op.toString());
        }
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}