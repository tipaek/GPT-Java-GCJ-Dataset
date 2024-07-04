import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] inp = new String[2];
            Pair[] jobs = new Pair[N];
            for (int i = 0; i < N; i++) {
                inp = br.readLine().trim().split(" ");
                jobs[i] = new Pair(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), i);
            }

            // printJobs(jobs);
            Arrays.sort(jobs);
            // printJobs(jobs);

            char[] answer = new char[N];
            boolean impossible = false;
            int cEnd = Integer.MIN_VALUE;
            int jEnd = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (jobs[i].x < cEnd && jobs[i].x < jEnd) {
                    impossible = true;
                    break;
                }
                if (cEnd <= jobs[i].x) {
                    cEnd = jobs[i].y;
                    answer[jobs[i].index] = 'C';
                    continue;
                }
                if (jEnd <= jobs[i].x) {
                    jEnd = jobs[i].y;
                    answer[jobs[i].index] = 'J';
                    continue;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (char c : answer) {
                    System.out.print(c);
                }
                System.out.println();
            }

        }
    }

    public static void printJobs(Pair[] jobs) {
        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i]);
        }
        System.out.println();
    }
}

class Pair implements Comparable<Pair> {
    public int x;
    public int y;
    public int index;

    Pair(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    @Override
    public int compareTo(Pair P) {
        if (this.x < P.x)
            return -1;
        if (this.x > P.x)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + "[" + index + "]";
    }
}