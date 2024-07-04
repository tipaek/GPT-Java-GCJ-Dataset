import java.io.*;
import java.util.*;

public class Solution {
    
    public static long binomialCoefficient(long n, long k) {
        if (n - k >= 10)
            return (long) 1E9;
        long result = 1;
        long limit = n - k + 1;
        while (n >= limit)
            result *= n--;
        while (k >= 2)
            result /= k--;
        return result;
    }
    
    public static boolean depthFirstSearch(int row, int col, boolean[][] visited, long remaining, int steps, List<String> path) {
        if (remaining == 0)
            return true;
        if (steps == 0)
            return remaining == 0;
        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0)
                    continue;
                if (row + dr < 1)
                    continue;
                if (col + dc < 1 || col + dc > row + dr)
                    continue;
                
                long binCoeff = binomialCoefficient(row + dr, col + dc);
                if (binCoeff > remaining || visited[row + dr][col + dc])
                    continue;
                
                visited[row + dr][col + dc] = true;
                path.add((row + dr) + " " + (col + dc));
                
                if (depthFirstSearch(row + dr, col + dc, visited, remaining - binCoeff, steps - 1, path))
                    return true;
                
                visited[row + dr][col + dc] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            long n = reader.nextLong();
            boolean[][] visited = new boolean[50][50];
            List<String> path = new ArrayList<>();
            path.add("1 1");
            visited[1][1] = true;
            n--;
            
            depthFirstSearch(1, 1, visited, n, 500, path);
            
            System.out.println("Case #" + tc + ":");
            for (String step : path)
                System.out.println(step);
        }
    }
}

class FastReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    public FastReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
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
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    
    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = nextInt();
        return array;
    }
    
    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nextLong();
        return array;
    }
    
    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nextDouble();
        return array;
    }
    
    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = next();
        return array;
    }
}