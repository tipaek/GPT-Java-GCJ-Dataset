import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for(int i=1;i<=t;i++){
            Stack<Character> stack = new Stack();
            String  input = s.next();
            int size = input.length();
            if(input.charAt(0) == '0')
                stack.push('0');
            else{
                stack.push('(');
                stack.push('1');
            }
            for(int j=1;j<size;j++){
                char temp = input.charAt(j);
                if(stack.peek() != temp){
                    if(stack.peek() == '0')
                        stack.push('(');
                    else
                        stack.push(')');
                }
                stack.push(temp);
            }
            if(input.charAt(input.length()-1) == '1')
            	stack.push(')');
            String str = new String();
            while(!stack.isEmpty())
                str = stack.pop()+str;
            System.out.println("Case #"+i+": "+str);
        }
    }
}