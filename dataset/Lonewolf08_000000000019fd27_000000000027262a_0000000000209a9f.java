import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{

    public static void main(String[] args) 
    {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0;t<T;t++)
        {
            String s = in.nextLine();
            int n = s.length();
            int brac=0;
            String ns = "";
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==brac)
                {
                    ns += s.charAt(i);
                }
                else if(val>brac)
                {
                    int diff = val-brac;
                    ns = ns + open(diff) + s.charAt(i);
                    brac = brac+diff;
                }
                else
                {
                    int diff = brac-val;
                    ns = ns + close(diff) + s.charAt(i);
                    brac=brac-diff;
                }
            }
            if(brac>0) 
            {
                ns += close(brac);
            }
            System.out.println(ns);

        }
    }

    public static String open(int num)
    {
         return String.join("", Collections.nCopies(num, "("));
    }
    public static String close(int num)
    {
         return String.join("", Collections.nCopies(num, ")"));
    }


}