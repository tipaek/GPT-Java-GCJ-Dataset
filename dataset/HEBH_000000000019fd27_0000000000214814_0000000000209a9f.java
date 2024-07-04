
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
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String ch = sc.nextLine();
            String[] tab = ch.split("");
            int[] tabn = new int[tab.length];
            for (int i = 0; i < tab.length; i++) {
                tabn[i] = Integer.parseInt(tab[i]);
            }
            String res = "";
            for (int i = 0; i < tabn[0]; i++) {
                res = res.concat("(");
            }
            int av = tabn[0];
            int ap = 0;
            res = res.concat(Integer.toString(tabn[0]));
            for (int i = 1; i < tabn.length; i++) {
                if (tabn[i] == 0) {
                    for (int j = 0; j < (av - ap); j++) {
                        res = res.concat(")");
                    }
                    av = 0;
                    ap = 0;
                    
                }else if(tabn[i]>tabn[i-1]){
                    int x=tabn[i]-tabn[i-1];
                    for (int j = 0; j < x; j++) {
                        res = res.concat("("); 
                    }
                    av+=x;
                }else if(tabn[i]<tabn[i-1]){
                    int x=tabn[i-1]-tabn[i];
                    for (int j = 0; j < x; j++) {
                        res = res.concat(")"); 
                    }
                    ap+=x;
                } 
                res = res.concat(Integer.toString(tabn[i]));

            }
            for (int j = 0; j < (av - ap); j++) {
                        res = res.concat(")");
                    }

            pw.println("Case #"+(t+1)+": "+res);
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
