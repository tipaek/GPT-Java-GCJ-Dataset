import java.util.*;

class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1;t <= T;t++)
        {
            int n = sc.nextInt();

            int[][] m = new int[n][n];

            HashSet<Integer> hs = new HashSet<Integer>();
            int r = 0, c = 0, tr = 0;
            for(int i = 0;i < n;i++)
            {
                boolean row = true;
                for(int j = 0;j < n;j++)
                {
                    m[i][j] = sc.nextInt();
                    if(i == j)
                    {
                        tr += m[i][j];
                    }
                    if(hs.contains(m[i][j]))
                    {
                        row = false;
                    }
                    else
                    {
                        hs.add(m[i][j]);
                    }
                }
                if(!row)
                {
                    r++;
                }
                hs.clear();
            }

            for(int j = 0;j < n;j++)
            {
                boolean col = true;
                for(int i = 0;i < n;i++)
                {
                    if(hs.contains(m[i][j]))
                    {
                        col = false;
                    }
                    else
                    {
                        hs.add(m[i][j]);
                    }
                }
                if(!col)
                {
                    c++;
                }
                hs.clear();
            }

            System.out.println("Case #" + t + ": " + tr + " " + r + " " + c);
        }
    }
}