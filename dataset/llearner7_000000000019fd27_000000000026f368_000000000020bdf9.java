
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static void main(String[] args) throws Exception {
        ModScanner ms = new ModScanner();
        int t = ms.nextInt();
        int tc = 0;
        while (t-->0) {
            tc++;
            int n = ms.nextInt();
            Activity[] activities = new Activity[n];
            for (int i=0;i<n;i++) {
                int start = ms.nextInt();
                int end = ms.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            String ans = "";
            char[] sb = new char[n];
            Activity cam = new Activity(activities[0].start, activities[0].end,-1);
            sb[activities[0].ind] = 'C';
            Activity jam = new Activity(0,0,-1);
            for (int i=1;i<n;i++) {
                if (activities[i].start >= jam.end) {
                    sb[activities[i].ind] = 'J';
                    jam.start = activities[i].start;
                    jam.end = activities[i].end;
                } else if (activities[i].start >= cam.end) {
                    sb[activities[i].ind] = 'C';
                    cam.start = activities[i].start;
                    cam.end = activities[i].end;
                } else {
                    sb = IMPOSSIBLE.toCharArray();
                    break;
                }
            }
            System.out.println("Case #"+tc+": "+ String.valueOf(sb));
        }
    }

}

class Activity {
    int start;
    int end;
    int ind;

    public Activity(int start, int end, int ind) {
        this.start = start;
        this.end = end;
        this.ind = ind;
    }
}


class ModScanner {
    BufferedReader br;
    StringTokenizer st;

    public ModScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());

        }
        return st.nextToken();
    }

    String nextString() throws Exception {
        return br.readLine();
    }


    int nextInt() throws Exception, Exception {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }


}
