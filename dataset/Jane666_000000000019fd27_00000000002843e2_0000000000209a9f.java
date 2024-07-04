import java.util.*;

public class Solution {
    public static void solve(Scanner input, int t) {
        // get the input
        String digitsStr = input.next();
        char[] d = digitsStr.toCharArray();
        List<Character> digits = new ArrayList<>();
        List<Character> ans = new ArrayList<>();
        int max = 0;
        for (char ch : d) {
            // int v = ch - '0';
            digits.add(ch);
            ans.add(ch);
            max = Math.max(ch - '0', max);
        }
        
        while (max > 0) {
            // System.out.println(digits);
            int left = -1, right = -1;
    
            for (int i = 0; i < digits.size(); i++) {
                // System.out.println("i = " + i);
                if (digits.get(i) - '0' > 0 && left == -1) {
                    left = i;
                }
                if (digits.get(i) - '0' <= 0 && left != -1) {
                    right = i;
                }
                if (digits.get(i) - '0' > 0) {
                    digits.set(i, (char) (digits.get(i) - 1));
                }
                
                if (left != -1) {
                    if (right != -1) {
                        // System.out.println("add ()");
                        // System.out.println(left + "," + right);
                        digits.add(left, '(');
                        ans.add(left, '(');
                        digits.add(right + 1, ')');
                        ans.add(right + 1, ')');
                        left = -1;
                        right = -1;
                        i += 2;
                    } else if (i == digits.size() - 1) {
                        digits.add(left, '(');
                        ans.add(left, '(');
                        // System.out.println("reach the end");
                        digits.add(digits.size(), ')');
                        ans.add(digits.size() - 1, ')');
                        left = -1;
                        right = -1;
                        i += 2;
                    }
                }
                // System.out.println(left + "," + right);
                // System.out.println(digits);
                // System.out.println(ans);
            }
            // System.out.println(digits);
            // System.out.println(ans);
            max--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : ans) {
            sb.append(ch);
        }
        System.out.println("Case #" + t + ": " + sb.toString());
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(input, i);
        }
    }
}