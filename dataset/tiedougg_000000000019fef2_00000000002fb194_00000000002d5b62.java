import java.util.*;
import java.io.*;

public class Solution{

    private static int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static char[] dirsName = {'N', 'E', 'S', 'W'};
    public static void main(String []args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            //String line = in.next();
            System.out.println("Case #" + i + ": " + solve(x, y));
        }
    }
    
    private static String solve(int x, int y)
    {
        if(x%2 == 1 && y%2 == 1)
            return "IMPOSSIBLE";
        if(x%2 == 0 && y%2 == 0)
            return "IMPOSSIBLE";
        int n = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0|0| ");
        Set<String> set = new HashSet<>();
        set.add("0|0");
        StringBuilder sb = new StringBuilder();
        while(q.size()>0)
        {
            int size = q.size();
            int step = (int)Math.pow(2, n++);
            for(int i = 0; i<size; i++)
            {
                String tmp = q.poll();
                String[] tmps = tmp.split("\\|");
                int curX = Integer.parseInt(tmps[0]);
                int curY = Integer.parseInt(tmps[1]);
                String curPath = tmps[2];
                if(curX == x && curY == y)
                    return curPath.trim();
                for(int k = 0; k<4; k++)
                {
                    if(n == 0)
                    {
                        if(x%2==1)
                        {
                            if(!(k == 1 || k == 3))
                                continue;
                        }
                        else
                        {
                            if(!(k == 2 || k == 0))
                                continue;
                        }
                    }
                    int nextX = curX + dirs[k][0]*step;
                    int nextY = curY + dirs[k][1]*step;


                    
                    String nextPath = curPath + dirsName[k];
                    
                    sb.append(nextX).append("|").append(nextY);
                    String next = sb.toString();
                    if(!set.contains(next))
                    {
                        sb.append("|").append(curPath).append(dirsName[k]);
                        q.offer(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
        }
        return "IMPOSSIBLE";
    }
}