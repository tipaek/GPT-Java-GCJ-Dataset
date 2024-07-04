import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            String s=sc.next();
            String s1="";
            int count=0;
            for(int j=0;j<s.length();j++)
            {
                int val=s.charAt(j)-48;
                if(val==count)
                    s1+=s.charAt(j);
                else if(val>count)
                {
                    int temp=val-count;
                    for(int k=0;k<temp;k++)
                    {
                        s1 += '(';
                        count++;
                    }
                    s1+=s.charAt(j);
                }
                else
                {
                    int temp=count-val;
                    for(int k=0;k<temp;k++)
                    {
                        s1 += ')';
                        count--;
                    }
                    s1+=s.charAt(j);
                }
                //System.out.println(s1+" "+count+" "+val);
            }
            while(count--!=0)
                s1+=')';
            System.out.println("Case #"+i+": "+s1);
        }
    }
}