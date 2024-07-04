import java.util.*;
class Pair
{
    int f;
    int s;
    Pair(int f,int s)
    {
        this.f = f;
        this.s = s;
    }
}
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int T=1;T<=t;T++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            List<Pair> arr = new ArrayList<Pair>();
            for(int i=0;i<s.length();i++)
            {
                char a = s.charAt(i);
                if(a == 'S')
                    y-=1;
                if(a == 'N')
                    y+=1;
                if(a == 'E')
                    x+=1;
                if(a == 'W')
                    x-=1;
                arr.add(new Pair(x,y));
            }
            int flag = 0;
            int ans = 0;
            for(int i=0;i<arr.size();i++)
            {
                int a1 = arr.get(i).f;
                int a2 = arr.get(i).s;
                int c = Math.abs(a1)+Math.abs(a2);
                if(c<=(i+1))
                {
                    flag = 1;
                    ans = Math.max(c,(i+1));
                    break;
                }
            }
            if(flag == 1)
                System.out.println("Case #"+T+": "+ans);
            else
                System.out.println("Case #"+T+": "+"IMPOSSIBLE");
        }
    }
}