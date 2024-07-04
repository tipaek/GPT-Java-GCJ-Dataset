import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader s = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static int[] rai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static long[] ral(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }

    private static int ri() {
        return s.nextInt();
    }

    private static long rl() {
        return s.nextLong();
    }

    private static String rs() {
        return s.next();
    }

    static HashMap<Point,Integer> bfs(int n,Point[][] points)
    {
        HashMap<Point,Integer> visited=new HashMap<>();
        visited.put(points[2999][2999],0);
        List<Point> list=new ArrayList<>();
        list.add(points[2999][2999]);
        int count=1;
        while(count<=n)
        {
            int size=list.size();
            for(int i=0;i<size;i++) {
                Point p = list.remove(0);
                Point up = points[p.x + 2999][p.y + 1 + 2999];
                Point down = points[p.x + 2999][p.y - 1 + 2999];
                Point left = points[p.x - 1 + 2999][p.y + 2999];
                Point right = points[p.x + 1 + 2999][p.y + 2999];
                if (!visited.containsKey(up)) {
                    visited.put(up, count);
                    list.add(up);
                }
                if (!visited.containsKey(down)) {
                    visited.put(down, count);
                    list.add(down);
                }
                if (!visited.containsKey(left)) {
                    visited.put(left, count);
                    list.add(left);
                }
                if (!visited.containsKey(right)) {
                    visited.put(right, count);
                    list.add(right);
                }
            }
            count++;
        }
        return visited;
    }
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int t = ri();
        int count=1;
        while (t-- > 0) {
            ans.append("Case #").append(count++).append(": ");
//            Point[][] points=new Point[6000][6000];
//            for(int i=-2999;i<=3000;i++)
//            {
//                for(int j=-2999;j<=3000;j++)
//                {
//                    Point p=new Point(i,j);
//                    points[i+2999][j+2999]=p;
//                }
//            }
            int x=ri();
            int y=ri();
            String str=rs();
//            HashMap<Point,Integer> map=new HashMap<>();
            List<Point> list=new ArrayList<>();
            list.add(new Point(x,y));
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='N')
                {
                    y+=1;

                }
                else if(str.charAt(i)=='S')
                {
                    y-=1;
                }
                else if(str.charAt(i)=='E')
                {
                    x+=1;
                }
                else
                {
                    x-=1;
                }
                list.add(new Point(x,y));
            }
//            HashMap<Point,Integer> myRoute=bfs(str.length(),points);
//            for(Point p:myRoute.keySet())
//            {
//                System.out.println("("+p.x+" "+p.y+") -> "+myRoute.get(p));
//            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<list.size();i++)
            {
                Point p=list.get(i);
                int sum=Math.abs(p.x)+Math.abs(p.y);
                if(sum<=i)
                {
                    min=Math.min(i,min);
                }
            }
            if(min==Integer.MAX_VALUE)
            {
                ans.append("IMPOSSIBLE\n");
            }
            else
            {
                ans.append(min).append("\n");
            }



        }
        out.print(ans.toString());
        out.flush();

    }
}
class Point
{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}