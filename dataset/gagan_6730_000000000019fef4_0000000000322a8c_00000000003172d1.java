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

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int t = ri();
        int count=1;
        while (t-- > 0) {
            ans.append("Case #").append(count++).append(": ");
            long n=rl();
            long d=rl();
            HashMap<Double,Integer> map=new HashMap<>();
            for(long i=0;i<n;i++)
            {
                double val=s.nextDouble();
                map.put(val,map.getOrDefault(val,0)+1);
            }
            if(d==2)
            {
                int flag=0;
                for(double i:map.keySet())
                {
                    if(map.get(i)>=2)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1) {
                    ans.append("0\n");
                }
                else
                {
                    ans.append("1\n");
                }
            }
            else if(d==3)
            {
                int flag=0;
                int f2=0;int f=0;

                for(double i:map.keySet())
                {
                    if(map.get(i)>=3)
                    {
                        flag=1;
                        break;
                    }
                    else if(map.get(i)==2)
                    {

                        for(double j:map.keySet())
                        {
                            if(j>i)
                            {
                                f=1;
                                break;
                            }
                        }

                    }
                    else
                    {
                        double val=i/2;
                        if(map.containsKey(val))
                        {
                            f2=1;
                        }
                    }
                }
                if(flag==1)
                {
                    ans.append("0\n");
                }else if(f2==1 || f==1)
                {
                    ans.append("1\n");
                }
                else
                {
                    ans.append("2\n");
                }
            }
            else
            {
                ans.append("1\n");
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