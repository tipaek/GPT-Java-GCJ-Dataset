import java.io.*;
import java.util.*;

class Solution { 
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
    
    public static boolean overlap(int i, int[] si, int[] ei) {
        int n = si.length; 
        for (int j = 0; j < n; j++) {
            if ((si[i] > si[j] && si[i] < ei[j]) || (ei[i] > si[j] && ei[i] < ei[j])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int T = input.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = input.nextInt();
            int[] si = new int[n];
            int[] ei = new int[n];
            List<Integer> c = new ArrayList<>();
            List<Integer> j = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                si[i] = input.nextInt();
                ei[i] = input.nextInt();
            }
            
            StringBuilder as = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (overlap(i, si, ei)) {
                    as.append("C");
                    c.add(i);
                } else {
                    as.append("J"); 
                    j.add(i);
                }
            }

            if (checkOverlap(c, si, ei) || checkOverlap(j, si, ei)) {
                as = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + as.toString());
        }
    }

    private static boolean checkOverlap(List<Integer> list, int[] si, int[] ei) {
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                if (i != k && ((si[list.get(i)] > si[list.get(k)] && si[list.get(i)] < ei[list.get(k)]) ||
                               (ei[list.get(i)] > si[list.get(k)] && ei[list.get(i)] < ei[list.get(k)]))) {
                    return true;
                }
            }
        }
        return false;
    }
}