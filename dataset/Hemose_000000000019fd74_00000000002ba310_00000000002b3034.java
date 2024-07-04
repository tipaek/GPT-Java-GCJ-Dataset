import java.io.*;
import java.util.*;
import java.util.zip.Adler32;

public class Solution {
    static boolean check(String big ,String small){
        int i =0;
        while (i<small.length()){
            if (big.charAt(i)!=small.charAt(i))
                return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int k=1;k<=t;k++){
            int n = sc.nextInt();
            String[]a= new String[n];
            String[]first = new String[n];
            String[]last = new String[n];
            String ff ="";
            String ll ="";
            for (int i =0;i<n;i++){
                a[i]=sc.next();
                first[i]="";
                last[i]="";
                StringBuilder sb = new StringBuilder(),sb2=new StringBuilder();
                for (int j =0;j<a[i].length();j++){
                    if (a[i].charAt(j)=='*')
                        break;
                    sb.append(a[i].charAt(j));
                }
                for (int j =a[i].length()-1;j>=0;j--){
                    if (a[i].charAt(j)=='*')
                        break;
                    sb2.append(a[i].charAt(j));
                }
                first[i]=sb.toString();
                last[i]=sb2.toString();
                if (first[i].length()>ff.length())
                    ff=first[i];
                if (last[i].length()>ll.length())
                    ll=last[i];
            }
            boolean is =true;
            StringBuilder sol = new StringBuilder();
            sol.append(ff);
            for (int i =0;i<n;i++){
                if (!check(ff,first[i])||!check(ll,last[i])){
                    is=false;
                    break;
                }
                for (int j = first[i].length();j<a[i].length()-last[i].length();j++){
                    if (a[i].charAt(j)!='*')
                        sol.append(a[i].charAt(j));
                }
            }
            StringBuilder sb2 = new StringBuilder(ll);
            sol.append(sb2.reverse());
            if (is){
                pw.println("Case #"+k +": "+sol.toString());
            }
            else {
                pw.println("Case #"+k +": *");
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