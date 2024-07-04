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
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long sum = 0;
            TreeSet<Integer>[] tsr = new TreeSet[c];
            TreeSet<Integer>[] tsc = new TreeSet[r];
            int[][] s = new int[r][c];

            for (int i=0; i<c; i++)
            {
                tsr[i] = new TreeSet<Integer>();
            }

            for (int i=0; i<r; i++)
            {
                tsc[i] = new TreeSet<Integer>();
            }

            for (int i=0; i<r; i++)
            {
                st = new StringTokenizer(f.readLine());
                for (int j=0; j<c; j++)
                {
                    s[i][j] = Integer.parseInt(st.nextToken());
                    sum+=s[i][j];
                    tsr[j].add(i);
                    tsc[i].add(j);
                }
            }
            HashSet<Point> set = new HashSet<Point>();

            long ans = 0;
            int[][] p = new int[r][c];
            int[][] num = new int[r][c];
            for (int i=0; i<r; i++)
            {
                for (int j=0; j<c; j++)
                {
                    int count = 0;
                    if (i>0)
                    {
                        p[i-1][j]+=s[i][j];
                        count++;
                    }
                    if (j>0)
                    {
                        p[i][j-1]+=s[i][j];
                        count++;
                    }
                    if (i<(r-1))
                    {
                        p[i+1][j]+=s[i][j];
                        count++;
                    }
                    if (j<(c-1))
                    {
                        p[i][j+1]+=s[i][j];
                        count++;
                    }
                    num[i][j] = count;
                    set.add(new Point(i, j));
                }
            }

            while(!set.isEmpty())
            {
                ans+=sum;
                HashSet<Point> ch = new HashSet<Point>();
                for (Point po: set)
                {
                    if (s[po.x][po.y]*num[po.x][po.y] < p[po.x][po.y])
                    {
                        ch.add(po);
                    }
                }

                set = new HashSet<Point>();
                for (Point po: ch)
                {
                    if (tsr[po.y].lower(po.x)!=null)
                    {
                        int x1 = tsr[po.y].lower(po.x);
                        if (tsr[po.y].higher(po.x)!=null)
                        {
                            int x2 = tsr[po.y].higher(po.x);
                            p[x1][po.y] += (s[x2][po.y]-s[po.x][po.y]);
                            p[x2][po.y] += (s[x1][po.y]-s[po.x][po.y]);
                            set.add(new Point(x1, po.y));
                            set.add(new Point(x2, po.y));
                        }
                        else
                        {
                            p[x1][po.y]-=s[po.x][po.y];
                            num[x1][po.y]--;
                            set.add(new Point(x1, po.y));
                        }
                    }
                    else if (tsr[po.y].higher(po.x)!=null)
                    {
                        int x2 = tsr[po.y].higher(po.x);
                        p[x2][po.y]-=s[po.x][po.y];
                        num[x2][po.y]--;
                        set.add(new Point(x2, po.y));
                    }

                    if (tsc[po.x].lower(po.y)!=null)
                    {
                        int y1 = tsc[po.x].lower(po.y);
                        if (tsc[po.x].higher(po.y)!=null)
                        {
                            int y2 = tsc[po.x].higher(po.y);
                            p[po.x][y1] += (s[po.x][y2]-s[po.x][po.y]);
                            p[po.x][y2] += (s[po.x][y1]-s[po.x][po.y]);
                            set.add(new Point(po.x, y1));
                            set.add(new Point (po.x, y2));
                        }
                        else
                        {
                            p[po.x][y1]-=s[po.x][po.y];
                            num[po.x][y1]--;
                            set.add(new Point(po.x, y1));
                        }
                    }
                    else if (tsc[po.x].higher(po.y)!=null)
                    {
                        int y2 = tsc[po.x].higher(po.y);
                        p[po.x][y2]-=s[po.x][po.y];
                        num[po.x][y2]--;
                        set.add(new Point(po.x, y2));
                    }
                    sum-=s[po.x][po.y];
                    tsc[po.x].remove(po.y);
                    tsr[po.y].remove(po.x);
                }
            }

            System.out.println("Case #" + k + ": " + ans);
        }


    }
}