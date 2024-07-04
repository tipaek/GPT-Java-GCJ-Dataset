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
            int d = sc.nextInt();
            long[] arr = new long[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            if (d == 2) {
                boolean good = false;
                for (int i=0; i<n-1; i++) {
                    if (arr[i] == arr[i+1]) {
                        good = true;
                        break;
                    }
                }
                if (good) {
                    pw.println("Case #" + t + ": 0");
                } else {
                    pw.println("Case #" + t + ": 1");
                }
            } else {
                HashSet<Long> set = new HashSet<Long>();
                boolean found = false;
                long cur = arr[0];
                int num = 1;
                int max = 2;
                for (int i=1; i<n; i++) {
                    if (arr[i] == cur) {
                        num++;
                        if (num > 2) {
                            found = true;
                            break;
                        }
                    } else {
                        if (num > 1) {
                            max = 1;
                        }
                        set.add(cur);
                        cur = arr[i];
                        num = 1;
                    }
                }
                if (found) {
                    pw.println("Case #" + t + ": 0");
                } else if (max == 1) {
                    pw.println("Case #" + t + ": 1");
                } else {
                    set.add(cur);
                    for (Long l : set) {
                        if (set.contains(2*l)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        pw.println("Case #" + t + ": 1");
                    } else {
                        pw.println("Case #" + t + ": 2");
                    }
                }
            }
        }
    }

    static class Pair {
        long num;
        String str;

        public Pair(long num, String str) {
            this.num = num;
            this.str = str;
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
