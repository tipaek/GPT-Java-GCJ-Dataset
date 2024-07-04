import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args)throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        for(int g=1;g<=t;g++)
        {
            String s=br.readLine();
            
            int open=0;
            
            String ans="";
            for(int i=0;i<s.length();i++)
             {
                 if(s.charAt(i)=='1' && open==0)
                  {
                      ans=ans+"("+(s.charAt(i)-'0');
                      open++;
                  }
                  
                  else if(s.charAt(i)=='0' && open>0)
                  {
                      ans=ans+")"+"0";
                      open--;
                  }
                  
                  else
                   ans=ans+(s.charAt(i)-'0');
             }
             
             if(open==1)
               ans=ans+")";
             
             System.out.println("Case #"+g+": "+ans);
        }
    }
}