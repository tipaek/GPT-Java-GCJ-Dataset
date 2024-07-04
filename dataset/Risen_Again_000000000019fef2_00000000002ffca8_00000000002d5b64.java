import java.util.*;

class Solution
{
    static class Pair
    {
        int a;
        int b;

        Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T;t++)
        {
            int r = sc.nextInt();
            int R = r;
            int s = sc.nextInt();
            int h = r*s;
            LinkedList<Pair> l = new LinkedList<Pair>();

            for(int j = 0;j < R-1;j++)
            {
                for(int i = 0;i < s-1; i++)
                {
                    int b = r-1;
                    int a = h-r;
                    h--;
                    l.add(new Pair(a,b));
                }
                r--;
                h--;
            }
            System.out.println("Case #" + t + ": " + l.size());
            for(Pair p : l)
            {
                System.out.println(p.a + " " + p.b);
            }
        }
    }
}