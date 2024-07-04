import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
		sc.nextLine();
        int pr=1;
        while(t-->0)
        {
            String s1=sc.nextLine();
            s1=s1+"0";
			String s[]=s1.split("");
            String a="";
            int o=0,c=0;
            for(int i=0;i<s.length-1;i++)
            {
                if(Integer.parseInt(s[i])>o)
                {
                    int temp=Integer.parseInt(s[i]);
                    for(int j=0;j<temp-o;j++)
                    {
                        a=a+"(";
                    }
                    o=temp;
                }
                a=a+s[i];
                c=o-Integer.parseInt(s[i+1]);
                if(c>0)
                {
                    for(int j=0;j<c;j++)
                    {
                        a=a+")";
                    }
                    o=o-c;
                }
            }
            System.out.println("Case #"+pr+": "+a);
            pr++;
        }
    }
}