import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();int k=1;
        while(k<=t)
        {
            int a=0;int b=0;
            int y=s.nextInt();
            int x=s.nextInt()*(-1);
            int min=Integer.MAX_VALUE;
            String str=s.next();
            if(a==x&&b==y)
            {
                min=0;
            }
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='N')
                {
                    x--;
                }
                else if(str.charAt(i)=='S')
                {
                    x++;
                }
                else if(str.charAt(i)=='W')
                {
                    y--;
                }
                else
                {
                    y++;
                }
                int temp=Math.abs(a-x)+Math.abs(b-y);
                if(temp<=i+1)
                {
                    min=Math.min(min,i+1);
                }
            }
            
            if(min!=Integer.MAX_VALUE)
            {
                System.out.println("Case #"+k+": "+min);
            }
            else
            {
                System.out.println("Case #"+k+": IMPOSSIBLE");
            }
            k++;
        }
    }
}