import java.io.*;
import java.util.*;

/**
 * ParentingPartneringReturns
 * Author: av-sharma
 */

public class Solution {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = fr.nextInt();
            int[] start = new int[n];
            int[] finish = new int[n];
            int[] assigned = new int[n]; // -1 = NONE, 0 = C, 1 = J
            int[] indices = new int[n];
            
            for (int i = 0; i < n; i++) {
                start[i] = fr.nextInt();
                finish[i] = fr.nextInt();
                indices[i] = i;
            }
            
            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++) {
                order[i] = i;
            }
            
            Arrays.sort(order, Comparator.comparingInt(i -> start[i]));
            
            boolean isPossible = true;
            int cFree = 0, jFree = 0;
            
            for (int i = 0; i < n; i++) {
                int idx = order[i];
                if (start[idx] >= cFree) {
                    assigned[idx] = 0;
                    cFree = finish[idx];
                } else if (start[idx] >= jFree) {
                    assigned[idx] = 1;
                    jFree = finish[idx];
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("CASE #" + t + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(assigned[i] == 0 ? 'C' : 'J');
                }
                System.out.println();
            }
        }
    }
}

// FastReader Util Class
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
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
}