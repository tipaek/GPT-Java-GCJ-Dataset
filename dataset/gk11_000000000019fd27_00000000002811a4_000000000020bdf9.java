import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int N = scanner.nextInt();
        List<Activity> as = new ArrayList<>(N);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Activity a = new Activity(start, end, i);
            as.add(a);
        }
        sort(as);
        int jamieEnd = 0;
        int cameronEnd = 0;
        for (int i=0;i<N;i++) {
            Activity a = as.get(i);
            if (jamieEnd <= a.start) {
                a.who ='J';
                jamieEnd = a.end;
            } else if (cameronEnd <= a.start) {
                a.who = 'C';
                cameronEnd = a.end;
            } else {
                System.out.println("Case #"+t+": IMPOSSIBLE");
                return;
            }
        }
        sort(as, Comparator.comparingInt(a -> a.i));
        for (int i=0;i<N;i++)
            s.append(as.get(i).who);
        System.out.println("Case #" + t + ": " + s);
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int i;
    char who;
    Activity(int s, int e, int i) { start =s; end =e; this.i=i;}
    @Override
    public int compareTo(Activity a2) {
        return Integer.compare(this.start, a2.start);
    }
    public String toString() {
        return "("+start+","+end+")";
    }
}
