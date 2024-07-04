import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cs=1;
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            int flag=0;
            String s1=new String();
            String s=sc.nextLine();
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='1'&&flag==0)
                {
                    s1=s1+'(';
                    flag=1;
                    s1=s1+s.charAt(i);
                    if(i==s.length()-1)
                    {
                        s1=s1+')';
                    }
                }
                else if(s.charAt(i)=='1'&&i==s.length()-1)
                {
                    flag=0;
                    s1=s1+s.charAt(i);
                    s1=s1+')';
                }
                else if(s.charAt(i)=='1'&&s.charAt(i+1)=='1')
                {
                    s1=s1+s.charAt(i);
                }
                else if(s.charAt(i)=='1'&&s.charAt(i+1)=='0')
                {
                    s1=s1+s.charAt(i);
                    s1=s1+')';
                    flag=0;
                }
                else if(s.charAt(i)=='0'&&flag==1)
                {
                    s1=s1+')';
                    s1=s1+s.charAt(i);
                    flag=0;
                }
                else if(s.charAt(i)=='0'&&flag==0)
                {
                    s1=s1+s.charAt(i);
                }

            }
            System.out.println("Case #" + cs + ": " + s1);
            cs++;
        }
    }
}
