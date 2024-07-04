import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static class Schedule {
        private int start;
        private int end;
        private int idx;
        Schedule(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder answer = new StringBuilder();    
        for (int i = 0; i < T; ++i) {
            int N = scan.nextInt();
            Schedule[] sch = new Schedule[N];
            for (int j = 0; j < N; ++j) {
                int s = scan.nextInt();
                int e = scan.nextInt();
                sch[j] = new Schedule(s, e, j);
            }
            Arrays.sort(sch, new Comparator<Schedule>() {
                public int compare(Schedule s1, Schedule s2) {
                    int eComp = Integer.compare(s1.end, s2.end);
                    if (eComp == 0) return Integer.compare(s1.start, s2.start);
                    return eComp;
                }
            });
            char[] chres = new char[N];
            boolean imps = false;
            Queue<Schedule> que = new LinkedList<>();
            int sj = sch[0].start, ej = sch[0].end;
            //int sc = sch[1].start, ec = sch[1].end;
            int sc = 3700, ec = -1;
            chres[sch[0].idx] = 'J';
            //chres[sch[1].idx] = 'C';
            String res = "";
            for (int j = 1; j < sch.length; ++j) {
                int s = sch[j].start;
                int e = sch[j].end;
                int idx = sch[j].idx;
                if ((e <= sj || ej <= s) && (e <= sc || ec <= s)) {
                    que.add(sch[j]);
                } else if (e <= sj || ej <= s) {
                    chres[idx] = 'J';
                    sj = Math.min(sj, s);
                    ej = Math.max(ej, e);
                } else if (e <= sc || ec <= s) {
                    chres[idx] = 'C';
                    sc = Math.min(sc, s);
                    ec = Math.max(ec, e);
                } else {
                    imps = true;
                    break;
                }
            }

            while (que.size() != 0) {
                Schedule sh = que.poll();
                int s = sh.start;
                int e = sh.end;
                int idx = sh.idx;
                if (e <= sj || ej <= s) {
                    chres[idx] = 'J';
                    sj = Math.min(sj, s);
                    ej = Math.max(ej, e);
                } else if (e <= sc || ec <= s) {
                    chres[idx] = 'C';
                    sc = Math.min(sc, s);
                    ec = Math.max(ec, e);
                } else {
                    imps = true;
                    break;
                }
            }

            if (imps) {
                res += "IMPOSSIBLE";
            } else {
                res += new String(chres);
            }
            answer.append("Case #" + (i + 1) + ": " + res + "\n");
        }
        System.out.println(answer);
    }
}