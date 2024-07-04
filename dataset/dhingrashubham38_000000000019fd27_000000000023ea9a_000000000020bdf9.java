import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    static int MAX = 1005;
    static class Pair{
        int x, y, idx;
        public Pair(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    static class ComparePair implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.x == o2.x)
                return o1.y - o2.y;
            return o1.x - o2.x;
        }
    }
    public static void main(String[] args) {
        Utility.FastReader fr = new Utility.FastReader();
        int t, n;
        Pair J, C;
        t = fr.nextInt();
        int x, y;
        int test_num = 0;
        while(t-- > 0){
            test_num++;
            J = null; C = null;
            boolean flag = false;
            n = fr.nextInt();
            Pair[] arr = new Pair[n];
            char[] result = new char[n];
            for(int i=0; i<n; ++i){
                x = fr.nextInt();
                y = fr.nextInt();
                arr[i] = new Pair(x, y, i);
            }
            Arrays.sort(arr, new ComparePair());
            for(int i=0; i<n; ++i){
                if(J == null || J.y <= arr[i].x){
                    J = arr[i];
                    result[arr[i].idx] = 'J';
                }
                else if(C == null || C.y <= arr[i].x){
                    C = arr[i];
                    result[arr[i].idx] = 'C';
                }
                else{
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("Case #"+test_num+": "+ new String(result));
            else
                System.out.println("Case #"+test_num+": "+"IMPOSSIBLE");
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
