import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        int testCaseNum = 0;
        while (t-- > 0) {
            testCaseNum += 1;
            String text = input.nextLine();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i = 0; i < text.length(); i++) {
                int digit = text.charAt(i) - '0';
                if (open < digit) {
                    for (int j = 0; j < digit - open; j++) {
                        sb.append('(');
                    }
                    open = digit;
                }
                if (open > digit) {
                    for (int j = 0; j < open - digit; j++) {
                        sb.append(')');
                    }
                    open = digit;
                }
                sb.append(text.charAt(i));
            }
            for (int i = 0; i < open; i++) {
                sb.append(')');
            }
            System.out.println("Case #" + testCaseNum + ": " + sb.toString());
        }
    }
}