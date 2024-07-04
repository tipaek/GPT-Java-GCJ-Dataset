import java.io.*;
import java.util.*;

import static java.lang.System.*;

class CodeForces {

    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();

        for (int e = 0; e < t; e++) {
            int n = in.nextInt();

            Integer[][] arr = new Integer[n][n];

            for (int idx = 0; idx < n; idx++) {
                for (int jdx = 0; jdx < n; jdx++) {
                    arr[idx][jdx] = in.nextInt();
                }
            }

            int k = 0, r = 0, c = 0;

            for (int idx = 0; idx < n; idx++) {
                for (int jdx = 0; jdx < n; jdx++) {
                    if (idx == jdx) {
                        k += arr[idx][jdx];
                    }
                }
            }

            for (int idx = 0; idx < n; idx++) {
                if (!checker(arr[idx])) {
                    r++;
                }
            }

            for (int jdx  = 0; jdx < n; jdx++) {
                if (!checker( getColumn(arr, jdx))) {
                    c++;
                }
            }

            out.println("Case #" + (e + 1) + ": " + k + " " + r + " " + c);
        }

        out.close();
    }

    public static boolean checker(Integer[] arr) {
        Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));

        return (s.size() == arr.length);
    }

    public static Integer[] getColumn(Integer[][] array, int index){
        Integer[] column = new Integer[array[0].length];
        for(int i=0; i<column.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }

    public static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(in));
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
}