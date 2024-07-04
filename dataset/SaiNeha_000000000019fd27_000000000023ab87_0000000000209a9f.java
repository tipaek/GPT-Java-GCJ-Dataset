import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0)
        {
            k++;
            String str=sc.next();
            char[] ch=str.toCharArray();
            int n=str.length();
            String str2=new String();
            StringBuilder sbf = new StringBuilder(str2);
            int f=0,i;
            for(i=0;i<n;i++)
            {
                if(ch[i]!='0')
                {
                    f=1;
                    break;
                }
                sbf.append(ch[i]);
            }
            if(i==n && f==0)
            {
                System.out.println("Case #"+k+": "+sbf);
            }
            else
            {
                sbf.append('(');
                for(;i<n;i++)
                {
                    if(ch[i]=='0')
                    {
                        sbf.append(')');
                        while(i<n && ch[i]=='0')
                        {
                            sbf.append(ch[i]);
                            i++;
                        }
                        if(i<n)
                        {
                            sbf.append('(');
                        }
                    }
                    if(i<n){
                    sbf.append(ch[i]);}
                }
                if(i<=n){
                if(ch[--i]=='1')
                {
                    sbf.append(')');
                }}
                System.out.println("Case #"+k+": "+sbf);
            }
        }
        
    }
}