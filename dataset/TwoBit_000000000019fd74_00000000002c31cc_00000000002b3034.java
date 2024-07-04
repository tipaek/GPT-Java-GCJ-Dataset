
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Solution 
{   
    static class StringSort implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            return b.length() - a.length();
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(input.readLine());
       
       for(int currCase = 1; currCase <= T; currCase++)
       {
           int N = Integer.parseInt(input.readLine());
           String[] strings = new String[N];
           
           for(int i = 0; i < N; i++)
           {
               strings[i] = input.readLine();
           }
           
           Arrays.sort(strings, new StringSort());
           
           boolean good = true;
           
           for(int i = 1; i < N; i++)
           {
               if(!strings[0].substring(1).contains(strings[i].substring(1)))
               {
                   good = false;
                   break;
               }
           }
           
           if(good)
               System.out.println("Case #" + currCase + ": " + strings[0].substring(1));
           else
               System.out.println("Case #" + currCase + ": *");
       }
    }
}
