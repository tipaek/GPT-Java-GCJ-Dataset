import java.util.*;
import java.io.*;

//// CODE JAM 2020


class Solution{ 

   
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing solution here. -------------------------------------
        int testcase = sc.nextInt(); // test case
        int [] k = new int [testcase];
        int [] r = new int [testcase];
        int [] c = new int [testcase];

        for (int i = 0; i < testcase; i++) {
            int N = sc.nextInt(); // size of matrix NxN
            int [][] matrix = new int[N][N];
            Hashtable<Integer, Boolean> table_row = new Hashtable<>();
            Hashtable<Integer, Boolean> table_col = new Hashtable<>();
            int countRepRow = 0;
            int countRepCol = 0;

            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < matrix[j].length; j2++) {
                    matrix[j][j2] = sc.nextInt();
                }
            }


            for (int j = 0; j < N; j++) {
                k[i] += matrix[j][j];
                for (int l = 0; l < N; l++) {
                    if (!table_row.containsKey(matrix[j][l])) {
                        table_row.put(matrix[j][l], true);
                    }else{
                        r[i]++;
                        table_row.clear();
                        break;
                    }
                    if (l == N-1){
                        table_row.clear();
                    }
                    // if (!table_col.containsKey(matrix[l][j])) {
                    //     table_col.put(matrix[l][j], true);
                    // }
                    // else{
                    //     countRepCol++;
                    // }
                }
               // table_row.clear();
                //table_col.clear();
                // if (countRepRow > 1) {
                //     r[i]++;
                // }
                // if (countRepCol > 1) {
                //     c[i]++;
                // }
            }
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (!table_col.containsKey(matrix[l][j])) {
                        table_col.put(matrix[l][j], true);
                    }
                    else{
                        c[i]++;
                        table_col.clear();
                        break;
                    }
                    if (l == N-1){
                        table_col.clear();
                    }
                }
                // table_col.clear();
                // if (countRepCol > 1) {
                //     c[i]++;
                // }
            }
        }
        for (int i = 0; i < testcase; i++) {
            System.out.println("Case #" + (i+1) + ": " + k[i] + " " + r[i] + " " +c[i]);
        }
       
        /*
         * int n = sc.nextint(); // read input as integer 
         * int k = sc.nextint(); //read input as int 
         * double d = sc.nextDouble(); // read input as double 
         * String str = sc.next(); // read input as String 
         * String s = sc.nextLine(); // read whole line as String
         * int result = 3*n; out.println(result); // print via PrintWriter
         */

        // Stop writing your solution here. -------------------------------------
        out.close();
    }
    // -----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    // --------------------------------------------------------
}