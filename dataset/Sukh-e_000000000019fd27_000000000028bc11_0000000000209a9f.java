import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int f=1;f<=t;f++){
           String a=s.next();
           Stack<Character> stack=new Stack<>();
           int p=0;
           StringBuilder sbr=new StringBuilder("");
           while(p<a.length()){
               int ch=a.charAt(p)-'0';
               int size=stack.size();
               int r=ch-size;
               if(r>0){
                   for(int i=0;i<r;i++){
                       stack.push('(');
                       sbr.append('(');
                   }
               }
               else if(r<0){
                   for(int i=0;i<Math.abs(r);i++){
                       stack.pop();
                       sbr.append(')');
                   }
               }
               sbr.append(a.charAt(p));
               p++;
           }
           while(stack.size()!=0){
               stack.pop();
               sbr.append(')');
           }
           System.out.println("Case #"+f+": "+sbr);
           
        }
    }
}