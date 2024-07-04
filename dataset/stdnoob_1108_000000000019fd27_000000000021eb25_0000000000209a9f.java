import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Stack;
import java.util.Arrays;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out); 
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++)
        {
            //int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            int len=s.length();
            int a[]=new int[len+1];
            for(int i=1;i<=len;i++)
                a[i]=Integer.parseInt(Character.toString(s.charAt(i-1)));
            StringBuffer ans=new StringBuffer("");
            for(int i=1;i<=a[1];i++)
                ans.append('(');
            ans.append(a[1]);
            for(int i=2;i<=len;i++)
            {
                if(a[i]>a[i-1])
                {
                    int dif=a[i]-a[i-1];
                    for(int j=1;j<=dif;j++)
                        ans.append('(');
                    ans.append(a[i]);
                }
                else if(a[i]<a[i-1])
                {
                    int dif1=a[i-1]-a[i];
                    for(int j=1;j<=dif1;j++)
                        ans.append(')');
                    ans.append(a[i]);
                }
                else
                    ans.append(a[i]);
            }
            for(int i=1;i<=a[len];i++)
                ans.append(')');
            pw.println("Case #"+tc+": "+ans);
        }
        pw.flush();
    }
}

