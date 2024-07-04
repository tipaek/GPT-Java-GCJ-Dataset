import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

    public void solve() {
        int T = nextInt();
        int index = 1;

        while (T-- > 0) {
            String str = nextString();
            StringBuilder buffer = new StringBuilder("");
            int length = str.length();
            int lastNo = str.charAt(length - 1) - '0';

            for (int i = 0; i < lastNo; i++) {
                buffer.append(")");
            }

            buffer.append(lastNo);

            for (int itr = str.length() - 2; itr >= 0; itr --) {
                if (lastNo == (str.charAt(itr) - '0')) {
                    buffer.append(str.charAt(itr));
                } else {
                    int diff = lastNo - (str.charAt(itr) - '0');

                    if (diff > 0) {
                        for (int i = 0; i < diff; i++) {
                            buffer.append("(");
                        }
                    } else {
                        diff =- diff;
                        for (int i = 0; i < diff; i++) {
                            buffer.append(")");
                        }
                    }

                    lastNo = str.charAt(itr) - '0';

                    buffer.append(lastNo);
                }
            }

            for (int i = 0; i < lastNo; i++) {
                buffer.append("(");
            }

            System.out.println("Case #"+index+": "+buffer.reverse());
            index++;
        }
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    static final Random rng = new Random();

    static int rand(int l, int r) {
        return l + rng.nextInt(r - l + 1);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}

    