
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        int tc = 1;
        while (T-->0)
        {
            int N = sc.nextInt();
            pair[] list = new pair[N];
            for(int i = 0 ; i < N ;i++)
                list[i] = new pair(sc.nextInt() , sc.nextInt());
            Arrays.sort(list);
            boolean flag = true;
            int cend =  -1;
            int jend = -1;
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < N ; i++)
            {
                if(cend <= list[i].start)
                {
                    sb.append("C");
                    cend = list[i].end;
                }else if(jend <= list[i].start)
                {
                    sb.append("J");
                    jend = list[i].end;
                }else
                {
                    flag = false;
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n",tc++,flag ? sb.toString() : "IMPOSSIBLE");
        }
    }
    static class pair implements Comparable<pair>{
        @Override
        public int compareTo(pair o) {
            int cmp = Integer.compare(start , o.start);
            if(cmp == 0)
                cmp = Integer.compare(end , o.end);
            return cmp;
        }

        int start , end ;
        public pair(int s , int e)
        {
            start = s;
            end = e;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { // To read from the standard input
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        // You can add a constructor to read from a file
        /////
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        String nextLine() throws IOException { return br.readLine(); }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        //You can add nextDouble() etc...
        boolean hasNext() throws IOException { // if input is terminated by EOF
            String s = br.readLine();
            if (s == null) return false;
            st = new StringTokenizer(s);
            return true;
        }
    } //end FastReader



}
