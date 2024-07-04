import java.util.*;
import java.io.*;

public class Solution {
    
    private static String solve(String s) {
        // Idea: greedy bracket matching keeping track of the number of open
        //       brackets.
        // E.g.
        // 032100
        // 0 -> no bracket, 0 open
        // 3 -> append 3 opening brackets, 3 open
        // 2 -> append 1 closing bracket, 2 open
        // 1 -> append 1 closing bracket, 1 open
        // 0 -> append 1 closing bracket, 0 open
        // 0 -> do nothing
        // end -> do nothing
        //
        // E.g.
        // 111
        // 1 -> append 1 opening bracket
        // 1 -> do nothing
        // 1 -> do nothing
        // end -> append 1 closing bracket
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()) {
            int x = c - '0';
            if(x > open) {
                int diff = x-open;
                for(int i = 0; i < diff; i++) {
                    sb.append('(');
                    open++;
                }
            } else if(x < open) {
                int diff = open-x;
                for(int i = 0; i < diff; i++) {
                    sb.append(')');
                    open--;
                }
            }
            sb.append(c);
        }
        for(int i = 0; i < open; i++) {
            sb.append(')');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine().trim();
            String solution = solve(s);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
  
}
