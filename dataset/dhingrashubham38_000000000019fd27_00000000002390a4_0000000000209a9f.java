import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        Utility.FastReader fr = new Utility.FastReader();
        int t, curr_depth;
        t = fr.nextInt();
        String s;
        int test_num = 0;
        while(t-- > 0){
            curr_depth = 0;
            test_num++;
            s = fr.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); ++i){
                if(s.charAt(i) == '0'){
                    if(curr_depth == 0) sb.append('0');
                    else{
                        while(curr_depth > 0) {
                            sb.append(')');
                            curr_depth--;
                        }
                        sb.append('0');
                    }
                }
                else{
                    if(curr_depth == Character.getNumericValue(s.charAt(i))){
                        sb.append(s.charAt(i));
                    }
                    else{
                        if(curr_depth > Character.getNumericValue(s.charAt(i))){
                            while(curr_depth > Character.getNumericValue(s.charAt(i))){
                                curr_depth--;
                                sb.append(')');
                            }
                            sb.append(s.charAt(i));
                        }
                        else{
                            while(curr_depth < Character.getNumericValue(s.charAt(i))){
                                curr_depth++;
                                sb.append('(');
                            }
                            sb.append(s.charAt(i));
                        }
                    }
                }
            }
            while(curr_depth-- > 0) sb.append(')');
            System.out.println("Case #"+test_num+": "+sb);
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
