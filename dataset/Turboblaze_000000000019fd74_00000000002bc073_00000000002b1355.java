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
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] board = new int[r][c];
            for (int a=0; a<r; a++) {
                for (int b=0; b<c; b++) {
                    board[a][b] = sc.nextInt();
                }
            }
            long interest = 0;
            while (true) {
                for (int i=0; i<r; i++) {
                    for (int j=0; j<c; j++) {
                        interest += board[i][j];
                    }
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                for (int i=0; i<r; i++) {
                    for (int j=0; j<c; j++) {
                        int cur = board[i][j];
                        if (cur > 0) {
                            int num = 0;
                            double neighbor = 0;
                            for (int u=i-1; u>=0; u--) {
                                if (board[u][j] > 0) {
                                    neighbor += board[u][j];
                                    num++;
                                    break;
                                }
                            }
                            for (int v=i+1; v<r; v++) {
                                if (board[v][j] > 0) {
                                    neighbor += board[v][j];
                                    num++;
                                    break;
                                }
                            }
                            for (int x=j-1; x>=0; x--) {
                                if (board[i][x] > 0) {
                                    neighbor += board[i][x];
                                    num++;
                                    break;
                                }
                            }
                            for (int y=j+1; y<c; y++) {
                                if (board[i][y] > 0) {
                                    neighbor += board[i][y];
                                    num++;
                                    break;
                                }
                            }
                            if (num > 0) {
                                if (cur < neighbor/num) {
                                    al.add(i);
                                    al.add(j);
                                }
                            }
                        }
                    }
                }
                if (al.size() > 0) {
                    for (int i=0; i<al.size(); i+=2) {
                        board[al.get(i)][al.get(i+1)] = 0;
                    }
                } else {
                    break;
                }
            }
            pw.println("Case #" + t + ": " + interest); 
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
