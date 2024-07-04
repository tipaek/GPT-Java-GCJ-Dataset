import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        Utility.FastReader fr = new Utility.FastReader();
        int t, b;
        t = fr.nextInt();
        b = fr.nextInt();
        char[] arr = new char[b];
        while(t-- > 0){
            for(int i=1; i<= 10; ++i){
                System.out.println(i);
                System.out.flush();
                arr[i-1] = fr.next().charAt(0);
                if(arr[i-1] == 'N') return;
            }
            System.out.println(new String(arr));
        }
    }

    static class Utility {
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

        public static void main(String[] args) {
            FastReader s = new FastReader();
            int n = s.nextInt();
            int k = s.nextInt();
            int count = 0;
            while (n-- > 0) {
                int x = s.nextInt();
                if (x % k == 0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
