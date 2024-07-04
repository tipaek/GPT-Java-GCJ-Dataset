import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }, "solution", 1 << 26).start();
    }
    
    public Solution() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.stk = null;
    }

    private final long MOD = 1000000007L;

    private void run() throws Exception {
        int t = nextInt();
        for (int I = 1; I <= t; I++) {
            int n = nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = nextInt();
                }
            }

            int rowReps = 0, colReps = 0, trace = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                HashMap<Integer, Integer> colMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    // Check for row repetitions
                    if (rowMap.containsKey(matrix[i][j])) {
                        rowReps++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
                for (int j = 0; j < n; j++) {
                    // Check for column repetitions
                    if (colMap.containsKey(matrix[j][i])) {
                        colReps++;
                        break;
                    } else {
                        colMap.put(matrix[j][i], 1);
                    }
                }
                // Sum the trace
                trace += matrix[i][i];
            }

            println("Case #" + I + ": " + trace + " " + rowReps + " " + colReps);
        }
    }

    // Reader & Writer methods
    private String nextToken() throws Exception {
        while (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private void println(Object o) {
        System.out.println(o);
    }
}