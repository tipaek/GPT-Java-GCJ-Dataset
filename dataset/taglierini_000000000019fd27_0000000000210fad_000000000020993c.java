import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();

        int T = scanner.nextInt();

        int cs = 1;
        int[][] m = new int[100][];
        while (T-- != 0) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                m[i] = scanner.nextIntArray();
            }
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += m[i][i];
            }
            int r = 0;
            HashSet<Integer> s = new HashSet <>();
            for (int i = 0; i < n; i++) {
                s.clear();
                for (int j = 0; j < n; j++) {
                    if (s.contains(m[i][j])) {
                        r++;
                        break;
                    }
                    s.add(m[i][j]);
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                s.clear();
                for (int j = 0; j < n; j++) {
                    if (s.contains(m[j][i])) {
                        c++;
                        break;
                    }
                    s.add(m[j][i]);
                }
            }
            System.out.println("Case #" + cs + ": " + t + " " + r + " " + c);
        
            cs++;
        }
    }

    private static class FastScanner {
        private BufferedReader br;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public int[] nextIntArray() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            int[] array = new int[strings.length];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(strings[i]);
            return array;
        }
        public int nextInt() throws IOException { return Integer.parseInt(br.readLine()); }
    }
}
