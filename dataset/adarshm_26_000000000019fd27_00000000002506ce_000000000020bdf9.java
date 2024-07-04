import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        int n, start, end, cur, curPart;
        int[] tline;
        ArrayList<Character> out = new ArrayList<>();
        boolean[] ins;
        boolean impos;
        for (int i = 1; i <= t; i++) {
            n = in.nextInt();
            cur = 0;
            out.clear();
            impos = false;
            tline = new int[1441];
            ins = new boolean[1441];
            for (int j = 1; j <= n; j++) {
                start = in.nextInt();
                end = in.nextInt();
                tline[start] += 1;
                ins[start] = true;
                tline[end] -= 1;
            }
            for (int j = 0; j < 1441; j++) {
                if(cur + tline[j] > 2) {
                    impos = true;
                    break;
                }
                if(ins[j]) {
                    if(cur == 1 && tline[j] != 0) {
                        out.add('C');
                    } else {
                        out.add('J');
                    }
                }
                cur += tline[j];
            }
            if(impos) pw.println("Case #" + i + ": IMPOSSIBLE");
            else {
                pw.print("Case #" + i + ": ");
                for (Character character : out) pw.print(character);
                pw.println();
            }
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
