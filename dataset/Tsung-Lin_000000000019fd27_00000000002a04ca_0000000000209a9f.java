import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for(int cs = 1; cs <= cases; cs++) {
          String s = sc.nextLine();
          ans(s, cs);
        }
    }
    private static void ans(String s, int cs){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            int n = Integer.parseInt("" + c);
            while(stack.size() < n) {
                sb.append('(');
                stack.push(')');
            }
            while(stack.size() > n) sb.append(stack.pop());
            sb.append(c);
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println("Case #" + cs + ": " + sb.toString());
    }
}