import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int T = io.nextInt();
        for (int i = 1; i <= T; ++i) {
            solve(io, i);
        }
        io.close();
    }

    private static void solve(Kattio io, int t) {
        int N = io.nextInt();
        int D = io.nextInt();
        int ans;
        if (D == 2) ans = solve2(N, t, io);
        else ans = solve3(N, t, io);
        io.println("Case #" + t + ": " + ans);
    }
    
    private static int solve2(int N, int t, Kattio io) {
        Set<Long> slices = new HashSet<>();
        boolean canZero = false;
        for (int i = 0; i < N; ++i) {
            long slice = io.nextLong();
            if (slices.contains(slice)) {
                canZero = true;
            }
            slices.add(slice);
        }
        return canZero ? 0 : 1;
    }

    private static int solve3(int N, int t, Kattio io) {
        Map<Long, Integer> freq = new HashMap<>();
        long[] slices = new long[N];
        for (int i = 0; i < N; ++i) {
            long slice = io.nextLong();
            freq.put(slice, freq.getOrDefault(slice, 0) + 1);
            slices[i] = slice;
        }
        boolean has3 = false;
        boolean has2 = false;
        long size = -1;
        //System.out.println(freq);
        for (long s : slices) {
            int f = freq.get(s);
            if (f == 3) {
                has3 = true;
                break;
            }
            if (f == 2) {
                has2 = true;
                size = s;
            }
        }
        if (has3) return 0;
        else if (has2) {
            for (long s : slices) {
                if (s > size) {
                    return 1;
                }
            }
            for (int i = 0; i < N; ++i) {
                long curr = slices[i] / 2;
                for (int k = 0; k < N; ++k) {
                    if (k == i) continue;
                    long comp = slices[k];
                    if (comp == curr) {
                        return 1;
                    }
                }
            }
            return 2;
        } else {
            for (int i = 0; i < N; ++i) {
                long curr = slices[i] / 2;
                for (int k = 0; k < N; ++k) {
                    if (k == i) continue;
                    long comp = slices[k];
                    if (comp == curr) {
                        return 1;
                    }
                }
            }
            return 2;
        }
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public String next() {
        return nextToken();
    }

    public String nextLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
