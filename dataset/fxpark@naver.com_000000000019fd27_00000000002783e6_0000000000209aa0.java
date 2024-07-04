import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
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
            if(res != null) {
                wr.println(String.format("Case #%d: POSSIBLE", i + 1));
                wr.println(res);
            }
            else
                wr.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        int n = Integer.parseInt(nextToken());
        int k = Integer.parseInt(nextToken());
        int[] solution = new int[n];
        for(int i = 0; i < n; i++) {
            if((i+1)*n == k) {
                for (int j = 0; j < n; j++) {
                    solution[j] = i + 1;
                }
                break;
            }
        }

        if(solution[0] == 0) {
            int v = k / n;
            int m = k % n;

            int counter = 0;
            for(int j  = 0; j < n; j++) {
                int add;
                if(counter <= m) {
                    add = counter;
                    m -= counter;

                    if(v + counter < n)
                        counter++;

                } else {
                    add = m;
                    m = 0;
                }

                solution[j] = v + add;
            }
        }

        if(isImpossible(solution))
            return null;

        return makeMatrix(solution);
    }

    private String makeMatrix(int[] solution) {
        int l = solution.length;
        int[][] sol = init(solution);

        int[] completed = new int[l];
        int startRow = 0;
        int curRow = 0;
        while(!isAllComplete(completed) && startRow < l) {
            if(curRow == l)
                curRow = 0;

            int[] tmp = new int[l];
            tmp[solution[curRow] - 1] = 1;
            boolean r = findRow(sol, tmp, curRow, 0, solution);

            if(r) {
                completed[curRow] = 1;
                curRow++;
            } else {
                startRow++;
                curRow = startRow;
                sol = init(solution);
                completed = new int[l];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                sb.append(sol[i][j] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean isAllComplete(int[] completed) {
        for(int c : completed) {
            if(c == 0)
                return false;
        }
        return true;
    }

    private int[][] init(int[] solution) {
        int l = solution.length;
        int[][] sol = new int[l][l];
        for(int i = 0; i < l; i++) {
            sol[i][i] = solution[i];
        }
        return sol;
    }

    private boolean findRow(int[][] sol, int[] tmp, int rowNum, int colNum, int[] solution) {

        if(colNum == solution.length)
            return true;

        if(rowNum == colNum) {
            tmp[solution[colNum] - 1] = 1;

            return findRow(sol, tmp, rowNum, colNum + 1, solution);
        } else {

            int[] yTmp = new int[tmp.length];
            for(int i = 0; i < tmp.length; i++) {
                if(sol[i][colNum] != 0) {
                    yTmp[sol[i][colNum] - 1] = 1;
                }
            }

            for(int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 0 && yTmp[i] == 0) {
                    sol[rowNum][colNum] = i + 1;
                    tmp[i] = 1;
                    boolean r = findRow(sol, tmp, rowNum, colNum + 1, solution);

                    if(r)
                        return true;
                    else {
                        sol[rowNum][colNum] = 0;
                        tmp[i] = 0;
                    }
                }
            }

            return false;
        }
    }

    private boolean isImpossible(int[] solution) {
        int[] tmp = new int[solution.length];
        for(int i = 0; i < solution.length; i++) {
            if(solution[i] == 0)
                return true;

            tmp[solution[i]-1]++;
        }
        int maxFreqIdx = 0;
        int maxFrequencyNum = 0;
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] > maxFrequencyNum) {
                maxFreqIdx = i;
                maxFrequencyNum = tmp[i];
            }
        }
        int notFreqCnt = 0;
        for (int value : solution) {
            if (value != maxFreqIdx + 1)
                notFreqCnt++;
        }

        return notFreqCnt == 1;
    }
}