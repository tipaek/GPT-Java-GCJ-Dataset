import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        while(t-->0)
        {
            c++;
        String s[]=sc.next().split("");
        String p="";
        int max=0;
        for(int i=0;i<s.length;i++)
        {
            int a=Integer.parseInt(s[i]);
            if(max<a)
            {
                int b=a-max;
				
				System.out.println(b);
                while(b-->0)
                {
                    p=p+"(";
                }
                p=p+s[i];
				max=a;
            }else if(max>a)
            {
                int b=max-a;
                while(b-->0)
                {
                    p=p+")";
                }
                p=p+s[i];
				max=a;
            }
            else
            {
                int b=max;
                while(b-->0)
                {
                    p=p+")";
                }
                b=max;
                while(b-->0)
                {
                    p=p+"(";
                }
                p=p+s[i];
            }
        }
		while(max-->0)
		{
			p=p+")";
		}
        System.out.println("Case #"+c+": "+p);
    }
    }
}