import java.io.*;

class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int k = 1; k <= test; ++k) {
            int S = Integer.parseInt(br.readLine());
            int[][] arr = new int[S][S];
            int sum=0, row=0, col=0;

            

            for (int m = 0; m < S; ++m) {
                boolean[] Rowfreq = new boolean[S + 1];
                String[] ln = br.readLine().split(" ");
                boolean Countrow = false;
                for (int n = 0; n < S; ++n) {
                    arr[m][n] = Integer.parseInt(ln[n]);
                    if (m == n) {
                        sum += arr[m][n];
                    }
					
                    int num = arr[m][n];
                    if (!Countrow && !Rowfreq[num]) {
                        Rowfreq[num] = true;
                    } else if (!Countrow && Rowfreq[num]) {
                        Countrow = true;
                        ++row;
                    }
                }
            }

            for (int m = 0; m < S; ++m) {
                boolean[] Colfreq = new boolean[S + 1];
                boolean Countcol = false;
                for (int n = 0; n < S; ++n) {
                    int num = arr[n][m];
                    if (!Countcol && !Colfreq[num]) {
                        Colfreq[num] = true;
                    } else if (!Countcol && Colfreq[num]) {
                        Countcol = true;
                        ++col;
                    }
                }
            }
            System.out.println("Case #" + k + ": " + sum + " " + row + " " + col);
        }
    }
}