import java.io.*;
import java.util.*;
import java.lang.*;
class codeJam
{
public static void main(String args[])
{
    int t,n,j,k,a,i,count;
    Scanner scan=new Scanner(System.in);
    try
    {
        t=scan.nextInt();
        for(int u=1;u<=t;u++)
        {   
            count=0;
            n=scan.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            String res[]=new String[n];
            i=0;
            for(i=0;i<n;i++)
            {
                s[i]=scan.nextInt();
                e[i]=scan.nextInt();
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<(n-1);j++)
                {
                    for(k=j+1;k<n;k++)
                    {
                        if (e[j]>e[k])
                        {
                            if (res[j]=="J")
                            {
                                if (res[k]=="J")
                                {
                                    count=90;
                                }
                                else
                                {
                                    res[k]="C";
                                }
                            }
                            else if(res[j]=="C")
                            {
                                if(res[k]=="C")
                                {
                                    count=90;
                                }
                                else
                                {
                                    res[k]="J";
                                }
                            }
                            else if (res[j]==null)
                            {
                                if(res[k]=="J")
                                {
                                    res[j]="C";
                                }
                                else
                                {
                                    res[j]="J";
                                }
                            }
                        }
                        else if (e[j]>s[k])
                        {
                            if (res[j]=="J")
                            {
                                if (res[k]=="J")
                                {
                                    count=90;
                                }
                                else
                                {
                                    res[k]="C";
                                }
                            }
                            else if(res[j]=="C")
                            {
                                if(res[k]=="C")
                                {
                                    count=90;
                                }
                                else
                                {
                                    res[k]="J";
                                }
                            }
                            else if (res[j]==null)
                            {
                                if(res[k]=="J")
                                {
                                    res[j]="C";
                                }
                                else
                                {
                                    res[j]="J";
                                }
                            }
                        }
                    }
                }
            }
            if (count==90)
            {
                System.out.print("case #");
                System.out.print(u);
                System.out.println(": IMPOSSIBLE");
            }
            else
            {
                a=0;
                System.out.print("Case #");
                System.out.print(u);
                System.out.print(": ");
                for(a=0;a<n;a++)                
                {
                    if (res[a]==null)
                    {
                        System.out.print("J");
                    }
                    else
                    {
                        System.out.print(res[a]);
                    }
                }
                System.out.println("");
            }
        }
    }
    catch(Exception z)
    {
        System.out.print("Error");
    }
}
}
