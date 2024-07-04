import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            char[] arr = (sc.next() + "0").toCharArray();

            Stack<Integer> st = new Stack<>();
            st.add(0);
            StringBuilder sb = new StringBuilder();
            for (char ch: arr) {
                int val = ch - '0';
                int pos = st.peek();

                int i = pos;
                while (i < val) {
                    i++;
                    sb.append("(");
                    st.push(i);
                }

                while (i > val) {
                    i--;
                    st.pop();
                    sb.append(")");
                }
                sb.append(val);
            }
            System.out.println("Case #" + tt + ": " + sb.substring(0, sb.length()-1));
        }
    }
}