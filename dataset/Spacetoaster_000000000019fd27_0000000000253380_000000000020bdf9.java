import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Activity {
    public int start;
    public int end;
    public int occurence;
    public String person;

    public Activity(int start, int end, int occurence) {
        this.start = start;
        this.end = end;
        this.occurence = occurence;
    }

    public int compareByStartTime(Activity other) {
        return Integer.compare(this.start, other.start);
    }

    public int compareByOccurence(Activity other) {
        return Integer.compare(this.occurence, other.occurence);
    }
}

public class Solution {
    public static String computeSolution(ArrayList<Activity> activities) {
        activities.sort(Activity::compareByStartTime);
        int Jend = 0;
        int Cend = 0;
        for (Activity a : activities) {
            if (Jend <= a.start) {
                Jend = a.end;
                a.person = "J";
            } else if (Cend <= a.start) {
                Cend = a.end;
                a.person = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }
        activities.sort(Activity::compareByOccurence);
        StringBuilder returnString = new StringBuilder();
        for (Activity a : activities) {
            returnString.append(a.person);
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
                activities.add(new Activity(start, end, j));
            }
            System.out.println("Case #" + i + ": " + computeSolution(activities));
        }
    }
}
