import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for(int i = 1; i <= cases; i++) {
            ArrayList<Job> schedule = new ArrayList<>();
            int jobs = scanner.nextInt();
            for (int j = 0; j < jobs; j++) {
                schedule.add(new Job(scanner.nextInt(), scanner.nextInt(), j));
            }
            Collections.sort(schedule);
            int c = 0;
            int j = 0;
            char[] assigned = new char[jobs];
            boolean possible = true;
            for (int k = 0; k < jobs; k++) {
                Job job  =  schedule.get(k);
                if (job.getStart() >= c) {
                    c = job.getEnd();
                    assigned[job.getIndex()] =  'C';
                } else if (job.getStart() >= j) {
                    j = job.getEnd();
                    assigned[job.getIndex()] = 'J';
                } else {
                    possible = false;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
            if (possible) {
                System.out.println("Case #"+i+" "+new String(assigned));
            }
        }
    }

}

class Job implements Comparable<Job> {
    int start;
    int end;
    int index;

    Job(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    int getEnd() {
        return this.end;
    }

    int getStart() {
        return this.start;
    }

    int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Job o) {
        return Integer.compare(this.start, o.start);
    }
}
