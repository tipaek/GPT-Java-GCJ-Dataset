import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine()),v;
        StringBuilder sb=new StringBuilder();
        for(v=1;v<=t;v++)
        {
            String s[]=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0]),y=Integer.parseInt(s[1]);
            if(x%2==y%2) {sb.append("Case #"+v+": IMPOSSIBLE\n"); continue;}
            int a=Math.abs(x),b=Math.abs(y),i,n;
            char s1[]=new char[34];
            for(i=0;i<33;i++)
                s1[i]=' ';
            long sum=0l+a+b,val=1,sum2=0;
            for(i=0;i<34;i++)
            {
                sum2+=val;
                if(sum2>=sum) break;
                val*=2;
            }
            if(sum2==sum)
            {
                char ch1='E',ch2='N';
                if(x<0) ch1='W';
                if(y<0) ch2='S';
                n=a; i=0;
                while(n!=0)
                {
                    int temp=n&1;
                    if(temp==1) s1[i]=ch1;
                    n>>=1;
                    i++;
                }
                n=b; i=0;
                while(n!=0)
                {
                    int temp=n&1;
                    if(temp==1) s1[i]=ch2;
                    n>>=1;
                    i++;
                }
                String st="";
                for(i=0;i<34;i++)
                    if(s1[i]!=' ') st+=s1[i];
                 sb.append("Case #"+v+": "+st+"\n"); continue;
            }
            else
            {
                if(a%2==1) a+=2;
                else b+=2;
                sum2=0; sum=0l+a+b; val=1;
                for(i=0;i<34;i++)
                {
                    sum2+=val;
                    if(sum2>=sum) break;
                    val*=2;
                }
                if(sum!=sum2) {sb.append("Case #"+v+": IMPOSSIBLE\n"); continue;}
                String st=""; char ch1='E',ch2='N';
                if(a%2==1)
                {
                    if(x<0) st+="E";
                    else st+="W";
                    a--;
                }
                else
                {
                    if(y<0) st+="N";
                    else st+="S";
                    b--;
                }
                if(x<0) ch1='W';
                if(y<0) ch2='S';
                n=a; i=0;
                while(n!=0)
                {
                    int temp=n&1;
                    if(temp==1) s1[i]=ch1;
                    n>>=1;
                    i++;
                }
                n=b;i=0;
                while(n!=0)
                {
                    int temp=n&1;
                    if(temp==1) s1[i]=ch2;
                    n>>=1;
                    i++;
                }
                for(i=0;i<34;i++)
                    if(s1[i]!=' ') st+=s1[i];
                sb.append("Case #"+v+": "+st+"\n");
            }
        }
        System.out.print(sb);
    }
}
