import java.io.*;
import java.util.*;

class Solution
{
    public static void main (String[] args)throws Exception
    {
       BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
       int testcase = Integer.parseInt(buff.readLine());
       for (int test=1; test <=testcase;test+=1)
       {
           String input = buff.readLine();
           StringBuilder sb = new StringBuilder ();
           int currentDepth = 0;
           for (int i =0; i< input.length();i+=1)
           {
               int reqD = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (currentDepth < reqD)
                {
                    while (currentDepth != reqD)
                    {
                        sb.append('(');
                        currentDepth +=1;
                    }                    
                }
                else if (currentDepth > reqD)
                {
                    while (currentDepth != reqD)
                    {
                        sb.append(')');
                        currentDepth -=1;
                    }     
                }
                sb.append (reqD);
           }
                while (currentDepth !=0)
                {
                    sb.append (')');
                    currentDepth -=1;
                }
                System.out.println("Case #"+String.valueOf(test)+": "+ sb.toString ());                
       }        
    }      
}  