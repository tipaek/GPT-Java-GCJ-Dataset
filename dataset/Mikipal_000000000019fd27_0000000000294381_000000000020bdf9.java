
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //activities
            jobtime jobtms[] = new jobtime[n * 2];
            jobtime jobtmsrw[] = new jobtime[n * 2];
            int co = 0, ts, te;
            for (int j = 0; j < n; j++) {
                ts = in.nextInt();
                te = in.nextInt();
                jobtms[co] = new jobtime(ts, te, true, co / 2);
                co++;
                jobtms[co] = new jobtime(te, false, (co - 1) / 2);
                co++;
            }


            for (int j = 0; j < (n*2) - 1; j++) {
                for (int k = 0; k < (n*2) - 1; k++) {
                    if (j != k) {
                        jobtime mom = jobtms[k];
                        if (mom.time > jobtms[k + 1].time) {
                            jobtms[k] = jobtms[k + 1];
                            jobtms[k + 1] = mom;
                        }

                    }
                }
            }
            

            jobtime c = null, j = null;
            String chrs[] = new String[n];
            String ans = "";
            for (jobtime jt : jobtms) {
                if (jt.isstart) {
                    if (c == null) {
                        c = jt;
                        chrs[jt.id] = "C";
                    } else if (j == null) {
                        j = jt;
                        chrs[jt.id] = "J";
                    } else {
                        ans = "IMPOSSIBLE";
                        break;
                    }
                } else {
                    if (c != null) {
                        if ((c.time2 == jt.time) && (c.id == jt.id)) {
                            c= null;
                        }
                    }
                    if (j != null) {
                        if ((j.time2 == jt.time) && (j.id == jt.id)) {
                            j=null;
                        }
                    }
                }

            }

            if(!ans.equals("IMPOSSIBLE")){
                for (int k = 0; k < n; k++) {
                    ans += chrs[k];
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public static class jobtime {

        public boolean isstart = true;
        public int time = -1, time2 = -1, id = -1;

        public jobtime(int times, int timee, boolean isstart, int id) {
            this.time = times;
            this.time2 = timee;
            this.isstart = isstart;
            this.id = id;
        }

        public jobtime(int times, boolean isstart, int id) {
            this.time = times;
            this.isstart = isstart;
            this.id = id;
        }

    }
}
