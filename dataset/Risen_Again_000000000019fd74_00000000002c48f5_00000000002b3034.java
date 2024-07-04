import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++)
        {
            int n = sc.nextInt();
            String[] p = new String[n];
            for(int i = 0;i < n;i++)
            {
                p[i] = sc.next().replaceAll("(\\*)\\1+","$1");
            }

            StringBuilder sb = new StringBuilder();

            String r = p[0];

            for(int i = 1;i < n;i++)
            {
                boolean[][] grid = new boolean[r.length()][p[i].length()];

                for(int j = 0;j < r.length();j++)
                {
                    for(int k = 0;k < p[i].length();k++)
                    {
                        if(r.charAt(j) == '*' || p[i].charAt(k) == '*' || r.charAt(j) == p[i].charAt(k))
                        {
                            grid[j][k] = true;
                        }
                    }
                }

                if(DFS(grid, r, p[i], sb, r.length(), p[i].length(), 0, 0, 0))
                {
                    r = sb.toString();
                    sb.setLength(0);
                }
                else
                {
                    System.out.println(r + " " + p[i]);
                    r = "*";
                    break;
                }
            }

            if(r == "*")
            {
                System.out.println("Case #" + t + ":" + r);
            }
            else
            {
                System.out.println("Case #" + t + ":" + r.replaceAll("^\\*+", "").replaceAll("\\*+$", "").replace('*', 'X'));
            }
        }
    }

    /**
     * 
     * @param grid
     * @param a
     * @param b
     * @param sb
     * @param r
     * @param c
     * @param x
     * @param y
     * @param lastMove 0 - diagonal, 1 - down, 2 - right
     * @return
     */
    public static boolean DFS(boolean grid[][], String a, String b, StringBuilder sb, int r, int c, int x, int y, int lastMove)
    {
        System.out.println(x + " " + y);
        if(x == r-1 && y != c-1)
        {
            return false;
        }

        if(x != r-1 && y == c-1)
        {
            return false;
        }
    
        if(a.charAt(x) == '*')
        {
            sb.append(b.charAt(y));
        }
        else
        {
            sb.append(a.charAt(x));
        }

        if(x == r-1 && y == c-1)
        {
            return true;
        }

        if(a.charAt(x+1) == '*' && b.charAt(y+1) == '*')
        {
            StringBuilder nsb = new StringBuilder();
            if(DFS(grid, a, b, nsb, r, c, x+1, y+1, 0))
            {
                sb.append(nsb);
                return true;
            }
        }
        else
        {
            if(grid[x+1][y+1])
            {
                StringBuilder nsb = new StringBuilder();
                if(DFS(grid, a, b, nsb, r, c, x+1, y+1, 0))
                {
                    sb.append(nsb);
                    return true;
                }
            }

            if(grid[x][y+1] && (lastMove != 1) && a.charAt(x) == '*')
            {
                StringBuilder nsb = new StringBuilder();
                if(DFS(grid, a, b, nsb, r, c, x, y+1, 2))
                {
                    sb.append(nsb);
                    return true;
                }
            }

            if(grid[x+1][y] && (lastMove != 2) && b.charAt(y) == '*')
            {
                StringBuilder nsb = new StringBuilder();
                if(DFS(grid, a, b, nsb, r, c, x+1, y, 1))
                {
                    sb.append(nsb);
                    return true;
                }
            }           
        }
        return false;
    }
}