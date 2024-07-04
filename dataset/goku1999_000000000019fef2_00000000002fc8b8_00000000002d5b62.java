import java.util.*;
import java.io.*;
public class Solution 
{
    public static void main(String[] args) 
    {
        int ar[]=new int[62];
        ar[31]=1;
        for(int x=32;x<62;x++)
        {
            ar[x]=ar[x-1]*2;
        }
        for(int x=0;x<31;x++)
        {
            ar[x]=-ar[61-x];
        }
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) 
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int d=Math.abs(x)+Math.abs(y);
            if(d%2==0)
            {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
            else
            {
                int x1=x,y1=y;
                x=Math.abs(x);
                y=Math.abs(y);
                String s="";
                if(y==4)
                {
                    if(x==3)
                    {
                        s="EEN";
                    }
                    else if(x==1)
                    {
                        s="WEN";
                    }
                }
                else if(y==3)
                {
                    if(x==4)
                    {
                        s="NNE";
                    }
                    else if(x==2)
                    {
                        s="SEN";
                    }
                    else if(x==0)
                    {
                        s="NN";
                    }
                }
                else if(y==2)
                {
                    if(x==3)
                    {
                        s="WNE";
                    }
                    else if(x==1)
                    {
                        s="EN";
                    }
                }
                else if(y==1)
                {
                    if(x==4)
                    {
                        s="SNE";
                    }
                    else if(x==2)
                    {
                        s="NE";
                    }
                    else if(x==0)
                    {
                        s="N";
                    }
                }
                else if(y==0)
                {
                    if(x==1)
                    {
                        s="E";
                    }
                    else if(x==3)
                    {
                        s="EE";
                    }
                }
                String ans="";
                if(x!=x1&&y!=y1)
                {
                    for(int j=0;j<s.length();j++)
                    {
                        char ch=s.charAt(j);
                        if(ch=='E')
                        {
                            ans=ans+'W';
                        }
                        else if(ch=='W')
                        {
                            ans=ans+'E';
                        }
                        else if(ch=='N')
                        {
                            ans=ans+'S';
                        }
                        else
                        {
                            ans=ans+'N';
                        }
                    }
                }
                else if(x!=x1)
                {
                    for(int j=0;j<s.length();j++)
                    {
                        char ch=s.charAt(j);
                        if(ch=='E')
                        {
                            ans=ans+'W';
                        }
                        else if(ch=='W')
                        {
                            ans=ans+'E';
                        }
                        else
                        {
                            ans=ans+ch;
                        }
                    }
                }
                else if(y!=y1)
                {
                    for(int j=0;j<s.length();j++)
                    {
                        char ch=s.charAt(j);
                        if(ch=='N')
                        {
                            ans=ans+'S';
                        }
                        else if(ch=='S')
                        {
                            ans=ans+'N';
                        }
                        else
                        {
                            ans=ans+ch;
                        }
                    }
                }
                else
                {
                    ans=s;
                }
                System.out.println("Case #"+i+": "+ans);
            }
        }
    }
}