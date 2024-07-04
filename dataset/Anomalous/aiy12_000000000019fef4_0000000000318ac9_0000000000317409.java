import java.io.*;
import java.util.*;

public class Solution {

    static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + " " + y + ")";
        }
    }
    
    public void run() throws Exception {
        FastScanner scanner = new FastScanner();
        int T = scanner.nextInt();
        
        for (int test = 1; test <= T; test++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            
            List<Pair> coordinates = new ArrayList<>();
            for (int i = 0; i < M.length(); i++) {
                char direction = M.charAt(i);
                switch (direction) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }
                coordinates.add(new Pair(X, Y));
            }
            
            int minSteps = Integer.MAX_VALUE;
            for (int i = 0; i < coordinates.size(); i++) {
                int steps = i + 1;
                Pair current = coordinates.get(i);
                if (Math.abs(current.x) + Math.abs(current.y) <= steps) {
                    minSteps = steps;
                    break;
                }
            }
            
            System.out.print("Case #" + test + ": ");
            System.out.println(minSteps == Integer.MAX_VALUE ? "IMPOSSIBLE" : minSteps);
        }
    }

    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;
        
        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}