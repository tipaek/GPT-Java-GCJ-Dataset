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
        return String.format("Activity{start=%d, end=%d, id=%d}\n", start, end, id);
    }
}

public class Solution {
    private static String schedule(ArrayList<Activity> activities, int N) {
        char[] solution = new char[N];
        Collections.sort(activities);

        Activity lastC = activities.get(0);
        solution[lastC.getId()] = 'C';

        ArrayList<Activity> activitiesForJ = new ArrayList<>();
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
            Collections.sort(activitiesForJ);
            Activity lastJ = activitiesForJ.get(0);
            solution[lastJ.getId()] = 'J';
            for (int i = 1; i < activitiesForJ.size(); i++) {
                Activity current = activitiesForJ.get(i);
                if (current.getStart() >= lastJ.getEnd()) {
                    lastJ = current;
                    solution[lastJ.getId()] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return new String(solution);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                Activity activity = new Activity(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i);
                activities.add(activity);
            }
            System.out.println("Case #" + caseNumber + ": " + schedule(activities, N));
        }
    }
}