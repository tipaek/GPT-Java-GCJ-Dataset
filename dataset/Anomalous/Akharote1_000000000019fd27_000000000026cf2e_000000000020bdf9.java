import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Transpose tr = Transpose.getInstance();
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

class Solver {
    private ArrayList<Activity> activities;
    private ArrayList<Activity> sortedActivities;
    private ArrayList<ArrayList<Activity>> overlappingPairs;

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
        this.sortedActivities = new ArrayList<>();
        this.overlappingPairs = new ArrayList<>();
    }

    public void sortActivities() {
        sortedActivities.clear();
        sortedActivities.addAll(activities);
        sortedActivities.sort(Comparator.comparingInt(Activity::getStart));
    }

    public boolean isImpossible() {
        if (sortedActivities.size() < 3) return false;
        for (int i = 0; i < sortedActivities.size() - 2; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1)) &&
                sortedActivities.get(i).overlaps(sortedActivities.get(i + 2))) {
                if (!sortedActivities.get(i + 1).overlaps(sortedActivities.get(i + 2))) return false;
                return true;
            }
        }
        return false;
    }

    public String solve() {
        if (sortedActivities.isEmpty()) return "";

        sortedActivities.get(0).setAssignedPerson("C");
        calculateOverlappingPairs();

        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingActivities = getOverlappingActivities(sortedActivities.get(i));
            if (!overlappingActivities.isEmpty()) {
                sortedActivities.get(i).setAssignedPerson(invert(overlappingActivities.get(0).getAssignedPerson()));
            } else {
                sortedActivities.get(i).setAssignedPerson("C");
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getAssignedPerson());
        }
        return result.toString();
    }

    private ArrayList<Activity> getOverlappingActivities(Activity activity) {
        ArrayList<Activity> result = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            if (pair.get(0) == activity) {
                result.add(pair.get(1));
            } else if (pair.get(1) == activity && !result.contains(pair.get(0))) {
                result.add(pair.get(0));
            }
        }
        return result;
    }

    private void calculateOverlappingPairs() {
        overlappingPairs.clear();
        if (sortedActivities.size() < 2) return;

        for (int i = 0; i < sortedActivities.size(); i++) {
            for (int j = 0; j < sortedActivities.size(); j++) {
                if (i != j && sortedActivities.get(i).overlaps(sortedActivities.get(j))) {
                    ArrayList<Activity> pair = new ArrayList<>();
                    pair.add(sortedActivities.get(i));
                    pair.add(sortedActivities.get(j));
                    overlappingPairs.add(pair);
                }
            }
        }
    }

    private String invert(String person) {
        return person.equals("C") ? "J" : "C";
    }
}

class Activity {
    private int start;
    private int end;
    private String assignedPerson;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
        this.assignedPerson = "";
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public boolean overlaps(Activity other) {
        return (other.start < end && other.end > start);
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}

class Transpose {
    private BufferedReader reader;
    private StringBuilder queue;
    private int T;
    private int TE;

    private Transpose() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        queue = new StringBuilder();
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] tokens = nextLine().split(" ");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    public void start(Test test) {
        int[] ts = nextIntArray();
        T = ts[0];
        TE = ts.length > 1 ? ts[1] : -1;

        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose addCase(int i, String result) {
        queue.append("Case #").append(i).append(": ").append(result).append("\n");
        return this;
    }

    public void flush() {
        if (queue.length() > 0) {
            System.out.print(queue.toString());
        }
        queue.setLength(0);
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}