import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.next();
            }
            String start = "";
            String end = "";
            boolean possible = true;
            for (int i=0; i<arr.length; i++) {
                String[] split = arr[i].split("\\*");
                String curStart = split[0];
                String curEnd;
                if (split.length == 2) {
                    curEnd = split[1];
                } else {
                    curEnd = "";
                }
                if (curStart.startsWith(start)) {
                    start = curStart;
                } else if (!start.startsWith(curStart)) {
                    possible = false;
                    break;
                }
                if (curEnd.endsWith(end)) {
                    end = curEnd;
                } else if (!end.endsWith(curEnd)) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append(end);
                pw.println("Case #" + t + ": " + sb.toString()); 
            } else {
                pw.println("Case #" + t + ": *"); 
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
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
}
