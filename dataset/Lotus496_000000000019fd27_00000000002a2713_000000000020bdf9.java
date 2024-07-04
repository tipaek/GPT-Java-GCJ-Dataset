import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    private static boolean less(int i, int j, int[] S, int[] E) {
        if (S[i] < S[j]) return true;
        if ((S[i] == S[j]) && (E[i] < E[j])) return true;
        return false;
    }

    private static boolean overlap(int i, int j, int[] S, int[] E) {
        if (less(i,j,S,E) && (E[i] > S[j])) return true;
        if ((!less(i,j,S,E)) && (E[j] > S[i])) return true;
        return false;
    }

    private static void sort(int[] intervals, int[] S, int[] E) {
        int n = intervals.length;
        for (int j = 1; j < n; j++) {
            int key = intervals[j];
            int i = j-1; 
            while ((i >= 0) && less(key,intervals[i],S,E)) {
                intervals[i+1] = intervals[i];
                i--;
            }
            intervals[i+1] = key;
        }
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            
            int n = scanner.nextInt();
            int[] S = new int[n];
            int[] E = new int[n];
            for (int i = 0; i < n; i++) { 
                S[i] = scanner.nextInt();
                E[i] = scanner.nextInt();
            }

            int[] intervals = new int[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = i;
            }
            sort(intervals,S,E);
            
            String result = "";
            char[] parents = new char[2];
            parents[0] = 'C';
            parents[1] = 'J';
            char[] assignments = new char[n];
            assignments[intervals[0]] = 'C';
            assignments[intervals[1]] = 'J';
            int last = 1;
            for (int i = 2; i < n; i++) {
                if (!overlap(intervals[i],intervals[i-1],S,E)) {
                    assignments[intervals[i]] = parents[last];
                } else if (!overlap(intervals[i],intervals[i-2],S,E)) {
                    last = 1 - last;
                    assignments[intervals[i]] = parents[last];
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            if ("".equals(result)) result = new String(assignments);
            System.out.println("Case #" + (k+1) + ": " + result); 
        }
                
    }
    

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

}
