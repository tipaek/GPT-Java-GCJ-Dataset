import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks[i] = new Task(start, end, i);
            }
            
            Arrays.sort(tasks);
            char[] result = new char[n];
            result[tasks[0].index] = 'C';
            boolean cAvailable = true;
            boolean jAvailable = false;
            String impossible = "";
            int cEnd = tasks[0].end;
            int jEnd = 0;
            
            outerLoop: 
            for (int i = 1; i < n; i++) {
                int start = tasks[i].start;
                int end = tasks[i].end;
                
                if (start >= cEnd) {
                    cAvailable = false;
                }
                if (start >= jEnd) {
                    jAvailable = false;
                }
                
                if (!cAvailable) {
                    cEnd = end;
                    result[tasks[i].index] = 'C';
                    cAvailable = true;
                } else if (!jAvailable) {
                    jEnd = end;
                    result[tasks[i].index] = 'J';
                    jAvailable = true;
                } else {
                    impossible = "IMPOSSIBLE";
                    break outerLoop;
                }
            }
            
            if (impossible.equals("IMPOSSIBLE")) {
                out.println("Case #" + z + ": " + impossible);
            } else {
                out.println("Case #" + z + ": " + new String(result));
            }
        }
        
        out.close();
    }
    
    static class Task implements Comparable<Task> {
        int start, end, index;
        
        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public int compareTo(Task other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
        
        @Override
        public String toString() {
            return start + " " + end;
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