import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class MyScanner {
        BufferedReader br;

        StringTokenizer st;


        public MyScanner() {
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
    static class Job implements Comparable<Job>{
        int start;
        int end;
        int index;
        Job(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Job o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        String impossible = "IMPOSSIBLE";
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int task = 1; task <= numCases; task++) {
            int jobs = scanner.nextInt();
            boolean out = false;
            PriorityQueue<Job> queue = new PriorityQueue<>();
            for (int job = 0; job < jobs; job++) {
                queue.offer(new Job(scanner.nextInt(), scanner.nextInt(), job));
            }

            int[] lastStop = new int[2];//C, J
            Arrays.fill(lastStop, 0);

            char[] arr = new char[jobs];
            while (!queue.isEmpty() && !out) {
                Job job = queue.poll();
                if (lastStop[0] <= lastStop[1] && lastStop[0] <= job.start) {
                    lastStop[0] = job.end;
                    arr[job.index] = 'C';
                }
                else if (lastStop[1] < lastStop[0] && lastStop[1] <= job.start) {
                    lastStop[1] = job.end;
                    arr[job.index] = 'J';
                }
                else {
                    out = true;
                    break;
                }
            }
            if (out)  System.out.format("Case #%d: %s\n", task, impossible);


            else System.out.format("Case #%d: %s\n", task, new String(arr));
        }
    }
}
