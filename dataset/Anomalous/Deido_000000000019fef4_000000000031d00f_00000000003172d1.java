import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        
        for (int tc = 1; tc <= t; tc++) {
            int n = reader.nextInt();
            int d = reader.nextInt();
            long[] a = reader.nextLongArray(n);
            
            if (n == 1) {
                System.out.println("Case #" + tc + ": " + (d - 1));
                continue;
            }
            
            TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
            for (long ai : a) {
                frequencyMap.put(ai, frequencyMap.getOrDefault(ai, 0) + 1);
            }
            
            int minK = Integer.MAX_VALUE;
            
            for (long size : frequencyMap.keySet()) {
                int k = 0;
                int remaining = d - frequencyMap.get(size);
                
                for (long largerSize : frequencyMap.tailMap(size + 1).keySet()) {
                    for (int i = 0; i < frequencyMap.get(largerSize) && remaining > 0; i++) {
                        if (largerSize % size != 0) continue;
                        
                        long quotient = largerSize / size;
                        if (quotient > remaining) {
                            k += remaining;
                            remaining = 0;
                        } else {
                            k += quotient - 1;
                            remaining -= quotient;
                        }
                    }
                }
                
                if (remaining == 0) {
                    minK = Math.min(minK, k);
                }
            }
            
            System.out.println("Case #" + tc + ": " + minK);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
}