import java.util.*;
import java.io.*;
import java.awt.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(f.readLine());

        for (int k=1; k<=t; k++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());

            PriorityQueue<Point> ord = new PriorityQueue<Point>(11, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.x-o2.x;
                }
            });

            PriorityQueue<Point> lat = new PriorityQueue<Point>(11, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.x-o2.x;
                }
            });

            st = new StringTokenizer(f.readLine());
            for (int i=2; i<=c; i++)
            {
                int x = Integer.parseInt(st.nextToken());
                if (x>0)
                {
                    lat.add(new Point(x, i));
                }
                else
                {
                    ord.add(new Point(-x, i));
                }
            }
            int[][] g = new int[c+1][c+1];
            for (int i=1; i<=d; i++)
            {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g[u][v] = i;
                g[v][u] = i;
            }
            int[] l = new int[c+1];

            int count = 1;
            int index = 0;
            while(count<c)
            {
                HashSet<Integer> s= new HashSet<Integer>();
                while(!ord.isEmpty() && ord.peek().x==count)
                {
                    s.add(ord.remove().y);
                }
                if (s.isEmpty())
                {
                    Point p = lat.remove();
                    l[p.y] = p.x;
                    count++;
                    index = p.x;
                }
                else
                {
                    index++;
                    for (int i: s)
                    {
                        count++;
                        l[i] = index;
                    }
                }
            }
            Queue<Point> q = new LinkedList<Point>();
            boolean[] b = new boolean[c+1];
            int[] ans = new int[d+1];
            for (int i=1; i<=c; i++)
            {
                if (g[1][i]>0)
                {
                    q.add(new Point(1, i));
                }
            }
            b[1] = true;
            while(!q.isEmpty())
            {
                Point p = q.remove();
                ans[g[p.x][p.y]] = Math.abs(l[p.y]-l[p.x]);

                b[p.y] = true;
                for (int i=1; i<=c; i++)
                {
                    if (g[p.y][i]>0 && !b[i])
                    {
                        q.add(new Point(p.y, i));
                    }
                }
            }
            System.out.print("Case #" + k + ":");
            for (int i=1; i<=d; i++)
            {
                if (ans[i]==0) ans[i]=100000;
                System.out.print(" " + ans[i]);
            }
            System.out.println();
        }
    }


}