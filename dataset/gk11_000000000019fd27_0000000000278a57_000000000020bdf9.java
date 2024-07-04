import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        Set<Activity> Cameron = new TreeSet<>();
        Set<Activity> Jamie = new TreeSet<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Activity a = new Activity(start, end);
            if (Cameron.add(a)) {
                s.append('C');
            } else if (Jamie.add(a)) {
                s.append('J');
            } else {
                s.delete(0, s.length());
                s.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.println("Case #" + t + ": " + s);
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    Activity(int s, int e) { start =s; end =e;}
    @Override
    public int compareTo(Activity a2) {
        if (this.end <= a2.start) {
            return 1;
        } else if (this.start >= a2.end) {
            return -1;
        } else {
            return 0;//overlap
        }
    }
    public String toString() {
        return "("+start+","+end+")";
    }
}

