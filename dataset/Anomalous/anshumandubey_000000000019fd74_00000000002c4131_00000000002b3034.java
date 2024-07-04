import java.io.*;

public class Solution {
    static Printer out;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        out = new Printer();
        int testCases = Integer.parseInt(sc.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(sc.readLine());
            String[] lPatterns = new String[n * 10000];
            String[] rPatterns = new String[n * 10000];
            String[] uPatterns = new String[n * 10000];
            String[] excess = new String[n];
            int l = 0, r = 0, u = 0, e = 0;
            int[] totLen = new int[4];
            String[] maxStr = new String[4];

            for (int i = 0; i < n; i++) {
                String pattern = sc.readLine();
                int len = pattern.length();
                StringBuilder p = new StringBuilder(len);
                boolean lAst = pattern.charAt(0) == '*';

                for (int j = 0; j < len; j++) {
                    if (pattern.charAt(j) == '*' && j != 0) {
                        p.append('*');
                        if (lAst) {
                            uPatterns[u++] = p.toString();
                            if (len > totLen[0]) {
                                totLen[0] = p.length();
                                maxStr[0] = p.toString();
                            }
                        } else {
                            lPatterns[l++] = p.toString();
                            if (len > totLen[1]) {
                                totLen[1] = p.length();
                                maxStr[1] = p.toString();
                            }
                        }
                        p = new StringBuilder(len);
                        p.append('*');
                        while (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') j++;
                        lAst = true;
                    } else {
                        p.append(pattern.charAt(j));
                    }
                }
                if (pattern.charAt(pattern.length() - 1) != '*') {
                    rPatterns[r++] = p.toString();
                    if (len > totLen[2]) {
                        totLen[2] = p.length();
                        maxStr[2] = p.toString();
                    }
                }
            }

            String resultPattern = patternFinder(lPatterns, rPatterns, uPatterns, totLen, maxStr, l, r, u);
            out.println("Case #" + (t + 1) + ": " + (resultPattern.isEmpty() ? "*" : resultPattern));
        }

        out.close();
    }

    static String patternFinder(String[] lPatterns, String[] rPatterns, String[] uPatterns, int[] totLen, String[] maxStr, int l, int r, int u) {
        StringBuilder[] output = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            output[i] = new StringBuilder("");
        }

        if (totLen[1] != 0) {
            output[0] = new StringBuilder(maxStr[1].substring(0, maxStr[1].length() - 1));
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < lPatterns[i].length() - 1; j++) {
                    if (output[0].charAt(j) != lPatterns[i].charAt(j)) return "*";
                }
            }
        }

        if (totLen[2] != 0) {
            output[1] = new StringBuilder(maxStr[2].substring(1));
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < rPatterns[i].length() - 1; j++) {
                    if (output[1].charAt(output[1].length() - j - 1) != rPatterns[i].charAt(rPatterns[i].length() - j - 1)) return "*";
                }
            }
        }

        if (totLen[0] != 0) {
            output[2] = new StringBuilder(maxStr[0].length() * 5000);
            for (int i = 0; i < u; i++) {
                output[2].append(uPatterns[i].substring(1, uPatterns[i].length() - 1));
            }
        }

        output[2].append(output[1]);
        return output[0].toString() + output[2].toString();
    }

    static class Printer {
        private final OutputStream outputStream;

        public Printer() {
            outputStream = new BufferedOutputStream(System.out);
        }

        public void print(Object object) throws IOException {
            outputStream.write(String.valueOf(object).getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
        }
    }
}