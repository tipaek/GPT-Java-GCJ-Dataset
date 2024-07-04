import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t1=sc.nextInt();
        for(int z=1;z<=t1;z++)
        {
            String s=sc.next();
            int t=0;
            for(int i=0;i<s.length();i++)
            {
                int a=s.charAt(i)-48;
                if(a>t)
                for(int j=t;j<a;j++,t++,i++)
                s=s.substring(0,i)+"("+s.substring(i);
                else if(a<t)
                {
                 int g=t; 
                 for(int j=a;j<g;j++,t--,i++)
                 s=s.substring(0,i)+")"+s.substring(i);
                }
            }
            while(t>0)
            {
                s+=')';
                t--;
            }
            System.out.println("Case #"+z+": "+s);
        }
    }
}