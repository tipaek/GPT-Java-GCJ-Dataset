import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            String s=in.next();
            int[] a=new int[s.length()];
            for(int i=0;i<s.length();i++)
                a[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
            StringBuilder ans=new StringBuilder("");
            int curr=0;
            for(int i=0;i<s.length();i++)
            {
                if(curr<a[i])
                {
                    for(int j=0;j<a[i]-curr;j++)
                        ans.append("(");
                    curr=a[i];
                }
                else if(curr>a[i])
                {
                    for(int j=0;j<curr-a[i];j++)
                        ans.append(")");
                    curr=a[i];
                }
                ans.append(Integer.toString(a[i]));
            }
            for(int i=0;i<curr;i++)
                ans.append(")");
            System.out.println(ans.toString());
        }
    }

}
