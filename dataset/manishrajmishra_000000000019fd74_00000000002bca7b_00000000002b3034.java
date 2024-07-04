import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 1; i <=t; i++) {
            String result = solution(sc.nextInt());
            System.out.println("Case #" + i + ": " + result);


        }
    }


    static String solution(int N) {
        String str[] = new String[N];
        int maximum = 0;
        int position = -1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();
            if (i >= 1)
                if (maximum < str[i].length()) {
                    maximum = str[i].length();
                    position = i;
                }

        }

        for (int i = 0; i < N; i++) {
            String sub = str[i].substring(1);
            if (flag && !str[position].contains(sub)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return str[position].substring(1);

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