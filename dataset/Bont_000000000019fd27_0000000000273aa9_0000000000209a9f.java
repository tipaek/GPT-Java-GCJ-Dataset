

import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); 
    for (int t = 0; t < T; t++) {
       String str = in.next();
       int prev = 0;
       int intmax = (int)str.charAt(0) - 48;
       //System.out.print("intmax="+intmax);
       String result="";
       for(int i=0;i<str.length();i++)
       {
           int h = (int)str.charAt(i) - 48;
          //System.out.print("h="+ h);
           if(h==0)
             {
                 for(int j=0;j<prev;j++)
                 {
                     result = result + ")";
                 }
                 result = result + str.charAt(i);
             }
            else if(h>prev)
            {
                if(h>intmax)
                   {
                       intmax=h;
                       for(int k=0;k<(intmax-prev);k++)
                       {
                           result = result + "(" ;
                       }
                       result =result + str.charAt(i);
                   }
                else if(h<intmax)
                {
                    for(int k=0;k<(h-prev);k++)
                       {
                           result = result + "(" ;
                       }
                       result =result + str.charAt(i);
                    
                }
                else
                {
                  
                   for(int j=0;j<h-prev;j++)
                   {
                     result = result + "(";
                    }
                     //System.out.print("{}"); 
                      result = result + str.charAt(i);
                  
                  
                        
                } 
                    
            }
            else if(h<prev)
            {
              for(int l=0;l<prev-h;l++)
              {
                  result = result + ")";
                  
              }
              result = result + str.charAt(i) ;
            }
            else if(h==prev)
            {
                result = result + str.charAt(i);
            }
            prev = h;
            if(i==str.length()-1)
              {
                  for(int w=0;w<h;w++)
                      result = result + ")";
              }
       }
     
     System.out.println("Case #"+(t+1)+": "+result);
      
    }
  }
}
