import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tt =t;
        while(t-->0){
            String s = sc.next();
            LinkedList<Character> stack = new LinkedList();
            int open = 0;
            int start = s.charAt(0)-'0';
            for(int i=0;i<start;i++){
                stack.addLast('(');
            }
            stack.addLast(s.charAt(0));
            open = start;
            for(int i=1;i<s.length();i++){
                char ch = s.charAt(i);
                int curr = ch-'0';
                if(curr==open){
                    stack.addLast(ch);
                }
                else if(curr>open){
                    for(int j=0;j<curr-open;j++){
                        stack.addLast('(');
                    }
                    stack.addLast(ch);
                    open = curr;
                }
                else{
                    for(int j=0;j<open-curr;j++){
                        stack.addLast(')');
                    }
                    stack.addLast(ch);
                    open = curr;
                }
                
            }
            for(int j=0;j<open;j++){
                stack.addLast(')');
            }
            
            String ans = "";
            while(!stack.isEmpty()){
                ans+=stack.removeFirst();
            }
            System.out.println("Case #"+(tt-t)+": "+ans);
        }
    }
}