import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Activity implements Comparable<Activity> {
    int start;
    int end;
    Activity(int s, int e) { start =s; end =e;}
    @Override
    public boolean equals(Object o2) {
        if (!(o2 instanceof Activity)) return false;
        Activity a2=(Activity)o2;
        return this.end==a2.end && this.start==a2.start;
    }
    @Override
    public int compareTo(Activity a2) {
//        Activity a2 = (Activity)o2;
        if (this == a2) { return 0 ; }
        if (this.end <= a2.start) {
            return 1;
        } else if (this.start >= a2.end) {
            return -1;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public String toString() {
        return "("+start+","+end+")";
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        try {
            int N = scanner.nextInt();
            Set<Activity> Cameron = new TreeSet<>();
            Set<Activity> Jamie = new TreeSet<>();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity a = new Activity(start, end);
                try {
                    Cameron.add(a);
                    s.append('C');
                } catch (IllegalArgumentException e) {
                    try {
                        Jamie.add(a);
                        s.append('J');
                    } catch (IllegalArgumentException ee) {
                        s.delete(0, s.length());
                        s.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + s);
        } catch (OutOfMemoryError e) {
            System.out.println("Case #" + t + ": FAILED");
        }
    }
}
