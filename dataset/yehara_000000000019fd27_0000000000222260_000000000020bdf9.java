
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        Solution sol = new Solution();
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            sol.solve(s, out);
        }
        out.close();
    }

    void solve(Scanner sc, PrintWriter out) {

        int n = sc.nextInt();
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Job(i, start, end));
        }

        list.sort(Comparator.comparingInt(a -> a.start));
        int a = 0;
        int b = 0;
        char[] res = new char[n];
        for(Job job : list) {
            int start = job.start;
            if(a > start && b > start) {
                out.println("IMPOSSIBLE");
                return;
            }
            if(a <= start) {
                res[job.index] = 'J';
                a = job.end;
            } else {
                res[job.index] = 'C';
                b = job.end;
            }
        }

        out.println(new String(res));
    }

    static class Job {
        int index;
        int start;
        int end;
        char c;
        Job(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

}
