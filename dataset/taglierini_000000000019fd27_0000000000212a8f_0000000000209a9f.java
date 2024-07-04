import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();

        int T = scanner.nextInt();

        int cs = 1;
        // char[] op, cl;
        // op = new char[105]; cl = new char[105];
        while (T-- != 0) {
            char[] str = scanner.nextLine().toCharArray();
            // System.out.println(str);
            int nop = 0;
            System.out.print("Case #" + cs + ": "); cs++;
            for (int i = 0; i < str.length; i++) {
                if ((str[i] - 48) - nop > 0) {
                    int it = (str[i] - 48) - nop;
                    for (int j = 0; j < it; j++) {
                        System.out.print('(');
                        nop++;
                    }
                }
                System.out.print(str[i]);
                if (i < str.length - 1) {
                    if (str[i + 1] < str[i]) {
                        for (int j = 0; j < str[i] - str[i + 1]; j++) {
                            System.out.print(')');
                            nop--;
                        }
                    }
                } else {
                    while (nop > 0) {
                        System.out.print(')');
                        nop--;
                    }
                }
            }
            System.out.println();
        }
    }

    private static class FastScanner {
        private BufferedReader br;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public int nextInt() throws IOException { return Integer.parseInt(br.readLine()); }
        public String nextLine() throws IOException { return br.readLine(); }
    }
}
