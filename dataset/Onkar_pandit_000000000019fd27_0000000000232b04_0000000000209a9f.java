import java.util.*;

public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int index=1;index<=t;index++) {
            String n = sc.nextLine();
            Queue<Character> st = new LinkedList<Character>();
            int initial = 0;
            int open =0, close=0;
            for (int i =0;i<n.length();i++) {
                int num = n.charAt(i)-'0';
                if (num>=initial) {
                    int diff = num-initial;
                    while(diff-->0) {
                        st.add('(');
                        open++;
                    }
                } else {
                    int diff = initial-num;
                    while(diff-->0) {
                        st.add(')');
                        close++;
                    }
                }
                st.add(n.charAt(i));
                initial = num;
            }
            for (int i =0;i<open-close;i++) {
                st.add(')');
            }
            System.out.print("Case #"+index+": ");
            while(!st.isEmpty()) {
                System.out.print(st.poll());
            }
            System.out.println();
        }
        
    }
}