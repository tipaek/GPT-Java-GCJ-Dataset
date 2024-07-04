import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int cases = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < cases; i++) {
            int times = Integer.parseInt(scn.nextLine());
            List<Job> unsorted = new ArrayList<>();
            List<Job> raw = new ArrayList<>();
            List<Job> remaining = new ArrayList<>();
            
            for (int j = 0; j < times; j++) {
                int s = scn.nextInt();
                int e = scn.nextInt();
                raw.add(new Job(s, e, j));
                // remaining.add(new Job(s, e, j));
                unsorted.add(new Job(s, e, j));
                scn.nextLine(); // for \n
            }

            Collections.sort(raw);

            List<Job> cameron = new ArrayList<>();
            List<Job> jamie = new ArrayList<>();
            cameron.add(raw.get(0)); //cameron can always do the first job.
            if (raw.size() >= 2) jamie.add(raw.get(1)); //jamie can always do the second job.
            for (int j = 2; j < raw.size(); j++) {
                if (getEndOfJob(cameron) <= raw.get(j).start) {
                    cameron.add(raw.get(j));
                } else if (getEndOfJob(jamie) <= raw.get(j).start) {
                    jamie.add(raw.get(j));
                } else {
                    //impossible!
                }
            }

            if ( (cameron.size() + jamie.size()) < unsorted.size()) {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i+1) + ": ");
                for (Job j : unsorted) {
                    if (cameron.contains(j)) System.out.print("C");
                    else if (jamie.contains(j)) System.out.print("J");
                }
                System.out.println();
            }
        }
    }

    private static int getEndOfJob(List<Job> jobs) {
        if (jobs.size() > 0) {
            return jobs.get(jobs.size() - 1).end;
        } else {
            return 0;
        }
    }
}

class Job implements Comparable {
    int start;
    int end;
    int id;

    Job (int s, int e, int i) {
        start = s;
        end = e;
        id = i;
    }

    @Override
    public int compareTo(Object o) {
        return (this.end - ((Job)o).end);
    }

    public boolean equals(Object o) {
        return (this.id == ((Job)o).id); //(this.start == ((Job)o).start) && (this.end == ((Job)o).end)
    }
    
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}