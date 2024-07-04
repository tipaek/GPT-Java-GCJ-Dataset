import java.io.*;
import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T,N,i,impflag=0,p,c,d,flag,q,a[][],jslot[][],cslot[][]; String s="";
        T=in.nextInt();
        for(int x=1;x<=T;x++)
        {
            N=in.nextInt();
            a=new int[N][2];
            for(i=0;i<N;i++)
            {
                a[i][0]=in.nextInt();
                a[i][1]=in.nextInt();
            }
            jslot=new int[N][2];
            cslot=new int[N][2];
            jslot[0][0]=a[0][0];
            jslot[0][1]=a[0][1];
            p=1;q=1;s="C";
            for(i=1;i<N;i++)
            {
                flag=0;impflag=0;
                for(c=0;c<p;c++)
                {
                    if(jslot[c][0]<a[i][1]&&a[i][0]<jslot[c][1])
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    jslot[p][0]=a[i][0];
                    jslot[p][1]=a[i][1];
                    p++;s=s+'C';
                }
                else
                {
                    flag=0;
                    if(cslot[0][1]==0)
                    {
                        cslot[0][0]=a[i][0];
                        cslot[0][1]=a[i][1];
                        s=s+'J';
                    }
                    else
                    {
                        for(d=0;d<q;d++)
                        {
                            if(cslot[d][0]<a[i][1]&&a[i][0]<cslot[d][1])
                            {
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0)
                        {
                            cslot[q][0]=a[i][0];
                            cslot[q][1]=a[i][1];
                            q++;s=s+'J';
                        }
                        else
                        {
                            System.out.println("Case #"+x+": IMPOSSIBLE");
                            impflag=1;
                            break;
                        }
                    }
                }
            }
            if(impflag==0)
                System.out.println("Case #"+x+": "+s);
        }
        in.close();
    }
}