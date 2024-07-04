

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {

        int tc = sc.nextInt();
        while(tc-- >0){
            String res = find_pattern(sc.nextInt());
            System.out.println("Case #" + tc + ": " + res);


        }
    }


    static String find_pattern(int N) {
        String arr[] = new String[N];
        int max_val = 0;
        int index = -1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            if (i >= 1)
                if (max_val < arr[i].length()) {
                    max_val = arr[i].length();
                    index = i;
                }

        }

        for (int i = 0; i < N; i++) {
            String ss = arr[i].substring(1);
            if (flag && !arr[index].contains(ss)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return arr[index].substring(1);

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


