import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution
{

    public static void main(String[] args)throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z = 1; z <= t; z++)
        {
            String s = br.readLine();
            int n = s.length();
            int check=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==check)
                {
                    sb.append(s.charAt(i));
                }
                else if(val>check)
                {
                    int diff = val-check;
                    sb.append(OpenBraces(diff)).append(s.charAt(i));
                    check = check+diff;
                }
                 else
                {
                    int diff = check-val;
                    sb.append(CloseBraces(diff)).append(s.charAt(i));
                    check=check-diff;
                }
            }
            if(check>0) 
            {
                sb.append(CloseBraces(check));
            }
            System.out.println("Case #"+z+": "+sb.toString());

        }
        System.exit(0);
    }

    public static String OpenBraces(int n)
    {
         String str="";
         for(int i=0;i<n;i++)
         {
            str=str+"(";
         }
         return str;
    }
    public static String CloseBraces(int n)
    {
          String str="";
         for(int i=0;i<n;i++)
         {
            str=str+")";
         }
         return str;
    }


}