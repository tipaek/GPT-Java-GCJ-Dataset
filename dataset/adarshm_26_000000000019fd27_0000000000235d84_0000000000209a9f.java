import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        String s;
        int dpt, val, tmp;
        ArrayList<Character> out = new ArrayList<>();
        for (int z = 1; z <= t; z++) {
            s = in.nextLine();
            dpt = 0;
            out.clear();
            for (int i = 0; i < s.length(); i++) {
                val = s.charAt(i) - '0';
                if(val > dpt) {
                    for (int j = 0; j < val - dpt; j++)
                        out.add('(');
                    dpt += (val - dpt);
                }
                out.add(s.charAt(i));
                if(i < s.length() - 1) {
                    tmp = s.charAt(i + 1) - '0';
                    if (tmp < val) {
                        for (int j = 0; j < dpt - tmp; j++)
                            out.add(')');
                        dpt -= (dpt - tmp);
                    }
                } else {
                    for (int j = 0; j < dpt; j++)
                        out.add(')');
                    dpt -= dpt;
                }
            }
            pw.print("Case #" + z + ": ");
            for (int i = 0; i < out.size(); i++)
                pw.print(out.get(i));
            pw.println();
        }
        pw.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = null;
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
