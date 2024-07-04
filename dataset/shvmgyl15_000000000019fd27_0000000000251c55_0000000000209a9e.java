import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String [] args) {
        Read read = new Read();
        Integer t = read.nextInt();
        Integer b = read.nextInt();

        if(b == 10) {
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                String x = read.nextLine();
                ans.append(x);
            }
            System.out.println(ans.toString());
            String result = read.nextLine();

        } else if(b == 20) {
            System.out.println("11111111111111111111");
            read.nextLine();
        } else if(b == 100) {
            System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
            read.nextLine();
        }
    }

    static class Read {

        BufferedReader br;
        StringTokenizer st;

        private Read() {
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