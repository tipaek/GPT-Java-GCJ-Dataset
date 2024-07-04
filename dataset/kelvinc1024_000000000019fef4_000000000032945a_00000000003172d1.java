import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        int tc = scan.nextInt();
        for (int i = 0; i < tc; i++) {
            out.print("Case #" + (i + 1) + ": ");
            solve();
        }
        out.close();
    }

    private static void solve() {
        int n = scan.nextInt();
        int d = scan.nextInt();
        long[] slices = new long[n];
        for (int i = 0; i < n; i++) slices[i] = scan.nextLong();
        if (d == 2) {
            Set<Long> set = new HashSet<>();
            for (long s : slices) {
                if (set.contains(s)) {
                    out.println(0);
                    return;
                }
                set.add(s);
            }
            out.println(1);
            return;
        } else if (d == 3) {
            TreeMap<Long, Integer> freqMap = new TreeMap<>();
            for (long s : slices) {
                freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
                if (freqMap.get(s) == 3) {
                    out.println(0);
                    return;
                }
            }
            for (long s : slices) {
                if (freqMap.get(s) == 2) {
                    if (freqMap.lowerEntry(s) != null) {
                        out.println(1);
                        return;
                    }
                }
                if (s % 2 == 0 && freqMap.containsKey(s / 2)) {
                    out.println(1);
                    return;
                }
            }
        }
        out.println(2);

    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static MyScanner scan = new MyScanner();

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
//--------------------------------------------------------

}