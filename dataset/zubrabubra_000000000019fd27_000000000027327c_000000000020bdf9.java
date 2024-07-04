import java.util.Scanner;
import java.util.Arrays;
//...


class Solution {
    
    static class Job implements Comparable<Job> {
        
        int start;
        int end;
        int index;
        char who;
        
        public Job(int s, int e, int i) {
            start = s;
            end = e;
            index = i;
            who = '-';
        }
        
        public int compareTo(Job o) {
            if (start == o.start) {
                return Integer.compare(end, o.end);
            }
            return Integer.compare(start, o.start);
        }
    }
    
    public static boolean apply(Job[] jobs) {
        int C = -1, J = -1;
        for (int i = 0; i < jobs.length; i++) {
            Job j = jobs[i];
            if (j.start >= C) {
                j.who = 'C';
                C = j.end;
            } else if (j.start >= J) {
                j.who = 'J';
                J = j.end;
            } else {
                //System.out.println("Cannot find " + j.start + " > " + j.end + " C=" + C + " J=" + J);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int it = 0; it < t; it++) {
            int n = in.nextInt();
            Job[] jobs = new Job[n];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Job job = new Job(start, end, j);
                jobs[j] = job;
            }
            Arrays.sort(jobs);
            //System.out.println("Case #" + (it+1) + ": START");
            if (!apply(jobs)) {
                System.out.println("Case #" + (it+1) + ": IMPOSSIBLE");
            } else {
                char[] who = new char[n];
                for (int i = 0; i < who.length; i++) {
                    who[jobs[i].index] = jobs[i].who;
                }
                System.out.println("Case #" + (it+1) + ": " + new String(who));
            }
        }
    }
}
