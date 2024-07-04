import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Solution1 implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution1()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;

    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);
        int t = Integer.parseInt(nextToken());
        for (int i = 0; i < t; ++i) {
            String res = subsolve();
            wr.println(String.format("Case #%d: %s", i + 1, res));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        Integer n = Integer.valueOf(nextToken());
        int k = 0;
        int r = 0;
        int c = 0;
        int[][] cTmp = new int[n][n];

        for(int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            boolean isRepeated = false;
            for(int j = 0; j < n; j++) {
                int v = Integer.parseInt(nextToken());

                //set K
                if(i == j)
                    k += v;

                //set R
                if(tmp[v-1] == 0)
                    tmp[v-1] = 1;
                else
                    isRepeated = true;

                //set C
                cTmp[j][v-1] = 1;
            }
            if(isRepeated)
                r++;
        }

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {
                System.out.print(cTmp[i][j] + " ");
                if(cTmp[i][j] == 0) {
                    c++;
                    break;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        StringBuilder sb = new StringBuilder();
        sb.append(k);
        sb.append(" ");
        sb.append(r);
        sb.append(" ");
        sb.append(c);
        return sb.toString();
    }
}