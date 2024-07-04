import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public String getParanthesizedString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = c - '0';

            int closeCnt = 0, j = 0;
            while (!st.isEmpty() && (st.peek() == ')') && (j < n)) {
                closeCnt++;
                j++;
                st.pop();
            }

        //    System.out.println(n + " " + closeCnt);
            j = n - closeCnt;
            while (j > 0) {
                st.push('(');
                j--;
            }

            st.push(c);

            j = n;
            while (j > 0) {
                st.push(')');
                j--;
            }

        //    System.out.println(st);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int t;
        String str = null;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            str = sc.next();
            System.out.println("Case #" + tc + ": " + s.getParanthesizedString(str));
        }
    }
}
