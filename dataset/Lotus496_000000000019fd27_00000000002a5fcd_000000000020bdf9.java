import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    private static boolean less(int index1, int index2, int[] S, int[] E) {
        int n = S.length;
        int value1 = -1;
        if (index1 >= n) { 
            value1 = E[index1 - n]; 
        } else {
            value1 = S[index1];
        }
        int value2 = -1;
        if (index2 >= n) { 
            value2 = E[index2 - n]; 
        } else {
            value2 = S[index2];
        }
        if (value1 < value2) return true;
        if (value1 == value2) return ((index1 >= n) && (index2 < n));
        return false;
    }

    private static void sort(int[] endpoints, int[] S, int[] E) {
        int n = endpoints.length;
        for (int j = 1; j < n; j++) {
            int key = endpoints[j];
            int i = j-1; 
            while ((i >= 0) && less(key,endpoints[i],S,E)) {
                endpoints[i+1] = endpoints[i];
                i--;
            }
            endpoints[i+1] = key;
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

            int[] endpoints = new int[2*n];
            for (int i = 0; i < endpoints.length; i++) {
                endpoints[i] = i;
            }
            sort(endpoints,S,E);
            char[] parents = new char[2];
            parents[0] = 'C';
            parents[1] = 'J';
            char[] assignments = new char[n];
            
            String result = "";
            int overlapCount = 0;
            boolean[] isFree = new boolean[2];
            isFree[0] = true;
            isFree[1] = true;
            boolean freeParent = 0;
            for (int i = 0; i < endpoints.length; i++) {
                if (endpoints[i] < n) {
                    overlapCount++;
                    if (overlapCount <= 2) {
                        if (isFree[0]) { 
                            freeParent = 0;
                        } else { 
                            freeParent = 1;
                        }
                        assignments[endpoints[i]] = parents[freeParent];
                    }
                } else {
                    overlapCount--;
                    if (assignments[endpoints[i] - n] == 'C') {
                        freeParent = 0;
                    } else {
                        freeParent = 1;
                    }
                }
                if (overlapCount > 2) {
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
