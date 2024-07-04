import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=0,i=0,t1=1;
        t=in.nextInt();
        String p[]=new String[t];
        for(i=0;i<t;i++)
        {
            String s="",st="";
            int n=0,k=0,x=0,flag=0,flag2=0;
            n=in.nextInt();
            in.nextLine();
            int str[]=new int[n];
            int end[]=new int[n];
            while(x<n)
            {
                s=in.nextLine();
                k=0;
                flag=0;
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
                        str[x]=Integer.parseInt(st);
                        flag=1;
                    }
                    else if(flag==1)
                    {
                        end[x]=Integer.parseInt(st);
                        flag=0;
                    }
                    k++;
                }
                x++;
            }
            st="";
            int jams[]=new int[n];
            int jame[]=new int[n];
            int cams[]=new int[n];
            int came[]=new int[n];
            x=0;
            int h=0,h1=0;
            while(x<n)
            {
                k=0;
                flag=0;
                flag2=0;
                while(k<n)
                {
                    if(str[x]>=jams[k] && str[x]<jame[k])
                    {
                        flag=flag+1;
                    }
                    if(end[x]>jams[k] && end[x]<=jame[k])
                    {
                        flag=flag+1;
                    }
                    if(str[x]<jams[k] && end[x]>jame[k])
                    {
                        flag=flag+1;
                    }
                    if(str[x]>=cams[k] && str[x]<came[k])
                    {
                        flag2=flag2+1;
                    }
                    if(end[x]>cams[k] && end[x]<=came[k])
                    {
                        flag2=flag2+1;
                    }
                    if(str[x]<cams[k] && end[x]>came[k])
                    {
                        flag2=flag2+1;
                    }
                    k++;
                }
                k=0;
                if(flag==0)
                {
                    st=st+"J";
                    jams[k+h]=str[x];
                    jame[k+h]=end[x];
                    h=h+1;
                }
                else if(flag2==0)
                {
                    st=st+"C";
                    cams[k+h1]=str[x];
                    came[k+h1]=end[x];
                    h1=h1+1;
                }
                x++;
            }
            if(st.length()==n)
            {
                p[i]=st;
            }
            else
            {
                p[i]="IMPOSSIBLE";
            }
        }
        for(i=0;i<t;i++)
        {
            System.out.println("Case #"+t1+": "+p[i]);
            t1++;
        }
    }
}