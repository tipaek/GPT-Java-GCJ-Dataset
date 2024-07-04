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
            int n=Integer.parseInt(br.readLine());
            int st[]=new int[100000];
            int et[]=new int[100000];
            
            for(int i=1;i<=n;i++)
            {
                String s1[]=(br.readLine()).split(" ");
                st[i]=Integer.parseInt(s1[0]);
                et[i]=Integer.parseInt(s1[1]);
            }
            int hold[]=new int[n+1];
            for(int i=1;i<=n;i++)
                hold[i]=i;
            for(int j=1;j<n;j++)
            {
                for(int i=1;i<n-1;i++)
                {
                    if(st[i]>s[i+1])
                    {
                        int temp=st[i];
                        st[i]=st[i+1];
                        st[i+1]=temp;
                        temp=et[i];
                        et[i]=et[i+1];
                        et[i+1]=temp;
                        temp=hold[i];
                        hold[i]=hold[i+1];
                        hold[i+1]=temp;
                    }
                }
            }
            StringBuffer ans=new StringBuffer("");
            int last=0;
            char c[]=new char[c+1];
            boolean ok=false;
            for(int i=2;i<=n;i++)
            {
                if(st[i]!=st[i-1])
                {
                    if(st[i]>=et[i-1] && last==0)
                        c[i]='C';
                    else if (st[i]>=et[i-1] && last==1)
                        c[i]='J';
                    else if(st[i]<et[i-1])
                    {
                        if(st[i]>=et[i-2] && last==0)
                        {
                            c[i]='J';
                            last=1;
                        }
                        else if(st[i]>=et[i-2] && last==1)
                        {
                            c[i]='C';
                            last=0;
                        }
                        else 
                        {
                            pw.println("Case #"+tc+": IMPOSSIBLE");
                            ok=false;
                            break;
                        }
                    }
                }
                else
                {
                    if(i==1)
                    {
                        c[i]='J';last=1;
                    }
                    else 
                    {
                        if(st[i]>=et[i-2] && last==1)
                        {
                            c[i]='C';
                            last=0;
                        }
                        else if(st[i]>=et[i-2] && last==0)
                        {
                            c[i]='J';
                            last=1;
                        }
                        else
                        {
                            pw.println("Case #"+tc+": IMPOSSIBLE");
                            ok=false;
                            break;
                        }
                    }
                }
            }
            if(ok)
            {
                pw.print("Case #"+tc+": ");
                for(int i=1;i<=n;i++)
                    pw.print(c[hold[i]]);
                pw.println();
            }
        }
        pw.flush();
    }
}

