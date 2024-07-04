import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            Activity[] array = new Activity[n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                array[j] = new Activity(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), j);
            }
            Arrays.sort(array);
            int c = 0, j = 0;
            char[] result = new char[n];
            boolean impossible = false;
            for (int k = 0; k < n; k++) {
                if (c <= array[k].start) {
                    c = array[k].end;
                    result[array[k].index] = 'C';
                } else if (j <= array[k].start) {
                    j = array[k].end;
                    result[array[k].index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            pw.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : String.valueOf(result)));
        }
        pw.close();
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;
        public Activity(int s, int e,int i) {
            this.start = s;
            this.end = e;
            this.index = i;
        }
        public int compareTo(Activity a) {
            return this.start != a.start ? this.start - a.start : this.end - a.end;
        }
    }
}