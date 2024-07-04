import java.io.*;
import java.util.*;
public class Solution {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int k =1;k<=t;k++) {
            int n = sc.nextInt();
            int [][] a= new int[n][n];
            int sum=0;
            for (int i =0;i<n;i++){
                for (int j =0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
                sum+=a[i][i];
            }
            int r=0;
            int c=0;
            for (int i =0;i<n;i++){
                HashSet<Integer>hs1=new HashSet<>(),hs2=new HashSet<>();
                for (int j =0;j<n;j++){
                    hs1.add(a[i][j]);
                    hs2.add(a[j][i]);
                }
                if (hs1.size()!=n)
                    r++;
                if (hs2.size()!=n)
                    c++;
            }
            pw.println("Case #"+k+": "+ sum+" "+r+" "+c);
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