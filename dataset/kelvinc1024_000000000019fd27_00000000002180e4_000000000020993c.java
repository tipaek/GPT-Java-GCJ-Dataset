import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int tc = scan.nextInt();
        for (int ttc = 1; ttc <= tc; ttc++) {
            int n = scan.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = scan.nextInt();
                }
            }
            int a = 0;
            for (int i = 0; i < n; i++) {
                a += board[i][i];
            }
            int b = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(board[i][j])) {
                        b++;
                        break;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(board[j][i])) {
                        c++;
                        break;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
            out.println("Case #" + ttc + ": " + a + " " + b + " " + c);
        }


        out.close();
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

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