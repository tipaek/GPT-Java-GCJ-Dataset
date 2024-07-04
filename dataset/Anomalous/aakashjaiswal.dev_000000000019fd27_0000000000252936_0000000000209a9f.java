import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        int caseNumber = 0;
        
        while (T-- > 0) {
            String str = in.next();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            
            boolean[] done = new boolean[arr.length];
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                pairs.add(new Pair(arr[i], i));
            }
            pairs.sort(Collections.reverseOrder());
            
            int[] start = new int[arr.length];
            int[] end = new int[arr.length];
            
            for (Pair pair : pairs) {
                if (done[pair.index]) continue;
                done[pair.index] = true;
                
                processRight(arr, done, end, pair);
                processLeft(arr, done, start, pair);
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < start[i]; j++) result.append('(');
                result.append(arr[i]);
                for (int j = 0; j < end[i]; j++) result.append(')');
            }
            
            System.out.println("Case #" + (++caseNumber) + ": " + result.toString());
        }
    }
    
    private static void processRight(int[] arr, boolean[] done, int[] end, Pair pair) {
        int max = pair.value;
        int rem = pair.value;
        int last = pair.index;
        
        for (int k = pair.index + 1; k < arr.length; k++) {
            if (arr[k] > max) {
                end[k - 1] += rem;
                rem = arr[k];
                max = arr[k];
                break;
            } else {
                if (arr[k] == max) {
                    last = k;
                    done[k] = true;
                } else {
                    end[k - 1] += rem - arr[k];
                    max = arr[k];
                    rem = arr[k];
                    done[k] = true;
                }
            }
            last = k;
        }
        
        if (rem > 0) {
            end[last] += rem;
        }
    }
    
    private static void processLeft(int[] arr, boolean[] done, int[] start, Pair pair) {
        int max = pair.value;
        int rem = pair.value;
        int last = pair.index;
        
        for (int k = pair.index - 1; k >= 0; k--) {
            if (arr[k] > max) {
                start[k + 1] += rem;
                rem = arr[k];
                max = arr[k];
                break;
            } else {
                if (arr[k] == max) {
                    last = k;
                    done[k] = true;
                } else {
                    start[k + 1] += rem - arr[k];
                    max = arr[k];
                    rem = arr[k];
                    done[k] = true;
                }
            }
            last = k;
        }
        
        if (rem > 0) {
            start[last] += rem;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(other.value, this.value);
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
}