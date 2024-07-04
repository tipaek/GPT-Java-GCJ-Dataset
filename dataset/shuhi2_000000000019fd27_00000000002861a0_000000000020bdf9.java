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
            Pair[] activities = new Pair[n];
            for(int j=0;j<n;j++) {
                activities[j] = new Pair(in.nextInt(),in.nextInt());
            }
            solve(activities);
        }
    }

    private static void solve(Pair[] act) {
        caseNum++;

        String s = "";
        Arrays.sort(act, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
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
                s += "C";
                cEnd = act[i].end;
            } else if(jEnd <= act[i].start) {
                s += "J";
                jEnd = act[i].end;
            } else {
                s = "IMPOSSIBLE";
                break;
            }
        }

        System.out.println("Case #" + caseNum +": " + s);
    }

    static class Pair {
        int start,end;
        public Pair(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
}