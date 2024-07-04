import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args)throws Exception{
    
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
      int n=Integer.parseInt(br.readLine());
      
      for(int g=1;g<=n;g++)
      {
          String s=br.readLine();
          
          int open=0;
          
          String ans="";
          
          for(int i=0;i<s.length();i++)
           {
               int x=s.charAt(i)-'0';
               
               if(x>open)
               {
                   int diff=x-open;
                   
                   for(int j=0;j<diff;j++)
                     ans=ans+"(";
                     
                     open+=diff;
                   
                   
               }
               
               else if(x<open)
               {
                  int diff=open-x;
                   
                   for(int j=0;j<diff;j++)
                     ans=ans+")";
                     
                     open-=diff;
               }
               
               ans=ans+x;
               
               
           }
           
           for(int j=0;j<open;j++)
             ans=ans+")";
           
           System.out.println("Case #"+g+": "+ans);
      }
        
        
    }
}