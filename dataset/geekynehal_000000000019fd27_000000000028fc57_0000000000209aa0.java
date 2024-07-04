import java.util.*;

class Solution
{
    public static void main(String arr[])
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            boolean flag = false;
            for(int i=1;i<=n;i++)
            {
                if((i*n)==k)
                {
                    flag = true;
                    break;
                }
            }
            int sum = 0;
            if(flag!=true && n>2)
            {
                   for(int i=1;i<=n;i++)
                   {
                       sum+=i;
                   }
                   if(sum == k)
                   {
                       flag = true;
                   }
            }
            if(flag)
            {
                System.out.println("Case #"+i+": "+"POSSIBLE");
            }
            else
            {
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }
        }
    }
}