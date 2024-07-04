import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Job {
    int inTime;
    int outTime;
    Job(int in, int out) {
        inTime = in;
        outTime = out;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        List<Job> arr = new ArrayList<Job>();
        Job job;
        int n, lastC, lastJ;
        String res;
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            arr.clear();
            res = "";
            for(int j=1; j<=n; j++) {
                arr.add(new Job(sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(arr, (a, b) -> {
                return a.inTime - b.inTime;
            });
            lastC = 0;
            lastJ = 0;
            for(int j=0; j<n; j++) {
                job = arr.get(j);
//                System.out.println(job.inTime + " " + job.outTime);
                if(job.inTime>=lastC) {
                    lastC = job.outTime;
                    res += "C";
                } else if(job.inTime >= lastJ) {
                    lastJ = job.outTime;
                    res += "J";
                } else {
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + res);
        }
    }
}
