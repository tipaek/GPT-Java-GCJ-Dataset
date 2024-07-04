
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
            Task[] tt2 = new Task[n];
            int[] tab = new int[1441];
            int[][] mat = new int[n][2];
            boolean test = false;
            for (int i = 0; i < n; i++) {
                mat[i][0] = sc.nextInt();
                mat[i][1] = sc.nextInt();
                tt[i] = new Task(mat[i][0], mat[i][1], i);
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
                tt2 = Arrays.copyOf(tt, n);
                Arrays.sort(tt);
                tt[0].doer = "J";
                int k=0;
                for (int j = 1; j < n; j++) {
                    if (tt[j].startTime>=tt[k].endTime) {
                        tt[j].doer="J";
                        k = j;
                    }else{
                        tt[j].doer="C";
                    }
                }
                String ch = "";
                for (int i = 0; i < n; i++) {
                    ch=ch.concat(tt2[i].doer);
                    
                }
//                boolean test2;
//                for (int i = 0; i < n; i++) {
//                    test2 = false;
//                    for (int j = (mat[i][0]); j < (mat[i][1]); j++) {
//                        if (tab[j] == 2) {
//                            test2 = true;
//                        }
//                        tab[j]--;
//                    }
//                    if (test2) {
//                        ch = ch.concat("C");
//                    } else {
//                        ch = ch.concat("J");
//                    }
//
//                }
                pw.println("Case #" + (t + 1) + ": "+ch);
            }

//            pw.println("Case #" + (t + 1) + ": " + res);
        }
        pw.close();
        // TODO code application logic here
    }

    static class Task implements Comparable<Task> {

        int startTime;
        int endTime;
        String doer;
        int rank;

        public Task(int startTime, int endTime, int rank) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.rank = rank;
        }

        @Override
        public int compareTo(Task o) {
            return this.endTime - o.endTime;
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
