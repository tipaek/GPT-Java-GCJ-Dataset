
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //activities
            job jobtms[] = new job[n];
            job jobuns[] = new job[n];
            int ts, te;
            for (int j = 0; j < n; j++) {
                ts = in.nextInt();
                te = in.nextInt();
                jobtms[j] = new job(ts, te);
                jobuns[j] = new job(ts, te);
            }
            

            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (j != k) {
                        job mom = jobtms[k];
                        if (mom.start > jobtms[k + 1].start) {
                            jobtms[k] = jobtms[k + 1];
                            jobtms[k + 1] = mom;
                        }

                    }
                }
            }
           
            String ans = "";
            char answ[] = new char[n];
            int cam = -1, jam = -1;
            for (int j = 0; j < jobtms.length; j++) {
                if(cam == -1 || jobtms[j].start >= jobtms[cam].end){
                    cam = j;
                    for (int k = 0; k < jobtms.length; k++) {
                        if(jobuns[k].start == jobtms[j].start && jobuns[k].end == jobtms[j].end){
                            if(answ[k] != 'J'){
                                answ[k] = 'C';
                                break;
                            }
                        }
                    }
                } else if(jam == -1 || jobtms[j].start >= jobtms[jam].end){
                    jam = j;
                    for (int k = 0; k < jobtms.length; k++) {
                        if(jobuns[k].start == jobtms[j].start && jobuns[k].end == jobtms[j].end){
                            if(answ[k] != 'C'){
                                answ[k] = 'J';
                                break;
                            }
                        }
                    }
                }else{
                    ans = "IMPOSSIBLE";
                    break;
                }
                
            }

            if (!ans.equals("IMPOSSIBLE")) {
                for (int k = 0; k < n; k++) {
                    ans += answ[k];
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public static class job {

        public int start, end;

        public job(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
