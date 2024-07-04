import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        int tc = scan.nextInt();
        for (int i = 0; i < tc; i++) {
            out.print("Case #" + (i + 1) + ": ");
            solve();
        }
        out.close();
    }

    private static void solve() {
        int x = scan.nextInt();
        int y = scan.nextInt();
        String path = scan.next();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'S') y--;
            else if (path.charAt(i) == 'N') y++;
            else if (path.charAt(i) == 'E') x++;
            else x--;
            if ((i + 1) >= Math.abs(x) + Math.abs(y)) {
                out.println(i + 1);
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static MyScanner scan = new MyScanner();

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    //--------------------------------------------------------

}