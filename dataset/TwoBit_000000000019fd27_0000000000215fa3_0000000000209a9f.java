import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(input.readLine());
       
       for(int currCase = 1; currCase <= T; currCase++)
       {
           String S = input.readLine();
           String result = "";
           int curr = 0;
           
           for(int i = 0; i < S.length(); i++)
           {
               int sub = Integer.parseInt(S.substring(i, i+1));
               
               for(; curr > sub; curr--)
               {
                   result += ")";
               }
               
               for(; curr < sub; curr++)
               {
                   result += "(";
               }
               
               result += S.charAt(i);                           
           }
           
           for(; curr > 0; curr--)
           {
               result += ")";
           }
           
           System.out.println("Case #" + currCase + ": " + result);
       }            
    }
}
