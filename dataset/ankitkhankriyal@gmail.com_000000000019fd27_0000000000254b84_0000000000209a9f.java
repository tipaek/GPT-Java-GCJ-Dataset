
import java.util.*;

public class Solution {
    public static void putBrackets(StringBuilder x1,int times,char bracket){
        for(int i=1;i<=times;i++){
            x1.append(bracket);
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int x = 1;
        while (t-- != 0) {
            String str=s.next();
            StringBuilder ans=new StringBuilder();
            int len=str.length();
            Stack<Integer> stack=new Stack<>();
            stack.push(0);
            for(int i=0;i<len;i++){
                if(stack.size()==1&&str.charAt(i)==0){
                    ans.append(str.charAt(i));
                    
                }
                else{
                    int curr=Integer.parseInt(str.charAt(i)+"");
                    if(curr>stack.peek()){
                        putBrackets(ans,curr-stack.peek(),'(');
                        ans.append(curr);
                        stack.push(curr);
                    }
                    else{
                        putBrackets(ans,stack.peek()-curr,')');
                        stack.pop();
                        ans.append(curr);
                        stack.push(curr);
                    }
                }
            }
            while(stack.size()!=1){
                int x1=stack.peek();
                stack.pop();
                int x2=stack.peek();
                putBrackets(ans,x1-x2,')');
            }
            System.out.println("Case #"+x+": "+ans.toString());
            x++;
        }
    }
}
