import java.util.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new Answer().solve(in, out);
        out.flush();
        out.close();
    }
}

class Answer {
    public void solve(Scanner in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numActivities = in.nextInt();
            int lastC = 0, lastJ = 0;
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end));
            }
            
            activities.sort(Comparator.comparingInt(a -> a.start));
            
            for (Activity activity : activities) {
                if (impossible) continue;
                
                if (activity.start >= lastC) {
                    lastC = activity.end;
                    result.append("C");
                } else if (activity.start >= lastJ) {
                    lastJ = activity.end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            out.println("Case #" + t + ": " + result.toString());
        }
    }
}

class Activity {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}