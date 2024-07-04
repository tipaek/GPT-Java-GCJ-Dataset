///package codegam2020.qualification.Parenting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    // solution

    void solve() throws IOException {
        int tc = readInt();
        for (int t = 1; t <= tc; ++t) {
            int n = readInt();
            char[] selected = new char[n];
            List<Interval> lsIntervalStart = new ArrayList<>();
            List<Interval> lsIntervalEnd = new ArrayList<>();
            for(int i=0;i<n;i++){
                Interval interval = new Interval(i, readInt(), readInt());
                lsIntervalStart.add(interval);
                lsIntervalEnd.add(interval);
            }
            Collections.sort(lsIntervalStart, Comparator.comparingInt(Interval::getSi));
            Collections.sort(lsIntervalEnd, Comparator.comparingInt(Interval::getEi));
            List<Interval> ls1 = new ArrayList<>();
            List<Interval> ls2 = new ArrayList<>();
            for(int i=0;i<n;i++){
                Interval ci = lsIntervalStart.get(i);
                if(isPossible(ls1,ci)) {
                    ls1.add(ci);
                    selected[ci.index]='C';
                    continue;
                }
                if(isPossible(ls2,ci)) {
                    ls2.add(ci);
                    selected[ci.index]='J';
                    continue;
                }
                ls1.clear();
                ls2.clear();
                break;
            }
            if(ls1.isEmpty())
                System.out.println(String.format("Case #%s: IMPOSSIBLE",t));
            else
                System.out.println(String.format("Case #%s: %s",t, new String(selected)));
        }
        return;
    }
    boolean isPossible(List<Interval> lsIntervals, Interval interval) {
        for(Interval eachInterval : lsIntervals) {
            if(!(eachInterval.ei<= interval.si || interval.ei<= eachInterval.si))
                return false;
        }
        return true;
    }


    class Interval{
        public int si;
        public int ei;
        public int index;
        public int no;

        public Interval(int index, int si, int ei) {
            this.index=index;
            this.si=si;
            this.ei=ei;
        }

        public int getSi(){
            return this.si;
        }

        public int getEi() {
            return this.ei;
        }
    }
}

