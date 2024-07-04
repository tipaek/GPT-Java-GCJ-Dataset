import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[])throws Exception {
        InputStreamReader ab = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ab);

        int t = Integer.parseInt(in.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            String s = in.readLine().trim();
            Stack<Character> characterStack = new Stack<>();
            String z = "";
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - '0';
                if (!stack.isEmpty()) {
                    if (stack.peek() != val) {
                        if (!stack.isEmpty()) {
                            int top = stack.pop();
                            for (int j=1;j<=top;j++) {
                                z+=')';
                            }
                        }

                        for(int j=1; j<= val; j++) {
                            z+='(';
                        }
                        z+=val;
                        stack.push(val);
                    } else if (stack.peek() == val) {
                        z+=val;
                    }
                } else {
                    for(int j=1; j<= val; j++) {
                        z+='(';
                    }
                    z+=val;
                    stack.push(val);
                }
            }

            int last = s.charAt(s.length() - 1) - '0';
            for (int i =1;i<=last;i++) {
                z+=')';
            }
            System.out.println("Case #" + tc + ": " + z );
        }
    }
}
