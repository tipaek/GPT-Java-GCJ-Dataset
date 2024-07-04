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
            Arrays.sort(arr, Comparator.comparingInt((Pair p) -> p.start).thenComparingInt(p -> p.end));
            
            boolean isImpossible = false;
            Map<Pair, Character> assignment = new HashMap<>();
            int maxC = arr[0].end;
            int maxJ = arr[1].end;
            assignment.put(arr[0], 'C');
            assignment.put(arr[1], 'J');
            
            for (int i = 2; i < n; i++) {
                int st = arr[i].start;
                int en = arr[i].end;
                if (st < maxC && st < maxJ) {
                    isImpossible = true;
                    break;
                } else if (st >= maxC) {
                    assignment.put(arr[i], 'C');
                    maxC = Math.max(maxC, en);
                } else if (st >= maxJ) {
                    assignment.put(arr[i], 'J');
                    maxJ = Math.max(maxJ, en);
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Pair p : dup) {
                    result.append(assignment.get(p));
                }
            }
            System.out.println("Case #" + test + ": " + result);
        }
    }
}

class Pair {
    int start;
    int end;
    
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
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