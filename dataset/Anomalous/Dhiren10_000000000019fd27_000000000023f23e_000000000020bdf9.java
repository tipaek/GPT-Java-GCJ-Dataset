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
            
            boolean isPossible = true;
            Map<Pair, Character> assignmentMap = new HashMap<>();
            int maxC = arr[0].end;
            int maxJ = arr[1].end;
            assignmentMap.put(arr[0], 'C');
            assignmentMap.put(arr[1], 'J');
            
            for (int i = 2; i < n; i++) {
                int st = arr[i].start;
                int en = arr[i].end;
                if (st >= maxC) {
                    assignmentMap.put(arr[i], 'C');
                    maxC = en;
                } else if (st >= maxJ) {
                    assignmentMap.put(arr[i], 'J');
                    maxJ = en;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            String result = isPossible && assignmentMap.size() == n ? constructResultString(dup, assignmentMap) : "IMPOSSIBLE";
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String constructResultString(Pair[] dup, Map<Pair, Character> assignmentMap) {
        StringBuilder result = new StringBuilder();
        for (Pair p : dup) {
            result.append(assignmentMap.get(p));
        }
        return result.toString();
    }

    static class Pair {
        int start;
        int end;

        Pair(int s, int e) {
            start = s;
            end = e;
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

    static class FastReader {
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
}