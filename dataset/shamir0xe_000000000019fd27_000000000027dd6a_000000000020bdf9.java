import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        MyInput inputReader = new MyInput(System.in);
        PrintWriter outputWriter = new PrintWriter(System.out);
        int testCases = inputReader.nextInt();
        for (int i = 0; i < testCases; ++i) {
            Solver solver = new Solver(inputReader);
            String ans = solver.solve();
            outputWriter.println("Case #" + (i + 1) + ": " + ans);
        }
        outputWriter.flush();
        outputWriter.close();
    }
}

class Solver {
    MyInput inputReader;

    public Solver(MyInput inputReader) {
        this.inputReader = inputReader;
    }

    private boolean haveIntersect(int[][] intervals, int i, int j) {
        return
            (intervals[j][0] <= intervals[i][0] && intervals[i][0] < intervals[j][1]) ||
            (intervals[j][0] < intervals[i][1] && intervals[i][1] <= intervals[j][1]);
    }

    private boolean BFS(ArrayList<Integer>[] adj, int[] colors, int n, int u, int cur_color) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{u, cur_color});
        colors[u] = cur_color;
        while (!q.isEmpty()) {
            int[] head = q.poll();
            u = head[0];
            cur_color = head[1];
            for (int j = 0; j < adj[u].size(); ++j) {
                int v = adj[u].get(j);
                if (colors[v] == 0) {
                    q.add(new int[]{v, 3 - cur_color});
                    colors[v] = 3 - cur_color;
                } else if (colors[v] == cur_color) {
                    return false;
                }
            }
        }
        return true;
    }

    public String solve() {
        int n = this.inputReader.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; ++i) {
            intervals[i][0] = this.inputReader.nextInt();
            intervals[i][1] = this.inputReader.nextInt();
        }
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                boolean intersect = haveIntersect(intervals, i, j);
                intersect |= haveIntersect(intervals, j, i);
                if (intersect) {
                    adj[i].add(j);
                    adj[j].add(i);
                    // System.out.println(i + " -- " + j);
                }
            }
        }
        int[] colors = new int[n];
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 0) {
                boolean ret = BFS(adj, colors, n, i, 1);
                if (!ret) {
                    return "IMPOSSIBLE";
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 1)
                res = res.append("C");
            else
                res = res.append("J");
        }
        return res.toString();
    }
}


/**
 * Created by shamir14 on 3/7/14.
 */
class MyInput {
    BufferedReader bufferedReader;
    StringTokenizer stringTokenizer;

    public MyInput(InputStream inputStream){
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        stringTokenizer = null;
    }

    public String next() {
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                throw new UnknownError();
            }
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new UnknownError();
        }
    }

    public boolean hasNext(){
        if(stringTokenizer.hasMoreTokens())
            return true;
        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (IOException e) {
            throw new UnknownError();
        }
        return true;
    }

}
