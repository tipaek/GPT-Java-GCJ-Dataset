import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int c=1;c<=t;c++)
        {
            String str=sc.next();
            str=str+'0';
            String s="";
            for(int i=0;i<str.length()-1;i++)
            {
                if(i==0)
                {
                    for(int j=0;j<str.charAt(0)-'0';j++)
                        s=s+'(';
                }
                s=s+str.charAt(i);
                int temp=str.charAt(i)-str.charAt(i+1);
                if(temp>0)
                {
                    for(int j=0;j<temp;j++)
                        s=s+')';
                }
                else if(temp<0)
                {
                    for(int j=temp;j<0;j++)
                        s=s+'(';
                }
            }
            System.out.println("Case #"+c+": "+s);
        }
    }
}