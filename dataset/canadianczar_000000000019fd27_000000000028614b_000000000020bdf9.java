import java.util.*;
import java.io.*;
class Solution {
    public static class Interval {
        int start, end, index;
        char c;
        public Interval(int index, int start, int end, char c) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()), test = 1;
        while (test <= tests) {
            int lines = in.nextInt();
            Interval[] ins = new Interval[lines];
            for (int i = 0; i < lines; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Interval a = new Interval(i, start, end, ' ');
                ins[i] = a;
            }
            solve(test, ins);
            test++;
        }
        in.close();
    }
    public static boolean givejob(List<Interval> l, Interval in) {
        if (l.size() == 0) {
            l.add(in);
            return false;
        }
        Interval last = l.get(l.size()-1);
        int start = in.start;
        if (start >= last.end) {//added interval
            l.add(in);
            return false;
        }
        return true;
    }
    public static void solve(int test, Interval[] ins) {
        StringBuilder sb = new StringBuilder();
        List<Interval> cs = new ArrayList(), js = new ArrayList();
        boolean cturn = true;
        Arrays.sort(ins, (a, b) -> {
            int start = Integer.compare(a.start, b.start);
            if (start != 0) return start;
            int end = Integer.compare(a.end, b.end);
            if (end != 0) return end;
            return Integer.compare(a.index, b.index);
        });
        for (Interval in : ins) {
            boolean overlap1 = true, overlap2 = true;
            overlap1 = givejob( cturn == true ? cs : js, in);
            if (overlap1) {
                cturn = !cturn;//give to other person
                overlap2 = givejob( cturn == true ? cs : js, in);
            } else {
                in.c = cturn == true ? 'C' : 'J';
                continue; 
            }
            if (overlap1 && overlap2) {
                sb.append("IMPOSSIBLE");
                break;
            } else {
                in.c = cturn == true ? 'C' : 'J';
            }
        }
        if (sb.length()==0) {
            Arrays.sort(ins, (a, b) -> Integer.compare(a.index, b.index));
            for (Interval in : ins) {
                sb.append(in.c);
            }
        }
        System.out.printf("Case #%d: %s\n", test, sb.toString());
    }
}