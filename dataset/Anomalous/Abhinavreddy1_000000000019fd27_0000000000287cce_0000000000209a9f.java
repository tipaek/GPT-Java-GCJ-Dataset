import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int t = Integer.parseInt(br.readLine());
            
            for (int p = 1; p <= t; p++) {
                String s = br.readLine();
                StringBuilder sb = new StringBuilder();
                
                for (char c : s.toCharArray()) {
                    int num = c - '0';
                    sb.append("(".repeat(num)).append(c).append(")".repeat(num));
                }
                
                Stack<Character> stack = new Stack<>();
                for (int i = sb.length() - 1; i >= 0; i--) {
                    char currentChar = sb.charAt(i);
                    if (currentChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(currentChar);
                    }
                }
                
                StringBuilder ans = new StringBuilder();
                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
                
                bw.write("Case #" + p + ": " + ans.reverse().toString() + "\n");
            }
            bw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}