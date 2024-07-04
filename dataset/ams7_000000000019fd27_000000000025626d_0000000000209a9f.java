import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String s=sc.next();
            String res="";
            int k=0;
            int flag=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='1')
                {
                    flag=1;
                    if(k==0)
                    {
                        res=res+'(';
                        k++;
                    }
                    res=res+'1';
                    if(j==s.length()-1)
                    {
                        res=res+')';
                    }
                }
                else
                {
                    if(flag==1)
                    {
                        res=res+')';
                    }
                    res=res+'0';
                    k=0;
                    flag=0;
                }
            }
            System.out.println("Case #"+(i+1)+": "+res);
        }

    }
}
