import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        for (int tr = 0; tr < nam; tr++) {
            sc.nextLine();
            int N = sc.nextInt();
            ArrayList<Boolean> C = new ArrayList<>();
            ArrayList<Boolean> J = new ArrayList<>();
            ArrayList<Integer> start = new ArrayList<>(), end = new ArrayList<>();
ArrayList<Interval> intervals = new ArrayList<>();
            for(int i = 0; i < N;i++){
                sc.nextLine();
                intervals.add(new Interval(sc.nextInt(), sc.nextInt(), i));
            }
            ArrayList<Boolean> ans = new ArrayList<>(Collections.nCopies(N, false));
            Collections.sort(intervals);
            C.add(true);
            ans.set(intervals.get(0).pos, true);
            int lastC = 0, lastJ = 0;
            lastC = intervals.get(0).e;
            boolean bad = false;
            for (int i = 1; i < N; i++) {
            
                int s = intervals.get(i).s;
                int e = intervals.get(i).e;
                start.add(s);
                end.add(e);
                boolean bC = C.get(i-1), lC = C.get(i-1);
                if (s >= lastC) {
                    lastC = e;
                    C.add(true);
                    ans.set(intervals.get(i).pos, true);
                } else if (s >= lastJ) {
                    lastJ = e;
                    ans.set(intervals.get(i).pos, false);
                    C.add(false);
                } else {
                    bad = true;
                    break;
                }
            }
            String s = "";
            if (bad) System.out.println("Case #" + (tr + 1) + ": IMPOSSIBLE");
            else {
                for (boolean b : ans) s += (b) ? "C" : "J";
                System.out.println("Case #" + (tr + 1) + ": " + s);
            }
        }

    }
}class Interval implements Comparable<Interval> {
    int s, e, pos;

    public Interval(int s, int e, int p) {
        this.s = s;
        this.e = e;
        pos = p;
    }

    public String toString() {
        return pos +": " + s + " " + e;
    }
    @Override
    public int compareTo(Interval o) {
        if(s  == o.s) return e -o.e;
        return s - o.s;
    }
}
