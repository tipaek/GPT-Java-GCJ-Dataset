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
                raw.add(new Job(s, e));
                remaining.add(new Job(s, e));
                unsorted.add(new Job(s, e));
                scn.nextLine(); // for \n
            }

            Collections.sort(raw);

            List<Job> jamie = new ArrayList<>();
            jamie.add(raw.get(0)); //Jamie can always do the first job.
            remaining.remove(raw.get(0));
            for (int j = 1; j < raw.size(); j++) {
                if (raw.get(j).start >= jamie.get(jamie.size() - 1).end) {
                    jamie.add(raw.get(j));
                    remaining.remove(raw.get(j));
                }
            }
            // System.out.println("jamie " + jamie);

            List<Job> cameron = new ArrayList<>();
            if (remaining.size() > 0) {
                // Cameron's jobs
                Collections.sort(remaining);
                cameron.add(remaining.get(0));
                for (int c = 1; c < remaining.size(); c++) {
                    if (remaining.get(c).start >= cameron.get(cameron.size() - 1).end) {
                        cameron.add(remaining.get(c));
                        //remaining.remove(raw.get(j));
                    }
                }
                // System.out.println("cameron " + cameron);
            }
            

            if (jamie.size() + cameron.size() < raw.size()) {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i+1) + ": ");
                for (Job j : unsorted) {
                    if (jamie.contains(j)) System.out.print("J");
                    else if (cameron.contains(j)) System.out.print("C");
                }
                System.out.println();
            }
        }
    }
}

class Job implements Comparable {
    int start;
    int end;
    Job (int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Object o) {
        return this.end - ((Job)o).end;
    }

    public boolean equals(Object o) {
        return (this.start == ((Job)o).start) && (this.end == ((Job)o).end);
    }
    
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}