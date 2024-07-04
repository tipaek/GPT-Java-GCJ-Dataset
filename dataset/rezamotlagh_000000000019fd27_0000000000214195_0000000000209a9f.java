
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        int tc = 1;
        while (T-->0)
        {
            String s = fr.next();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < s.length() ; i++)
            {
                int n = s.charAt(i) - '0';
                for(int j = 0 ; j < n ; j++)
                    sb.append("(");
                sb.append(n);
                for(int j = 0 ; j < n ; j++)
                    sb.append(")");
            }
            int last = 0;
            while((last = last(sb)) != -1)
            {
                sb.deleteCharAt(last);
                sb.deleteCharAt(last);
            }
            System.out.printf("Case #%d: %s\n",tc++,sb.toString());

        }
    }
    static int last(StringBuilder s)
    {
        for(int i = 1 ; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' && s.charAt(i-1)==')')
                return i-1;
        }
        return -1;
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
