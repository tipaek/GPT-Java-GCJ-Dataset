import java.util.*;

public class Solution{
    private static String nestingString(String s) {
        Stack<Character> stack = new Stack<>();
        int previous = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            // Case 1: if current digit is less push closing as many diff times
            // Case 2: if current digit is greater push opening as many diff times
            // Case 2: if current digit is equal do nothing
            
            int current = s.charAt(i) - '0';
            
            if (previous > current) {
                int diff = Math.abs(previous - current);
                while (diff > 0) {
                    stack.push(')');
                    diff--;
                }
            } else if (previous < current) {
                int diff = Math.abs(previous - current);
                while (diff > 0) {
                    stack.push('(');
                    diff--;
                }
            }
            
            stack.push(s.charAt(i));
            previous = current;
        }
        
        while (previous > 0) {
            stack.push(')');
            previous--;
        }
        
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        String result = sb.reverse().toString();
        return result;
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            String s = sc.next();
            System.out.print("Case #" + i + ": " + nestingString(s));
            System.out.println("");
        }
     }
}