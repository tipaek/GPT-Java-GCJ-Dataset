import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc=new Scanner(System.in);
        int z=sc.nextInt();
        for(int t=1;t<=z;t++)
        {
           String s=sc.next();
           
           Stack<Character> st=new Stack<>();
           Stack<Character> temp=new Stack<>();
           int d=0,d1=0;
           for(int i=0;i<s.length();i++)
           {
               char ch=s.charAt(i);
               if(ch=='0')
               st.push(ch);
               else
               {
                   if(!st.isEmpty() && st.peek()==')')
                   {
                       int c=0;
                       while(!st.isEmpty() && st.peek()==')' && c<(int)(ch-'0'))
                       {
                           temp.push(st.pop());
                            c++;
                       }
                       
                       if(c==ch-'0')
                       {
                           st.push(ch);
                           while(!temp.isEmpty())
                           st.push(temp.pop());
                       }
                       
                       else
                       {
                           d=ch-'0'-c;
                         d1=d;
                           while(d>0) {st.push('(');d--;}
                           st.push(ch);
                           while(d1>0) {st.push(')');d1--;}
                           while(!temp.isEmpty())
                           st.push(temp.pop());
                           
                       }
                       
                   }
                   else if(st.isEmpty() || (!st.isEmpty() && st.peek()!=')'))
                   {
                       d=ch-'0';
                           d1=d;
                           while(d>0) {st.push('(');d--;}
                           st.push(ch);
                           while(d1>0) {st.push(')');d1--;}
                   }
                   
               }
           }
           
           StringBuilder ans=new StringBuilder();
           while(!st.isEmpty())
           ans.append(st.pop());
           
           ans=ans.reverse();
           
           System.out.println("Case #"+t+": "+ans); 
        }
      //  System.out.println("XXXXXXXX");
    }
}
