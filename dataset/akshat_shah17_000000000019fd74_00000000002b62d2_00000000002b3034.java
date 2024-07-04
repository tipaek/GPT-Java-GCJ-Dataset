import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            String[] s=new String[n];
            int max=-1;
            int maxindex=-1;
            for(int j=0;j<n;j++)
            {
                s[j]=sc.next();
                if(max<s[j].length())
                {
                    max = s[j].length();
                    maxindex=j;
                }
            }
            for(int j=0;j<n;j++)
            {
                s[j]=s[j].substring(1);
            }
            String ans= s[maxindex];
            int flag=0;
            for(int j=0;j<n;j++)
            {
                int var=ans.indexOf(s[j]);
                if(var==-1)
                {
                    flag = 1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("Case #"+(i+1)+": "+ans);
            else
                System.out.println("Case #"+(i+1)+": *");
        }
    }
}