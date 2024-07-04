import java.io.*;
import java.util.*;

public class Solution {
    //Solution by Sathvik Kuthuru
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = scan.nextInt();
            String[] first = new String[n], second = new String[n];
            for(int i = 0; i < n; i++) {
                String[] curr = ("?" + scan.next() + "?").split("\\*");
                first[i] = curr[0];
                second[i] = curr[1];
            }
            String longest = "";
            for(int i = 0; i < n; i++) {
                if(first[i].length() > longest.length()) longest = first[i];
            }
            for(int i = 0; i < n; i++) {
                if(!longest.startsWith(first[i])) {
                    out.println("*");
                    return;
                }
            }
            String longest2 = "";
            for(int i = 0; i < n; i++) {
                if(second[i].length() > longest2.length()) longest2 = second[i];
            }
            for(int i = 0; i < n; i++) {
                if(!longest2.endsWith(second[i])) {
                    out.println("*");
                    return;
                }
            }
            for(char c : longest.toCharArray()) {
                if(c != '?') out.print(c);
            }
            for(char c : longest2.toCharArray()) {
                if(c != '?') out.print(c);
            }
            out.println();
        }
    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

}