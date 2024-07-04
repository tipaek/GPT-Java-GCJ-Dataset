
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houssem
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            Task[] tt = new Task[n];
//             = new Task[n];
            int[] tab = new int[1441];
            int[][] mat = new int[n][2];
            boolean test = false;
            for (int i = 0; i < n; i++) {
                mat[i][0] = sc.nextInt();
                mat[i][1] = sc.nextInt();
                tt[i] = new Task(mat[i][0], mat[i][1]);
                for (int j = (mat[i][0]); j < mat[i][1]; j++) {
                    tab[j]++;
                    if (tab[j] > 2) {
                        test = true;
                        break;
                    }

                }
                if (test) {
                    pw.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    break;
                }
            }
            if (!test) {

                int[] tar = new int[n];
                Task[] tt2 = new Task[n];
                int l = 0;
                for (Task ta : tt) {
                    tar[l] = ta.endTime;
                    tt2[l]=new Task(ta.startTime, ta.endTime);
                    l++;
                }
                Arrays.sort(tar);
                
                

                int k = findTaskIndexByEndTime(tar[0], tt);
                tt[k].doer = "J";
                tt[k].endTime = -2;

//                tt[0].doer = "J";
                int x;
                for (int j = 1; j < n; j++) {
                    x = findTaskIndexByEndTime(tar[j], tt);
                    if (tt[x].startTime >= tt2[k].endTime) {
                        tt[x].doer = "J";
                        k = x;
                        tt[x].endTime = -2;
                    } else {
                        tt[x].doer = "C";
                        tt[x].endTime = -2;
                    }
                }
                String ch = "";
                for (int i = 0; i < n; i++) {
                    ch = ch.concat(tt[i].doer);

                }

                pw.println("Case #" + (t + 1) + ": " + ch);
            }

//            pw.println("Case #" + (t + 1) + ": " + res);
        }
        pw.close();
        // TODO code application logic here
    }

    static int findTaskIndexByEndTime(int endTime, Task[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].endTime == endTime) {
                return i;
            }

        }
        return -1;
    }

    static class Task {

        int startTime;
        int endTime;
        String doer;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
