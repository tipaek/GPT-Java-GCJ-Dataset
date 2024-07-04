import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            Pair[] arr = new Pair[n];
            Pair[] dup = new Pair[n];
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                arr[i] = new Pair(s, e);
                dup[i] = new Pair(s, e);
            }
            Arrays.sort(arr, (p1, p2) -> {
                if (p1.end != p2.end) {
                    return p1.end - p2.end;
                } else {
                    return p1.start - p2.start;
                }
            });

            boolean isImpossible = false;
            Map<Pair, Character> assignedTasks = new HashMap<>();
            int maxC = 0, maxJ = 0;
            StringBuilder result = new StringBuilder();

            for (Pair p : arr) {
                if (p.start >= maxC) {
                    assignedTasks.put(p, 'C');
                    maxC = p.end;
                } else if (p.start >= maxJ) {
                    assignedTasks.put(p, 'J');
                    maxJ = p.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Pair p : dup) {
                    result.append(assignedTasks.get(p));
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }
    }
}

class Pair {
    int start, end;

    Pair(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return start == pair.start && end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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