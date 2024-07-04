
import java.util.*;
import java.io.*;
class Main
{
    public static void main(String [] args)
    {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int [][] a = new int [n][n]; int trace = 0; int row = 0; int col = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if (i == j) trace += a[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> h = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!h.contains(a[i][j])) {
                        h.add(a[i][j]);
                    } else {
                        row++;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> h = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!h.contains(a[j][i])) {
                        h.add(a[j][i]);
                    } else {
                        col++;
                        break;
                    }
                }
            }
            out.println("Case #" + p + ": " + trace + " " + row + " " + col);
        }
        out.close();
    }




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

        String nextLine(){
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