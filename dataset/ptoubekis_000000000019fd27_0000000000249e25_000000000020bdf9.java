import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = in.nextInt();
            List<Activity> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                list.add(new Activity(s, e, j));
            }
            System.out.println("Case #" + i + ": " + foo(list));
        }
    }

    private static String foo(List<Activity> list) {
        Collections.sort(list);
        int c = -1;
        int j = -1;
        char[] r = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Activity a = list.get(i);
            if (c <= a.start) {
                c = a.end;
                r[a.index] = 'C';
            } else if (j <= a.start) {
                j = a.end;
                r[a.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(r);
    }

    private static class Activity implements Comparable<Activity> {

        int start;
        int end;
        int index;

        Activity(int s, int e, int i) {
            this.start = s;
            this.end = e;
            this.index = i;
        }

        @Override
        public int compareTo(Activity a) {
            return Integer.compare(this.start, a.start);
        }
    }

}
