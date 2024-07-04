import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=0,i=0,t1=1;
        t=in.nextInt();
        in.nextLine();
        for(i=0;i<t;i++)
        {
            String s="",st="";
            int n=0,k=0,r=0,a=0,b=0,l=0,flag=0,k1=0;
            s=in.nextLine();
            while(k<s.length())
            {
                char c=s.charAt(k);
                st="";
                if(c!=' ')
                {
                    while(k<s.length() && c!=' ')
                    {
                        st=st+c;
                        k++;
                        if(k<s.length())
                        {
                            c=s.charAt(k);
                        }
                    }
                }
                if(flag==0)
                {
                    n=Integer.parseInt(st);
                    flag=1;
                }
                else
                {
                    r=Integer.parseInt(st);
                }
                k++;
            }
            int m[][]=new int[n][n];
            k=0;
            if(r%n==0)
            {
                k1=r/n;
                while(a<n)
                {
                    m[a][b]=k1;
                    b++;
                    a++;
                }
                for(a=0;a<n;a++)
                {
                    l=1;
                    for(b=0;b<n;b++)
                    {
                        if(b<a)
                        {
                            if(k1-(a-b)>0)
                            {
                                m[a][b]=k1-(a-b);
                            }
                            if(k1-(a-b)==0)
                            {
                                m[a][b]=n;
                            }
                            if(k1-(a-b)<0)
                            {
                                m[a][b]=n+(k1-(a-b));
                            }
                        }
                        if(b>a)
                        {
                            if(k1+l<=n)
                            {
                                m[a][b]=k1+l;
                            }
                            else
                            {
                                m[a][b]=-(n-(k1+l));
                            }
                            l++;
                        }
                    }
                }
                System.out.println("Case #"+t1+": POSSIBLE");
                for(a=0;a<n;a++)
                {
                    if(a>0)
                    {
                    System.out.println();
                    }
                    for(b=0;b<n;b++)
                    {
                        System.out.print(m[a][b]+" ");
                    }
                }
                System.out.println();
            }
            else
            {
                System.out.println("Case #"+t1+": IMPOSSIBLE");
            }
            t1++;
        }
    }
}