import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bhavy seth
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        parencdjam solver = new parencdjam();
        solver.solve(1, in, out);
        out.close();
    }

    static class parencdjam {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            int test = 0;
            while (t-- > 0) {
                test++;
                String s = sc.nextLine();
                int n = s.length();
                StringBuilder left = new StringBuilder();
                StringBuilder ans = new StringBuilder();
                int pre = Character.getNumericValue(s.charAt(0));
                int preindx = pre;
                for (int i = 0; i < Character.getNumericValue(s.charAt(0)); i++) {
                    left.append('(');
                }
                ans.append(left);
                ans.append(s.charAt(0));
                //  for(int i=0;i<pre;i++) {
                //    ans.append(')');
                //}
                int remainingopen = pre;
                for (int i = 1; i < n; i++) {
                    int curr = Character.getNumericValue(s.charAt(i));
                    if (curr <= remainingopen) {
                        int dif = pre - curr;
                        for (int j = 0; j < dif; j++) {
                            ans.append(')');
                        }
                        ans.append(s.charAt(i));
                        remainingopen = curr;
                        pre = curr;

                    } else {
                        // for(int j=0;j<pre;j++){
                        //   ans.append(')');
                        //}
                        for (int j = 0; j < curr - remainingopen; j++) {
                            ans.append('(');
                        }
                        ans.append(s.charAt(i));
                        remainingopen = curr;
                        pre = curr;
                    }
                }
                for (int i = 0; i < remainingopen; i++) {
                    ans.append(')');
                }
                out.println("Case #" + test + ": " + ans);
            }
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
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

