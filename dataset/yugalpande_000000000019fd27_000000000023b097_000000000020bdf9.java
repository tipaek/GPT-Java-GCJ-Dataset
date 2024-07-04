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
            int n=0,k=0,x=0,flag=0,flag1=0;
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
            int minc=0;
            int minj=0;
            x=0;
            st="";
            int jams=0;
            int jame=0;
            int cams=0;
            int came=0;
            flag=0;
            flag1=0;
            while(x<n)
            {
                if(str[x]<jame && str[x]>=came)
                {
                    st=st+"C";
                    cams=str[x];
                    came=end[x];
                    if(flag==0)
                    {
                        minc=str[x];
                    }
                    if(minc>str[x])
                    {
                        minc=str[x];
                    }
                    flag=flag+1;
                }
                else if(str[x]>=jame)
                {
                    st=st+"J";
                    jams=str[x];
                    jame=end[x];
                    if(flag1==0)
                    {
                        minj=str[x];
                    }
                    if(minj>str[x])
                    {
                        minj=str[x];
                    }
                    flag1=flag1+1;
                }
                else if(str[x]<came && str[x]>=jame)
                {
                    st=st+"J";
                    jams=str[x];
                    jame=end[x];
                    if(flag1==0)
                    {
                        minj=str[x];
                    }
                    if(minj>str[x])
                    {
                        minj=str[x];
                    }
                    flag1=flag1+1;
                }
                else if(str[x]>=came)
                {
                    st=st+"C";
                    cams=str[x];
                    came=end[x];
                    if(flag==0)
                    {
                        minc=str[x];
                    }
                    if(minc>str[x])
                    {
                        minc=str[x];
                    }
                    flag=flag+1;
                }
                else if(str[x]<minj && end[x]<=minj)
                {
                    st=st+"J";
                }
                else if(str[x]<minc && end[x]<=minc)
                {
                    st=st+"C";
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