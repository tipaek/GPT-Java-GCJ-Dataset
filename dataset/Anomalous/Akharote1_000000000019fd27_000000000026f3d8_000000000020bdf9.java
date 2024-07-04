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
                    int[] times = tr.nextIntArray();
                    activities.add(new Activity(times[0], times[1]));
                }

                Solver solver = new Solver(activities);
                solver.sortActivities();

                if (solver.isImpossible()) {
                    tr.printCase(i, "IMPOSSIBLE");
                } else {
                    tr.printCase(i, solver.solve());
                }
            }
        });
    }
}

class Solver {
    private ArrayList<Activity> activities;
    private ArrayList<Activity> sortedActivities;
    private ArrayList<ArrayList<Activity>> overlappingPairs;

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
        this.sortedActivities = new ArrayList<>(activities);
        this.overlappingPairs = new ArrayList<>();
    }

    public void sortActivities() {
        sortedActivities.sort(Comparator.comparingInt(Activity::getStart));
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
        if (sortedActivities.isEmpty()) return "";

        sortedActivities.get(0).setAssignedPerson("C");
        calculateOverlappingPairs();

        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> partners = getOverlappingPartners(sortedActivities.get(i));
            sortedActivities.get(i).setAssignedPerson(partners.isEmpty() ? "C" : invert(partners.get(0).getAssignedPerson()));
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getAssignedPerson());
        }
        return result.toString();
    }

    private ArrayList<Activity> getOverlappingPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            if (pair.contains(activity)) {
                Activity partner = pair.get(0).equals(activity) ? pair.get(1) : pair.get(0);
                if (!partners.contains(partner)) {
                    partners.add(partner);
                }
            }
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
        return (start < other.end && end > other.start);
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}

class Transpose {
    private BufferedReader br;
    private String queue = "";
    private int T;
    private int TE;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] input = nextLine().split(" ");
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    public void start(Test test) {
        int[] testCases = nextIntArray();
        T = testCases[0];
        TE = testCases.length > 1 ? testCases[1] : -1;

        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public void printCase(int i, String result) {
        System.out.println("Case #" + i + ": " + result);
    }

    abstract static class Test {
        abstract void onTest(int i, int T);
    }
}