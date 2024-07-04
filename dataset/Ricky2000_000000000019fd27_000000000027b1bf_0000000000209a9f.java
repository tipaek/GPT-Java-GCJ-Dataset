import java.util.Scanner;
import java.lang.*;

public class Solution
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in); 
      int T= sc.nextInt();
      int x=1;
      int par=0;
      while(x<=T)
      {
          StringBuilder sb = new StringBuilder();
          String S = sc.next();
          char[] ch = new char[S.length()];
           for (int i = 0; i < S.length(); i++) 
           { 
            ch[i] = S.charAt(i); 
           }
          for (int i=0;i<S.length();i++)
          {
              int a = Integer.parseInt(String.valueOf(ch[i]));
              
              while(par<a)
              {
                  sb=sb.append("(");
                  par++;
              }
              
              while(par>a)
              {
                  sb=sb.append(")");
                  par--;
              }
              if(par==a)
              {
                  String S2 = String.valueOf(ch[i]);
                  sb=sb.append(S2);
              }
              if(i==S.length()-1)
              {
                  while(par>0)
                  {
                      sb=sb.append(")");
                      par--;
                  }
              }
          }
          System.out.println("Case #"+(x)+": "+sb.toString());
          x++;
        }
    }
}

                  
          