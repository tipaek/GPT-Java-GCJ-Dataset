import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
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

    static class schedule {
        int starting, ending, index;

        schedule(int s, int e, int i) {
            starting = s;
            ending = e;
            index = i;
        }
    }

    public static void main(String[] args) {
        FastReader keyboard = new FastReader();
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++) {
            ArrayList<schedule> sch = new ArrayList<>();
            int schlen = keyboard.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < schlen; j++) {
                int a = keyboard.nextInt();
                int b = keyboard.nextInt();
                schedule S = new schedule(a, b, j );
                sch.add(S);
            }
            // now sort using a comparator
            Collections.sort(sch, Comparator.comparingInt(s -> s.starting));
            // now work out the output
            int cend = 0;
            int jend = 0;
            StringBuilder sb = new StringBuilder();
            sb.setLength(schlen);
            for (schedule S:sch)
            {
                if (S.starting >= cend)
                {
                    cend = S.ending;
                    sb.setCharAt(S.index,'C');
                }
                else if (S.starting >= jend)
                {
                    jend = S.ending;
                    sb.setCharAt(S.index, 'J');
                }
                else
                {
                    // big fail
                    cend = -1;
                    break;
                }
            }
            if (cend == -1)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
                System.out.println(sb.toString());
        }
    }
}
