import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 1; i <=t; i++) {
            String res = print(sc.nextInt());
            System.out.println("Case #" + i + ": " + res);


        }
    }


    static String print(int n) {
        String a[] = new String[n];
        int max = 0;
        int pos = -1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
            if (i >= 1)
                if (max < a[i].length()) {
                    max = a[i].length();
                    pos = i;
                }

        }

for(int l=0;l<20;l++)
{
    
}
        for (int i = 0; i < n; i++) {
            String s2 = a[i].substring(1);
            if (flag && !a[pos].contains(s2)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return a[pos].substring(1);

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