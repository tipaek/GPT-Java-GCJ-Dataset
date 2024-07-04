import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        int c = 1;
        while (c <= t) {
            int n = reader.nextInt();
            Activity[] acts = new Activity[n];
            for (int i=0;i<n;i++)
                acts[i] = new Activity(reader.nextInt(), reader.nextInt(), i);
            Arrays.sort(acts);
            System.out.println(Arrays.toString(acts));
            acts[0].p = 'C';
            int lastc = 0;
            int lastj = -1;
            boolean impossible = false;
            for (int i=1;i<n;i++) {
                char prev = acts[i - 1].p;
                if (!acts[i].overlaps(acts[i-1])) {
                    acts[i].p = prev;
                    if (prev == 'C')
                        lastc = i;
                    else
                        lastj = i;
                } else {
                    if (prev == 'C') {
                        if (lastj == -1 || !acts[lastj].overlaps(acts[i])) {
                            acts[i].p = 'J';
                            lastj = i;
                        } else {
                            impossible = true;
                            break;
                        }
                    } else {
                        if (lastc == -1 || !acts[lastc].overlaps(acts[i])) {
                            acts[i].p = 'C';
                            lastc = i;
                        } else {
                            impossible = true;
                            // System.out.println(i + ", " + lastc + ", " + lastj + ", " + prev);
                            break;
                        }
                    }
                }
            }
            char[] ans = new char[n];
            for (int i=n-1;i>=0;i--) ans[acts[i].index] = acts[i].p;
            System.out.printf("Case #%d: %s\n", c++, impossible ? "IMPOSSIBLE" : new String(ans));
        }
    }
    
    static class Activity implements Comparable<Activity> {
        int start, end, index;
        char p;
        public Activity(int a, int b, int i){start = a; end = b; index = i;}
        
        @Override
        public int compareTo(Activity a) {
            return -new Integer(start).compareTo(a.start);
        }
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
        
        public boolean overlaps(Activity a) {
            return (a.start < end && a.start >= start) || (start < a.end && start >= a.start);
        }
    }
}