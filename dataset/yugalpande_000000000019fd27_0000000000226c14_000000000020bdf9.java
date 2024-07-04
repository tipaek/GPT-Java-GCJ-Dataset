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
            String s="",st="",eng="";
            int n=0,no=0,k=0,x=0,flag=0;
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
            for(x=0;x<n-1;x++)
            {
                k=x+1;
                while(k<n)
                {
                    if(str[x]>str[k])
                    {
                        no=str[x];
                        str[x]=str[k];
                        str[k]=no;
                        no=end[x];
                        end[x]=end[k];
                        end[k]=no;
                    }
                    k++;
                }
            }
                        
            x=0;
            st="J";
            int jams=str[x];
            int jame=end[x];
            int cams=-1;
            int came=-1;
            x=1;
            eng="J";
            no=1;
            while(x<n)
            {
                if(str[x]<jame && str[x]>=came)
                {
                    eng="C";
                    st=st+eng;
                    cams=str[x];
                    came=end[x];
                }
                else if(str[x]>=jame)
                {
                    eng="J";
                    st=st+eng;
                    jams=str[x];
                    jame=end[x];
                }
                else if(str[x]<came && str[x]>=jame)
                {
                    eng="J";
                    st=st+eng;
                    jams=str[x];
                    jame=end[x];
                }
                else if(str[x]>=came)
                {
                    eng="C";
                    st=st+eng;
                    cams=str[x];
                    came=end[x];
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