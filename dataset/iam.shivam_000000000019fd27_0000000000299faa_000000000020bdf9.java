import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static class Activity implements Comparable<Activity> {

        int start;
        int end;
        int no;
        char ch;
        
        public Activity(int start, int end, int no) {
            this.start = start;
            this.end = end;
            this.no = no;
        }

        @Override
        public int compareTo(Activity a) {
            return start - a.start;
        }
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        for (int k = 1; k <= T; k++) {
            int N = fastReader.nextInt();
            List<Activity> activityList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = fastReader.nextInt();
                int end = fastReader.nextInt();
                activityList.add(new Activity(start, end, i));
            }

            compute(activityList, k);
        }
    }

    private static void compute(List<Activity> activityList, int k) {
        Collections.sort(activityList);
        Stack<Activity> j = new Stack<>();
        Stack<Activity> c = new Stack<>();

        for (Activity activity : activityList) {
            if (c.isEmpty() || !isColl(activity, c.peek())) {
                c.push(activity);
                activity.ch = 'C';
            } else if (j.isEmpty() || !isColl(activity, j.peek())) {
                j.push(activity);
                activity.ch = 'J';
            } else {
                display("IMPOSSIBLE", k);
                return;
            }
        }

        char[] charArr = new char[activityList.size()];

        for (Activity activity : activityList) {
            charArr[activity.no] = activity.ch;
        }

        display(new String(charArr), k);
    }

    private static void display(String string, int k) {
        System.out.println("Case #" + k + ": " + string);
    }

    private static boolean isColl(Activity a, Activity b) {
        return (a.start > b.start && a.start < b.end) || (a.end > b.start && a.end < b.end);
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    void close() throws IOException {
        br.close();
    }
}
