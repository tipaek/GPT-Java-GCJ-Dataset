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
            String check = "IMPOSSIBLE";
            if(k%n==0)
            {
                check = "POSSIBLE";
            }
            System.out.println("Case #"+i+": "+check);
        }
    }
}