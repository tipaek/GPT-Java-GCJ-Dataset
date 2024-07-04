
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
            int [] startTimes = new int [n];
            int [] endTimes = new int [n];
            int[] tab = new int[1441];
            boolean test = false;
            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                for (int j = startTimes[i]; j < endTimes[i]; j++) {
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

                
                int[] endTimes2 = Arrays.copyOf(endTimes, n);
                int[] endTimes3 = Arrays.copyOf(endTimes, n);
                Arrays.sort(endTimes2);
                
                String [] bab = new String[n];
                

                int k = findTaskIndexByEndTime(endTimes2[0], endTimes);
                bab[k] = "J";
                endTimes[k] = -2;

//                tt[0].doer = "J";
                int x;
                for (int j = 1; j < n; j++) {
                    x = findTaskIndexByEndTime(endTimes2[j], endTimes);
                    if (startTimes[x] >= endTimes3[k]) {
                        bab[x] = "J";
                        k = x;
                        endTimes[x] = -2;
                    } else {
                        bab[x] = "C";
                        endTimes[x] = -2;
                    }
                }
                String ch = "";
                for (int i = 0; i < n; i++) {
                    ch = ch.concat(bab[i]);

                }

                pw.println("Case #" + (t + 1) + ": " + ch);
            }

//            pw.println("Case #" + (t + 1) + ": " + res);
        }
        pw.close();
        // TODO code application logic here
    }

    static int findTaskIndexByEndTime(int endTime, int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == endTime) {
                return i;
            }

        }
        return -1;
    }

//    static class Task {
//
//        int startTime;
//        int endTime;
//        String doer;
//
//        public Task(int startTime, int endTime) {
//            this.startTime = startTime;
//            this.endTime = endTime;
//        }
//
//    }

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
