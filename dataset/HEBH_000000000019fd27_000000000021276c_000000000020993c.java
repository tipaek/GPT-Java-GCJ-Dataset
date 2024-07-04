
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int trace = 0;
            int[][] Mat = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Mat[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += Mat[j][k];
                    }
                }
            }
            int r = 0;
            int c = 0;
            boolean testr = false;
            boolean testc = false;
            int[] tabr = new int[n];
            int[] tabc = new int[n];
            for (int j = 0; j < n; j++) {
                
                for (int k = 0; k < n; k++) {
                    if (!testr) {
                        tabr[Mat[j][k]-1]++;
                        if (tabr[Mat[j][k]-1] > 1) {
                            testr = true;
                            r++;
                            
                        }
                    }
                    if (!testc) {
                        tabc[Mat[k][j]-1]++;
                        if (tabc[Mat[k][j]-1] > 1) {
                            testc = true;
                            c++;
                            
                        }
                    }
                    if (testr && testc) {
                        break;
                    }
                }
                tabc = new int[n];
                tabr = new int[n];
                testr=false;
                testc=false;
            }
            pw.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
        }
        pw.close();
        // TODO code application logic here
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
