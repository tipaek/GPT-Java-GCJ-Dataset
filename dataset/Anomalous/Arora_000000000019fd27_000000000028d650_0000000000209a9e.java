import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        
        if (b == 1) {
            for (int p1 = 0; p1 < t; p1++) {
                char[] ch = new char[10];
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    ch[i - 1] = sc.next().charAt(0);
                }
                System.out.println(String.valueOf(ch));
                char ch1 = sc.next().charAt(0);
                if (ch1 == 'N') {
                    return;
                }
            }
        } else {
            System.out.println("1110110000");
            char ch1 = sc.next().charAt(0);
            if (ch1 == 'N') {
                return;
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}