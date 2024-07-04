 
import java.io.*;
import java.util.StringTokenizer;

 class Solution {
        private final Help help;
        static class Help {
            final BufferedReader bf;final PrintWriter out;StringTokenizer tokenizer;
            public Help(BufferedReader bf, PrintWriter out) {this.bf = bf;this.out = out;}
            public int nInt() throws IOException {return Integer.parseInt(next());}
            public long nLong() throws IOException {return Long.parseLong(next());}
            public double nDouble() throws IOException {return Double.parseDouble(next());}
            String next() throws IOException {while (tokenizer == null || !tokenizer.hasMoreTokens()) {tokenizer = new StringTokenizer(bf.readLine());}return tokenizer.nextToken();}
            public void close() throws IOException {bf.close();out.flush();}
        }
        public Solution(InputStream in, OutputStreamWriter iOut) {this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));}


        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }
        private final static String RESULT = "%sCase #%d: %s";
        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }
        public void read() throws Exception {
            int testCases = help.nInt();
            for (int i = 0; i < testCases; i++) {
                System.out.print(String.format(RESULT, i>0?"\n":"", i+1, result(help)));
                help.out.flush();
            }
            help.close();
        }

        private String result(Help help) throws IOException {
            int n = help.nInt();
            String[] p = new String[n];
            for (int i = 0; i < n; i++) {
                p[i] = help.next();
            }
            return solve(p, p[0].indexOf('*'));
        }

        private String solve(String[] p, int starIdx) {
            if (starIdx == 0) {
                if (p.length == 1) {
                    return p[0].substring(1);
                } else {
                    String pat = p[0].substring(1);
                    for (int i = 1; i < p.length - 1; i++) {
                        pat = match(pat, p[i].substring(1));
                        if (null == pat) {
                            return "*";
                        }
                    }
                    return pat;
                }
            }
            return "*";
        }

        private String match(String sub1, String sub2) {
            return sub1.contains(sub2) || sub2.contains(sub1) ? (sub1.length()>sub2.length() ? sub1 : sub2) : null;
        }
    }