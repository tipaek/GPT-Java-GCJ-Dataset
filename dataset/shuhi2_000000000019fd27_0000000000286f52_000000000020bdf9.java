import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static int caseNum = 0;

    public static void main(String[] arg) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i=0; i < t; i++) {
            int n = in.nextInt();
            Triple[] activities = new Triple[n];
            for(int j=0;j<n;j++) {
                activities[j] = new Triple(in.nextInt(),in.nextInt(),j);
            }
            solve(activities);
        }
    }

    private static void solve(Triple[] act) {
        caseNum++;

        char[] ans = new char[act.length];
        Arrays.sort(act, new Comparator<Triple>() {
            @Override
            public int compare(Triple pair, Triple t1) {
                if(pair.start < t1.start) {
                    return -1;
                } else if (pair.start > t1.start) {
                    return 1;
                } else if (pair.end < t1.end) {
                    return -1;
                } else if(pair.end > t1.end) {
                    return  1;
                }
                return 0;
            }
        });

        int cEnd = 0;
        int jEnd = 0;

        for(int i=0;i<act.length;i++) {
            if(cEnd <= act[i].start) {
                ans[act[i].original] = 'C';
                cEnd = act[i].end;
            } else if(jEnd <= act[i].start) {
                ans[act[i].original] = 'J';
                jEnd = act[i].end;
            } else {
                System.out.println("Case #" + caseNum +": IMPOSSIBLE");
                return;
            }
        }

        String s = "";
        for(int i=0;i<ans.length;i++) {
            s += ans[i];
        }

        System.out.println("Case #" + caseNum +": " + s);
    }

    static class Triple {
        int start,end, original;
        public Triple(int start,int end, int original) {
            this.start = start;
            this.end = end;
            this.original = original;
        }
    }
}