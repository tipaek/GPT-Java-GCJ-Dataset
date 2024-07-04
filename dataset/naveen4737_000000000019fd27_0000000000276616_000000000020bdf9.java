import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,i,cou,i1,j;
        t=sc.nextInt();
        int n[] = new int[t];
        String s[] = new String[t];
        for(i=0;i<t;i++)
        {
            n[i] = sc.nextInt();
            int time[][] = new int[n[i]][2];
            for(j=0;j<n[i];j++)
            {
                time[j][0]=sc.nextInt();
                time[j][1]=sc.nextInt();
            }
            int d[] = new int[n[i]];
            d[0]=1;
            boolean possible = true;
            for(i1=1;i1<n[i];i1++)
            {
                boolean one=true, two=true;
                for(j=0;j<i1;j++)
                {
                    if(((time[j][0]<=time[i1][0]&&time[i1][0]<time[j][1])||(time[j][0]<time[i1][1]&&time[i1][1]<=time[j][1])))
                    {
                        if(d[j]==1)
                            one = false;
                        if(d[j]==2)
                            two = false;
                    }
                }
                if(one == true)
                {
                    d[i1]=1;
                }
                else if(two == true)
                {
                    d[i1]=2;
                }
                else
                    possible = false;
            }
            s[i]="";
            if(possible)
            {
                for(j=0;j<n[i];j++)
                {
                    if(d[j]==1)
                        s[i]=s[i]+"C";
                    else if(d[j]==2)
                        s[i]=s[i]+"J";
                }
            }
            else
                s[i] = "IMPOSSIBLE";
        }
        for(i=0;i<t;i++)
            System.out.println("Case #"+(i+1)+": "+s[i]);
    }
}