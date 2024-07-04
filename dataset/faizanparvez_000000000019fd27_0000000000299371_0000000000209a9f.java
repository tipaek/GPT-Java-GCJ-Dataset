import java.util.*;

class Solution {
public static void main (String[] args) {
   Scanner in=new Scanner(System.in);
   int t=in.nextInt();
   while(t-->0)
   {
       String input=in.next();
       solve(input);
   }
}

static void solve(String input){
   String ans="";
   char[] arr=input.toCharArray();
   Stack<Integer> s=new Stack<>();
   for(char c : arr ){
       int t=Character.getNumericValue(c);
       int z=t;
       if(s.isEmpty())
           while(t-->0)
               ans+='(';
      else{
          int diff=s.peek()-t;
          if(diff>0){
              ans+=s.pop();
              while(diff-->0)
               ans+=')';
          }
          else if(diff<0){
               ans+=s.pop();
               diff=Math.abs(diff);
               while(diff-->0)
                   ans+='(';
          }
          else
               ans+=s.pop();
      }
     
      s.push(z);
   }
   if(!s.isEmpty())
       {
           int x=s.pop();
           ans+=x;
           while(x-->0)
               ans+=')';
       }
  System.out.println(ans);
}
}