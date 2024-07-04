import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder news = new StringBuilder();
            int k = 0;
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char g = s.charAt(j);
                int l = g - '0';

                if (k > l) {
                    while (!stack.isEmpty() && k > l) {
                        stack.pop();
                        k--;
                        news.append(')');
                    }
                    news.append(g);
                } else if (k < l) {
                    while (k < l) {
                        stack.push('(');
                        k++;
                        news.append('(');
                    }
                    news.append(g);
                } else {
                    news.append(g);
                }
            }

            while (!stack.isEmpty()) {
                stack.pop();
                news.append(')');
            }

            System.out.println("Case #" + i + ": " + news.toString());
        }
    }
}