//package Codejam;
import java.util.*;
import java.io.*;
public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader fastReader =new FastReader();
        int t = fastReader.nextInt();
        for (int i = 1; i <=t ; i++) {
            int x=fastReader.nextInt();
            int y=fastReader.nextInt();
            String str=fastReader.next();
            int res=0;
            int f=0;
            int time=0;
            for (int j = 0; j <str.length() ; j++) {
              // System.out.println(x+" "+y);
                if(Math.abs(x)+Math.abs(y)<=time){
                    res=time;
                    f=1;
                    break;
                }
                if(str.charAt(j)=='S')
                    y--;
                else if(str.charAt(j)=='N')
                    y++;
                else if(str.charAt(j)=='E')
                    x++;
                else
                    x--;
                time++;
            }
            if(Math.abs(x)+Math.abs(y)<=time) {
                res = time;
              //  System.out.println(x+" "+y);
                f=1;
            }
            if(f==1)
            System.out.println("Case #"+i+": "+res);
            else
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }
        }

    }
