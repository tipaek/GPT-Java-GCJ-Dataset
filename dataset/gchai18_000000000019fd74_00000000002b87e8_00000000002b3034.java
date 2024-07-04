import java.util.*;
import java.io.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        for (int k=1; k<=t; k++)
        {
            int n = Integer.parseInt(f.readLine());
            HashSet<String> front = new HashSet<String>();
            HashSet<String> middle = new HashSet<String>();
            HashSet<String> end = new HashSet<String>();
            for (int i=0; i<n; i++)
            {
                String str = f.readLine();
                int ind = str.indexOf("*");
                int last = str.lastIndexOf("*");
                if (ind!=0) front.add(str.substring(0, ind));
                if (ind!=last)
                {
                    middle.add(str.substring(ind+1, last));
                }
                if (ind!=str.length()-1) end.add(str.substring(last+1));
            }
            String fr = "";
            boolean b = false;
            for (String str: front)
            {
                int len = fr.length();
                int len2 = str.length();
                if (len<len2)
                {
                    if (str.substring(0, len).equals(fr.substring(0, len)))
                    {
                        fr = str;
                    }
                    else
                    {
                        b = true;
                    }
                }
                else
                {
                    if (str.substring(0, len2).equals(fr.substring(0, len2)))
                    {

                    }
                    else
                    {
                        b = true;
                    }
                }
            }

            String mid = "";
            for (String str: middle)
            {
                int len = str.length();
                for (int i=0; i<len; i++)
                {
                    if (str.charAt(i)!='*')
                    {
                        mid+=str.charAt(i);
                    }
                }
            }

            String en = "";
            for (String str: end)
            {
                int len = en.length();
                int len2 = str.length();
                if (len<len2)
                {
                    if (str.substring(len2-len).equals(en))
                    {
                        en = str;
                    }
                    else
                    {
                        b = true;
                    }
                }
                else
                {
                    if (str.equals(en.substring(len-len2)))
                    {

                    }
                    else
                    {
                        b = true;
                    }
                }
            }
            System.out.print("Case #"+k + ": ");

            String ans = fr+mid+en;

            if (b)
            {
                System.out.println("*");
            }
            else
            {
                System.out.println(ans);
            }




        }
    }
}