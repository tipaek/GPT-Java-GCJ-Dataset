import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity> {
    private final int start;
    private final int end;
    private final int id;

    public Activity(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }

    @Override
    public String toString() {
        return "Activity{" + "start=" + start + ", end=" + end + ", id=" + id + "}\n";
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            char[] solution = new char[N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities.add(new Activity(start, end, i));
            }

            Collections.sort(activities);

            if (assignActivities(activities, solution)) {
                System.out.println("Case #" + caseNum + ": " + new String(solution));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignActivities(ArrayList<Activity> activities, char[] solution) {
        ArrayList<Activity> activitiesForJ = new ArrayList<>();
        Activity lastC = activities.get(0);
        solution[lastC.getId()] = 'C';

        for (int i = 1; i < activities.size(); i++) {
            Activity current = activities.get(i);
            if (current.getStart() >= lastC.getEnd()) {
                lastC = current;
                solution[lastC.getId()] = 'C';
            } else {
                activitiesForJ.add(current);
            }
        }

        if (!activitiesForJ.isEmpty()) {
            Activity lastJ = activitiesForJ.get(0);
            solution[lastJ.getId()] = 'J';

            for (int i = 1; i < activitiesForJ.size(); i++) {
                Activity current = activitiesForJ.get(i);
                if (current.getStart() >= lastJ.getEnd()) {
                    lastJ = current;
                    solution[lastJ.getId()] = 'J';
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}