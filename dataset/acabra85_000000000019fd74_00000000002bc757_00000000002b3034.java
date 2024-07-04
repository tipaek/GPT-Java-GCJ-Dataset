 
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
        for (int i = 0; i < testCases; ++i) {
            System.out.print(String.format(RESULT, i>0?"\n":"", i+1, result(help)));
            help.out.flush();
        }
        help.close();
    }

    private String result(Help help) throws IOException {
        int n = help.nInt();
        String[] p = new String[n];
        for (int i = 0; i < n; ++i) {
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
                for (int i = 1; i < p.length; ++i) {
                    pat = match(pat, p[i].substring(1), false);
                    if (null == pat) {
                        return "*";
                    }
                }
                return pat;
            }
        } else if (onlyOneWildCard(p[0], starIdx)){ //* only one wildcard
            Parts part1 = Parts.of(p[0], starIdx);
            Parts part2;
            for (int i = 1; i < p.length; ++i) {
                part2 = Parts.of(p[i], p[i].indexOf('*'));
                String s1 = match(part1.p1, part2.p1, true);
                if (null == s1) return "*";
                String s2 = match(part1.p2, part2.p2, false);
                if (null == s2) return "*";
                part1 = Parts.of(s1, s2);
            }
            return part1.toString();
        }//more wildcards
        return "*";
    }

    private boolean onlyOneWildCard(String s, int starIdx) {
        return s.substring(starIdx+1).indexOf('*') == -1;
    }

    static class Parts{
        final String p1, p2;

        Parts(String p1, String p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return p1+p2;
        }

        public static Parts of(String s, int starIdx) {
            StringBuilder p1 = new StringBuilder();
            StringBuilder p2 = new StringBuilder();
            for (int i = 0; i < starIdx; i++) {
                p1.append(s.charAt(i));
            }
            for (int i = starIdx +1; i < s.length(); i++) {
                p2.append(s.charAt(i));
            }
            return new Parts(p1.toString(), p2.toString());
        }

        public static Parts of(String s1, String s2) {
            return new Parts(s1, s2);
        }
    }

    private String match(String sub1, String sub2, boolean starts) {
        if (sub1.equals(sub2)) return sub1;
        if (sub1.length() == sub2.length()) return null;
        String large = sub1.length() > sub2.length() ? sub1 : sub2;
        String small = sub1 == large ? sub2 : sub1;
        if (starts) {
            return large.startsWith(small) ? large : null;
        }
        return large.endsWith(small) ? large : null;
    }
}