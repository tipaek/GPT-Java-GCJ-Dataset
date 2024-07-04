import java.io.*;
import java.util.*;

public class Solution
{
 public static void main(String gg[])
 {
  int t=0,testCases;
  Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  testCases=Integer.parseInt(sc.nextLine());
  t=0;
  while(t<testCases)
  {
   Stack<Character> stack=new Stack<>();
   StringBuffer sb=new StringBuffer();
   String input;
   input=sc.nextLine();
   int i=0,j=0;
   char temp;
   int k=0;
   while(i<input.length())
   {
    temp=input.charAt(i);
    k=Integer.parseInt(String.valueOf(temp));
    while(stack.size()!=k)
    {
     if(stack.size()<k)
     {
      sb.append('(');
      stack.push(')');
     }
     else if(stack.size()>k)
     {
      sb.append(')');
      stack.pop();
     }
    }
    sb.append(temp);
    i++;
   }
   while(!stack.empty())
   {
    sb.append(')');
    stack.pop();
   }
   System.out.println("Case #"+t+": "+sb.toString());
   t++;
  }
 }
}

