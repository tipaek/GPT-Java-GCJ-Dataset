import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);


        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = sc.nextInt();
            long ans = 0;
            while (true) {
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        ans += a[i][j];
                ArrayList<Integer> changeX = new ArrayList<>();
                ArrayList<Integer> changeY = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++) {
                        if (a[i][j] == 0)
                            continue;
                        int cnt = 0, sum = 0;
                        for (int k = i - 1; k >= 0; k--) {
                            if (a[k][j] > 0) {
                                cnt++;
                                sum += a[k][j];
                                break;
                            }
                        }
                        for (int k = i + 1; k < n; k++) {
                            if (a[k][j] > 0) {
                                cnt++;
                                sum += a[k][j];
                                break;
                            }
                        }
                        for (int k = j - 1; k >= 0; k--) {
                            if (a[i][k] > 0) {
                                cnt++;
                                sum += a[i][k];
                                break;
                            }
                        }
                        for (int k = j + 1; k < m; k++) {
                            if (a[i][k] > 0) {
                                cnt++;
                                sum += a[i][k];
                                break;
                            }
                        }
                        if (cnt > 0 && a[i][j] * cnt < sum) {
                            changeX.add(i);
                            changeY.add(j);
                        }
                    }
                if (changeX.size() == 0)
                    break;
                for (int i = 0; i < changeX.size(); i++)
                    a[changeX.get(i)][changeY.get(i)] = 0;
            }

            pw.printf("Case #%d: %d\n", tc, ans);


        }


        pw.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String s) throws Throwable {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() throws Throwable {
            if (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(next());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(next());
        }

    }

}