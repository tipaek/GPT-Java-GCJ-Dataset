import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static InputReader in;
    private static PrintWriter out;

    private static int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        return in.nextInt();
    }

    public static void main(String[] args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int T, B;
        T = in.nextInt();
        B = in.nextInt();

        for (int cs = 1; cs <= T; ++cs) {
            int[] ans = new int[B];
            int l = 0, r = B - 1;

            int same = -1, diff = -1;
            for (int i = 1; l <= r; i += 2) {
                if (i % 10 == 1) {
                    if (same != -1) {
                        if (ans[same] != ask(same)) {
                            for (int a = 0, b = B - 1; a < l; ++a, --b) {
                                ans[a] ^= 1;
                                ans[b] ^= 1;
                            }
                        }
                    } else {
                        ask(0);
                    }
                    if (diff != -1) {
                        if (ans[diff] != ask(diff)) {
                            for (int a = 0, b = B - 1; a < l; ++a, --b) {
                                ans[a] ^= 1;
                                ans[b] ^= 1;
                            }
                        }
                    } else {
                        ask(0);
                    }
                    continue;
                }
                ans[l] = ask(l);
                ans[r] = ask(r);
                if (same == -1 && ans[l] == ans[r]) same = l;
                if (diff == -1 && ans[l] != ans[r]) diff = l;
                ++l;
                --r;
            }

            for (int i = 0; i < B; ++i) {
                out.print(ans[i]);
            }
            out.print('\n');
            out.flush();
        }
    }

    static class InputReader{
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next(){
            while (tokenizer == null || !tokenizer.hasMoreTokens()){
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger(){
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal(){
            return new BigDecimal(next());
        }
    }
}
