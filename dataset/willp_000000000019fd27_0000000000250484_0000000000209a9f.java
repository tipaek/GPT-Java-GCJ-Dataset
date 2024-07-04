import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int _t = 1; _t <= t; ++_t) {
            System.out.println("Case #" + _t + ": " + solve(in));
        }
    }
  
    static String solve(Scanner in) {
        String s = in.next();
        StringBuilder answer = new StringBuilder();
        int open = 0, n = 0;
        for (char c : s.toCharArray()) {
            n = c - '0';
            while (open > n) {
                answer.append(')');
                open--;
            }
            while (open < n) {
                answer.append('(');
                open++;
            }
            answer.append(n);
        }
        while (open-- > 0) {
            answer.append(')');
        }
        return answer.toString();
    }
}