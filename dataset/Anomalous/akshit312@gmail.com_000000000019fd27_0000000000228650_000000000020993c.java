import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    void pre() throws Exception {}

    void solve(int testCaseNumber) throws Exception {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n = ni();
            int[][] matrix = new int[n][n];
            long sum = 0;
            int rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                boolean rowFlag = false;
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = ni();
                    if (i == j) sum += matrix[i][j];
                    if (!rowSet.add(matrix[i][j])) rowFlag = true;
                }
                if (rowFlag) rowDuplicates++;
            }

            for (int i = 0; i < n; i++) {
                boolean colFlag = false;
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) colFlag = true;
                }
                if (colFlag) colDuplicates++;
            }

            pn("Case #" + (ii + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    static boolean multipleTC = false, memory = false;
    FastReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        if (memory) {
            new Thread(null, () -> {
                try {
                    new Solution().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "1", 1 << 28).start();
        } else {
            new Solution().run();
        }
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    String n() throws Exception {
        return in.next();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }
    }
}