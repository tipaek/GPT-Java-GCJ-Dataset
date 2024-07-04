import java.io.*;
import java.util.*;
public class Solution {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int k =1;k<=t;k++) {
            int n = sc.nextInt();
            int[][]a= new int[n][3];
            for (int i =0;i<n;i++){
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=i;
            }
            Arrays.sort(a,(x,y)->x[0]-y[0]);
            char[]sol= new char[n];
            int p1=-1;
            int p2=-2;
            boolean is =true;
            for (int i =0;i<n;i++){
                if (p1<=a[i][0]){
                    p1=a[i][1];
                    sol[a[i][2]]='C';
                }
                else if (p2<=a[i][0]){
                    p2=a[i][1];
                    sol[a[i][2]]='J';
                }
                else is=false;
            }
            if (!is){
                pw.printf("Case #%d: IMPOSSIBLE\n",k);
            }
            else {
                StringBuilder sb = new StringBuilder();
                for (char x:sol)sb.append(x);
                pw.printf("Case #%d: %s\n",k,sb.toString());
            }
        }

        pw.flush();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}