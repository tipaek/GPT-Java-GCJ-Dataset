import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    public Solution() throws IOException {}

    private void run() throws IOException {
        solve();
        out.close();
    }

    private void printSchedule(int[][] jobs, int caseNumber) {
        int c = 0, j = 0;
        for (int i = 0 ; i < jobs.length; i++) {
            int[] job = jobs[i];
            int start = job[0];
            int end = job[1];
            if (start >= c) {
                c = end;
                jobs[i][3] = 1;
            } else if (start >= j) {
                j = end;
                jobs[i][3] = 2;
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(jobs, (a, b) -> a[2] - b[2]); // back to the original order
        StringBuilder sb = new StringBuilder();
        sb.append("Case #").append(caseNumber).append(": ");
        for (int[] job : jobs) {
            if (job[3] == 1) {
                sb.append("C");
            } else {
                sb.append("J");
            }
        }
        System.out.println(sb.toString());
    }

    private void solve() throws IOException {
        int t = nextInt();
        for (int it = 0; it < t; it++) {
            int n = nextInt();
            int[][] jobs = new int[n][4];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = nextInt();
                jobs[i][1] = nextInt();
                jobs[i][2] = i; // index
                jobs[i][3] = 0; // owner: 1 for C, 2 for J
            }
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
            printSchedule(jobs, it+1);
        }
    }


    String next() throws IOException  {
        while (st == null || !st.hasMoreTokens())  {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException  {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException  {
        return Long.parseLong(next());
    }

}
