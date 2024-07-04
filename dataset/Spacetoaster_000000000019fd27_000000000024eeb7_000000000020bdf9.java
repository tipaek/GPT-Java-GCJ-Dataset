import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Activity implements Comparable<Activity> {
    public int start;
    public int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static String computeSolution(ArrayList<Activity> activities) {
        int Jend = 0;
        int Cend = 0;
        StringBuilder returnString = new StringBuilder();
        for (Activity a : activities) {
            if (Jend <= a.start) {
                Jend = a.end;
                returnString.append("J");
            } else if (Cend <= a.start) {
                Cend = a.end;
                returnString.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return returnString.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int N = Integer.parseInt(in.nextLine());
            ArrayList<Activity> activities = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(in.nextLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                activities.add(new Activity(start, end));
            }
            activities.sort(Activity::compareTo);
            System.out.println("Case #" + i + ": " + computeSolution(activities));
        }
    }
}
