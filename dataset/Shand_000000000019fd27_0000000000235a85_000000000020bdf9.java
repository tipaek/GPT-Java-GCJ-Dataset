
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public class Job implements Comparable<Job> {
        int start,end;
        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Job J) {
            return this.end - J.end;
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        int tests;
        Scanner s = new Scanner(System.in);
        tests = s.nextInt();
        for(int t=0;t<tests;t++) {
            int n = s.nextInt();
            ArrayList<Job> jobs = new ArrayList<>();
            ArrayList<Job> c = new ArrayList<>(), j = new ArrayList<>();
            for(int i=0;i<n;i++) {
                int start = s.nextInt();
                int end = s.nextInt();
                jobs.add(new Job(start,end));
            }

            ArrayList<Job> jobsCopy = (ArrayList<Job>)jobs.clone();
            Collections.sort(jobs);
            int index=0;
            c.add(jobs.remove(0));
            while(index<jobs.size()) {
                if(c.get(c.size()-1).end <= jobs.get(index).start)
                    c.add(jobs.remove(index));
                else
                    index++;
            }
            index=0;
            if(jobs.size()>0) {
                j.add(jobs.remove(0));
                while (index < jobs.size()) {
                    if (j.get(j.size() - 1).end <= jobs.get(index).start)
                        j.add(jobs.remove(index));
                    else
                        index++;
                }
            }
            if(jobs.size()>0) {
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                return;
            }

            System.out.print("Case #"+(t+1)+": ");
            for(int i =0;i<jobsCopy.size();i++) {
                if(c.contains(jobsCopy.get(i)))
                    System.out.print("C");
                else
                    System.out.print("J");
            }
        }
    }
}
