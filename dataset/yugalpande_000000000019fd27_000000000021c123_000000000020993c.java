import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=0,i=0,t1=1;
        t=in.nextInt();
        String ans[]=new String[t];
        for(i=0;i<t;i++)
        {
            int n=0,a=0,b=0,c=0,d=0,j=0,k=0,trace=0,repr=0,repc=0,flag=0;
            String s="",st="";
            n=in.nextInt();
            in.nextLine();
            int z[][]=new int[n][n];
            for(a=0;a<n;a++)
            {
                b=0;
                while(b<n)
                {
                    s=in.nextLine();
                    k=0;
                    st="";
                    while(k<s.length())
                    {
                        char c1=s.charAt(k);
                        st="";
                        if(c1!=' ')
                        {
                            while(k<s.length() && c1!=' ')
                            {
                                st=st+c1;
                                k++;
                                if(k<s.length())
                                {
                                    c1=s.charAt(k);
                                }
                            }
                        }
                        d=Integer.parseInt(st);
                        z[a][b]=d;
                        b=b+1;
                        k++;
                    }
                }
            }
            for(a=0;a<n;a++)
            {
                flag=0;
                int rows[]=new int[n];
                for(b=0;b<n;b++)
                {
                    rows[b]=-1;
                }
                b=0;
                while(b<n && flag==0)
                {
                    for(j=0;j<n;j++)
                    {
                        if(rows[j]==z[a][b])
                        {
                            flag=flag+1;
                        }
                    }
                    if(flag==0)
                    {
                        rows[b]=z[a][b];
                        b++;
                    }
                    else
                    {
                        repr=repr+1;
                    }
                }
            }
            for(b=0;b<n;b++)
            {
                flag=0;
                int rows[]=new int[n];
                for(a=0;a<n;a++)
                {
                    rows[a]=-1;
                }
                a=0;
                while(a<n && flag==0) 
                {
                    for(j=0;j<n;j++)
                    {
                        if(rows[j]==z[a][b])
                        {
                            flag=flag+1;
                        }
                    }
                    if(flag==0)
                    {
                        rows[a]=z[a][b];
                        a++;
                    }
                    else
                    {
                        repc=repc+1;
                    }
                }
            }
            a=0;
            b=0;
            while(a<n)
            {
                trace=trace+z[a][b];
                a++;
                b++;
            }
            String s1=Integer.toString(trace);
            String s2=Integer.toString(repr);
            String s3=Integer.toString(repc);
            ans[i]=s1+" "+s2+" "+s3;
        }
        for(i=0;i<t;i++)
        {
        	System.out.println("Case #"+t1+": "+ans[i]);
        	t1++;
        }
    }
}