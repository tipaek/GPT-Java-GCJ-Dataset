import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int f=1;
        while(t>0)
        {
            t--;
            String s= sc.next();
            int min=10;
            for(int i=0;i<s.length();i++)
            {
                int a=Character.getNumericValue(s.charAt(i));
                if(a<min)
                {
                    min=a;
                }
            }
            String temp="";
            int l=s.length();
            int k=0;
            int m=Character.getNumericValue(s.charAt(0));
            for(int i=0;i<(m-min);i++)
            {
                temp=temp+"(";
            }
            temp=temp+s.charAt(0);
            k++;
            if(k<l)
            {
                int m1=Character.getNumericValue(s.charAt(1));
                if(m>m1)
                {
                    for(int i=0;i<(m-m1);i++)
                    {
                        temp=temp+")";
                    }
                }
                else if(m1>m)
                {
                    for(int i=0;i<(m1-m);i++)
                    {
                        temp=temp+"(";
                    }
                }
            }
            for(int i=1;i<l-1;i++)
            {
                char c=s.charAt(i);
                char c1=s.charAt(i+1);
                int a=Character.getNumericValue(c);
                int a1=Character.getNumericValue(c1);
                if(a1>a)
                {
                    temp=temp+c;
                    for(int j=0;j<(a1-a);j++)
                    {
                        temp=temp+"(";
                    }
                    k++;
                }
                else if(a>a1)
                {
                    temp=temp+c;
                    for(int j=0;j<(a-a1);j++)
                    {
                        temp=temp+")";
                    }
                    k++;
                }
                else
                {
                    temp=temp+c;
                    k++;
                }
            }
            if(k<l)
            {
            temp=temp+s.charAt(l-1);
            m=Character.getNumericValue(s.charAt(l-1));
            }
            for(int i=0;i<(m-min);i++)
            {
                temp=temp+")";
            }
            for(int i=0;i<min;i++)
            {
                temp="("+temp;
                temp=temp+")";
            }
            System.out.println("Case #"+f+": "+temp);
            f++;
        }
    }
}