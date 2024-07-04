package m2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Transpose tr = Transpose.get();
        tr.start(new Transpose.Test() {
            @Override
            void onTest(int i, int T) {
                int N = tr.nextInt();
                ArrayList<Activity> activities = new ArrayList<>();
                
                for (int j = 0; j < N; j++) {
                    int[] ix = tr.nextIntArray();
                    activities.add(new Activity(ix[0], ix[1]));
                }
                
                Solver solver = new Solver(activities);
                solver.sortActivities();
                
                if (solver.isImpossible()) {
                    tr.addCase(i, "IMPOSSIBLE");
                } else {
                    tr.addCase(i, solver.solve());
                }
            }
        });
        tr.flush();
    }
}

class Activity {
    int start;
    int end;
    String assignedTo;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int sortValue() {
        return start;
    }

    public boolean overlaps(Activity other) {
        return (other.start < end && other.end > start);
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}

class Solver {
    ArrayList<Activity> activities;
    ArrayList<Activity> sortedActivities = new ArrayList<>();
    ArrayList<ArrayList<Activity>> overlappingPairs = new ArrayList<>();

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void sortActivities() {
        sortedActivities.clear();
        sortedActivities.addAll(activities);
        sortedActivities.sort(Comparator.comparingInt(Activity::sortValue));
    }

    public boolean isImpossible() {
        if (sortedActivities.size() < 3) return false;
        for (int i = 0; i < sortedActivities.size() - 2; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1)) &&
                sortedActivities.get(i).overlaps(sortedActivities.get(i + 2)) &&
                sortedActivities.get(i + 1).overlaps(sortedActivities.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public String solve() {
        sortedActivities.get(0).assignedTo = "C";
        calculateOverlappingPairs();
        
        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingPartners = getOverlappingPartners(sortedActivities.get(i));
            if (!overlappingPartners.isEmpty()) {
                sortedActivities.get(i).assignedTo = invert(overlappingPartners.get(0).assignedTo);
            } else {
                sortedActivities.get(i).assignedTo = "C";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }
        return result.toString();
    }

    private String invert(String assignedTo) {
        return assignedTo.equals("C") ? "J" : "C";
    }

    private ArrayList<Activity> getOverlappingPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            if (pair.get(0) == activity) partners.add(pair.get(1));
            else if (pair.get(1) == activity) partners.add(pair.get(0));
        }
        return partners;
    }

    private void calculateOverlappingPairs() {
        overlappingPairs.clear();
        for (int i = 0; i < sortedActivities.size(); i++) {
            for (int j = i + 1; j < sortedActivities.size(); j++) {
                if (sortedActivities.get(i).overlaps(sortedActivities.get(j))) {
                    ArrayList<Activity> pair = new ArrayList<>();
                    pair.add(sortedActivities.get(i));
                    pair.add(sortedActivities.get(j));
                    overlappingPairs.add(pair);
                }
            }
        }
    }
}

class Transpose {
    private BufferedReader br;
    private String queue = "";
    private int T = -1;
    private int TE = -1;

    public static Transpose get() {
        return new Transpose();
    }

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] tokens = nextLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    public void start(Test test) {
        int[] ts = nextIntArray();
        T = ts[0];
        if (ts.length > 1) {
            TE = ts[1];
        }
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        queue += s;
        return this;
    }

    public Transpose addCase(int i, String s) {
        return addLine("Case #" + i + ": " + s);
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        if (!queue.isEmpty()) {
            System.out.print(queue);
        }
        queue = "";
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}