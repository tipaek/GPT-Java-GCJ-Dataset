import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=0,i=0,t1=1;
        t=in.nextInt();
        in.nextLine();
        String ans[]=new String[t];
        for(i=0;i<t;i++)
        {
            String s="",st="";
            int k=0,d=0,e=0,f=0,g=0,par=0;
            char c=' ',c1=' ';
            s=in.nextLine();
            while(k<s.length())
            {
                c=s.charAt(k);
                c1=' ';
                if((k+1)<s.length())
                {
                    c1=s.charAt(k+1);
                    e=Integer.parseInt(String.valueOf(c1));
                }
                d=Integer.parseInt(String.valueOf(c));
                if(par==0)
                {
                    while(par<d)
                    {
                        st=st+"(";
                        par++;
                    }
                }
                if(c1!=' ')
                {
                    f=d-e;
                    st=st+c;
                    g=0;
                    if(f>0)
                    {
                        while(g<f)
                        {
                            st=st+")";
                            g++;
                            par=par-1;
                        }
                    }
                    if(f<0)
                    {
                        while(g>f)
                        {
                            st=st+"(";
                            g=g-1;
                            par=par+1;
                        }
                    }
                }
                else
                {
                    st=st+c;
                    while(par>0)
                    {
                        st=st+")";
                        par=par-1;
                    }
                }
                k++;
            }
            ans[i]=st;
        }
        for(i=0;i<t;i++)
        {
            System.out.println("Case #"+t1+": "+ans[i]);
            t1++;
        }
    }
}