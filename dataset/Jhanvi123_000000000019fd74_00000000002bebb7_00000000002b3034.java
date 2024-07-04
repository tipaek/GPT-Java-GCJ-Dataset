import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {

        int x = sc.nextInt();
        for (int j = 1; j <=x; j++) {
            String res = solve(sc.nextInt());
            System.out.println("Case #" + j + ": " + res);


        }
    }


    static String solve(int Z) {
        String arr[] = new String[Z];
        int max = 0;
        int pos = -1;
        boolean flag = true;
        for (int j = 0; j < N; j++) {
            arr[j] = sc.nextLine();
            if (j >= 1)
                if (max < arr[j].length()) {
                    max = arr[j].length();
                    pos = j;
                }

        }

        for (int j = 0; j < Z; j++) {
            String sub = arr[j].substring(1);
            if (flag && !arr[pos].contains(sub)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return arr[pos].substring(1);

        }
        return "*";


    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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




