import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int t1 = t;
        while (t-- > 0) {
            final String input = scanner.next();
            final StringBuilder ans = new StringBuilder();
            int openCount = 0;
            for (int i = 0; i < input.length(); i++) {
                final int nextDig = input.charAt(i) - '0';
                while (openCount < nextDig) {
                    ans.append("(");
                    openCount++;
                }
                while (openCount > nextDig) {
                    ans.append(")");
                    openCount--;
                }
                ans.append(nextDig);
            }
            while (openCount > 0) {
                ans.append(")");
                openCount--;
            }
            System.out.println("Case #" + (t1-t) + ": "+ ans.toString());
        }
    }
}
