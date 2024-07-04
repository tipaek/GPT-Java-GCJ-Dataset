

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    private static void print(BufferedOutputStream bufferedOutputStream, byte[] bytes) throws IOException {
        bufferedOutputStream.write(bytes);
    }

    static class Activity implements Comparable<Activity> {
        int st, ed, i; char assignedTo;

        public Activity(int s, int e, int i) {
            this.st = s; this.ed = e; this.i = i;
        }

        @Override
        public int compareTo(Activity o) {
            return this.st == o.st ? this.ed - o.ed: this.st - o.st;
        }
    }

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            String eol = System.getProperty("line.separator");
            byte[] eolb = eol.getBytes();
            String str[] = bufferedReader.readLine().split(" ");
            int testCases = Integer.parseInt(str[0]);
            byte[] testCaseStrBytes = "Case #".getBytes();
            byte[] colSpace = ": ".getBytes();
            byte[] space = " ".getBytes();
            for (int t = 1; t<=testCases; t++) {
                str = bufferedReader.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                Activity[] activities = new Activity[n];
                for(int i = 0; i < n; i++) {
                    str = bufferedReader.readLine().split(" ");
                    activities[i] = new Activity(Integer.parseInt(str[0]),
                            Integer.parseInt(str[1]), i);
                }

                Arrays.sort(activities);

                boolean isPossible = true;
                int c_ed = -1, j_ed = -1;
                for(int i=0; i<n; i++) {
                    int st = activities[i].st, ed = activities[i].ed;
                    if(c_ed <= st) {
                        c_ed = ed;
                        activities[i].assignedTo = 'C';
                    } else if(j_ed <= st) {
                        j_ed = ed;
                        activities[i].assignedTo = 'J';
                    } else {
                        isPossible = false; break;
                    }
                }

                StringBuilder ans = new StringBuilder();
                if(!isPossible) ans.append("IMPOSSIBLE");
                else {
                    Arrays.sort(activities, Comparator.comparingInt((Activity o) -> o.i));
                    for(int i=0; i<n; i++) ans.append(activities[i].assignedTo);
                }


                print(bufferedOutputStream, testCaseStrBytes);
                print(bufferedOutputStream, Integer.toString(t).getBytes());
                print(bufferedOutputStream, colSpace);
                print(bufferedOutputStream, ans.toString().getBytes());
                print(bufferedOutputStream, eolb);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
