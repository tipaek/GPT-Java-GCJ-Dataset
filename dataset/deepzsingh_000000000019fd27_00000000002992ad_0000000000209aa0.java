
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
   static int sqr[][];
    static boolean row_safe[][];
    static boolean col_safe[][];
    static int n;
    static int k;
    static int x;
    static boolean solved;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;


        public FastReader() {
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

    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int t=sc.nextInt();

        while (t-->0)
        {
            x++;
             n=sc.nextInt();
             k=sc.nextInt();
             sqr=new int[n+2][n+2];
            row_safe=new boolean[n+2][n+2];
            col_safe=new boolean[n+2][n+2];
            solved=false;
            solver(1,1,0);
            if ( solved==false )
            {
                System.out.println("Case #"+x+": "+"IMPOSSIBLE");
            }
        }

    }
    public static void solver(int row, int col, int m) {

        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #"+x+": "+"POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(sqr[i][j]+" ");
                }
                System.out.println("");
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solver(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !solved; ++i) {
            if (!row_safe[row][i] && !col_safe[col][i]) {
                row_safe[row][i] = col_safe[col][i]=true;
                //solved=true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;

                solver(row, col + 1, m);

                row_safe[row][i] = col_safe[col][i]=false;
                //solved=false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }
}