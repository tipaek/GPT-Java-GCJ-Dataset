import java.util.*;
public class Solution
{
    public static char opposite(char c)
    {
        if (c=='C')
        return 'J';
        else 
        return 'C';
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for (int lo=1;lo<=t;lo++)
        {
            int N=in.nextInt();
            int s[]=new int[N];
            int e[]=new int[N];
            char ans[]=new char[N];
            int f=0;
            String R="C";
            for (int i=0;i<N;i++)
            {
                int st=in.nextInt();
                int end=in.nextInt();
                if (st<end)
                {
                    s[i]=st;
                    e[i]=end;
                }
            }
            ans[0]='C';
            for (int i=0;i<N-1;i++)
            {
                if (e[i]<=s[i+1])
                {ans[i+1]=ans[i];R+=ans[i];}
                else
                {
                    int liC=R.lastIndexOf(opposite(ans[i]));
                    int liJ=R.lastIndexOf(ans[i]);
                    if (liC!=-1)
                    {
                        if ((s[liC]>=e[i+1])||(e[liC]<s[i+1]))
                        {ans[i+1]='C';}
                        else if (liJ!=-1)
                        {
                            if ((s[liJ]>=e[i+1])||(e[liJ]<s[i+1]))
                            ans[i+1]='J';
                            else
                            {
                                f=1;
                                break;
                            }
                        }
                        else
                        {
                            f=1;
                            break;
                        }
                    }
                    else
                    ans[i+1]=opposite(ans[i]);
                }
            }
            if (f==1)
            System.out.println("IMPOSSIBLE");
            else
            {
                for (char c: ans)
                System.out.print(c);
                System.out.println();
            }
        }
    }
}    