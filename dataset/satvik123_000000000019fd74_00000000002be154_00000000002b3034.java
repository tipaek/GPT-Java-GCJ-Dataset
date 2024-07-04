import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc1 = new FastReader();

    public static void main(String[] args) {

        int t1 = sc1.nextInt();
        for (int i = 1; i <=t1; i++) {
            String res = solving(sc1.nextInt());
            System.out.println("Case #" + i + ": " + res);


        }
    }


    static String solving(int n) {
        String arr[] = new String[n];
        int max = 0;
        int p = -1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            arr[i] = sc1.nextLine();
            if (i >= 1)
                if (max < arr[i].length()) {
                    max = arr[i].length();
                    p = i;
                }

        }

        for (int i = 0; i < n; i++) {
            String sub = arr[i].substring(1);
            if (flag && !arr[p].contains(sub)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return arr[p].substring(1);

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