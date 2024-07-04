import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
     String s = in.next();
     String news ="";
     int k =0;
     Stack<Character> st= new Stack<Character>();
     for(int j=0;j<s.length();j++)
     {
         char g = s.charAt(j);
         int l = (int)g-48;
         if(k>l)
         {
             while(!st.isEmpty()&&k>l)
             { st.pop();
                 k--;
             news= news+')';
            }
             news= news+g;
             
    }
    else if(k<l)
    {
        
        
        while(k<l)
        {
            st.push('(');
        k++;
        
         news= news+'(';
        }
        news= news+g;
        
        
  }
  else
  {
    news= news+g;   
}

}
while(!st.isEmpty())
             { st.pop();
             news= news+')';
            }
            System.out.println("Case #"+i+":"+news);
}

}
}