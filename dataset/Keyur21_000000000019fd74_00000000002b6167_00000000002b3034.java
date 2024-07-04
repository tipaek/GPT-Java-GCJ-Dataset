import java.io.*;
import java.util.*;

class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer st;

    private static void solve() throws IOException {

        int t = 1;
        t = nextInt();

        for(int i = 1;i<=t;i++) {
            out.print("Case #" + i + ": ");
            solution(i);
        }

    }

    private static void solution(int testNumber) throws IOException {
        int n = nextInt();

        String[] s = new String[n];

        int index = 0;
        int max = 0;
        for(int i = 0;i<n;i++) {
            s[i] = next().substring(1);

            if(s[i].length() > max) {
                max = s[i].length();
                index = i;
            }
//            out.println(s[i]);
        }

        boolean f = false;
        for(int i = 0;i<n;i++) {
            if(!s[index].contains(s[i])) {
                f = true;
            }
        }

//        out.println(index+ " " + s[index].length());

        if(f) out.println("*");
        else {
                out.print(s[index]);
            out.println();
        }






    }


    private static void eat(String str) {
        st = new StringTokenizer(str);
    }

    private static  String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        in.close();
        out.close();
    }
}
