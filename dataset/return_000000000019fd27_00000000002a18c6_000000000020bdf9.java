import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Job {
    int inTime;
    int outTime;
    int index;
    Job(int in, int out, int index) {
        inTime = in;
        outTime = out;
        this.index = index;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        List<Job> arr = new ArrayList<Job>();
        Job job;
        int n, lastC, lastJ;
        char[] res;
        boolean failed;
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            arr.clear();
            res = new char[n];
            failed = false;
            for(int j=1; j<=n; j++) {
                arr.add(new Job(sc.nextInt(), sc.nextInt(), j-1));
            }
            Collections.sort(arr, (a, b) -> {
                return a.inTime - b.inTime;
            });
            lastC = 0;
            lastJ = 0;
            for(int j=0; j<n; j++) {
                job = arr.get(j);
                if(job.inTime>=lastC) {
                    lastC = job.outTime;
                    res[job.index] = 'C';
                } else if(job.inTime >= lastJ) {
                    lastJ = job.outTime;
                    res[job.index] = 'J';
                } else {
                    failed = true;
                    break;
                }
            }
            if (!failed)
                System.out.println("Case #" + i + ": " + new String(res));
            else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }
}
