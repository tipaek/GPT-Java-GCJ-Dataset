import java.util.Scanner;

class Solution {
    
    static String appendParentheses(String str, int open, int close) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < open; i++) {
            sb.append('(');
        }
        for (int i = 0; i < close; i++) {
            sb.append(')');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int q = 1; q <= t; q++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int length = s.length();

            int prev = Character.getNumericValue(s.charAt(0));
            result.append(appendParentheses("", prev, 0)).append(s.charAt(0));
            int currentLevel = prev;

            for (int i = 1; i < length; i++) {
                int next = Character.getNumericValue(s.charAt(i));
                int diff = next - prev;

                if (diff > 0) {
                    result.append(appendParentheses("", diff, 0));
                    currentLevel += diff;
                } else {
                    diff = Math.abs(diff);
                    result.append(appendParentheses("", 0, diff));
                    currentLevel -= diff;
                }

                result.append(s.charAt(i));
                prev = next;
            }

            result.append(appendParentheses("", 0, currentLevel));
            System.out.println("Case #" + q + ": " + result.toString());
        }

        sc.close();
    }
}