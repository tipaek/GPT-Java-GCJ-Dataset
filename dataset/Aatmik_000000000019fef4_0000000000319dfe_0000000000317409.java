import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++)
        {
            int x=sc.nextInt(), y = sc.nextInt();
            String str = sc.next();
            int len=str.length(), walk=0;
            boolean possible=false;
            for(int j=0; j<len; j++)
            {
                if(Math.abs(x)+Math.abs(y)<=walk)
                {
                    System.out.println("Case #"+i+": "+walk);
                    possible = true;
                    break;
                }
                walk++;
                char c = str.charAt(j);
                switch(c)
                {
                    case 'S': y--;
                    break;
                    case 'N': y++;
                    break;
                    case 'W': x--;
                    break;
                    case 'E': x++;
                    break;
                }
            }
            if(!possible && Math.abs(x)+Math.abs(y)<=walk)
            {
                System.out.println("Case #"+i+": "+walk);
                possible = true;
            }
            else if(!possible)
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}