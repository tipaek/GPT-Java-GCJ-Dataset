import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Transpose transpose = Transpose.getInstance();
        transpose.start(new Transpose.Test() {
            @Override
            void onTest(int testCaseIndex, int totalTestCases) {
                int numberOfActivities = transpose.nextInt();
                ArrayList<Activity> activities = new ArrayList<>();

                for (int j = 0; j < numberOfActivities; j++) {
                    int[] timeRange = transpose.nextIntArray();
                    activities.add(new Activity(timeRange[0], timeRange[1]));
                }

                Solver solver = new Solver(activities);
                solver.sortActivities();

                if (solver.isImpossible()) {
                    transpose.addCase(testCaseIndex, "IMPOSSIBLE");
                } else {
                    transpose.addCase(testCaseIndex, solver.solve());
                }
            }
        });
        transpose.flush();
    }
}

class Schedule {
    ArrayList<Activity> activities = new ArrayList<>();
    String id;

    public Schedule(String id) {
        this.id = id;
    }
}

class Solver {
    ArrayList<Activity> activities;
    ArrayList<Activity> sortedActivities = new ArrayList<>();
    Schedule scheduleC = new Schedule("C");
    Schedule scheduleJ = new Schedule("J");
    ArrayList<ArrayList<Activity>> overlappingPairs = new ArrayList<>();

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void sortActivities() {
        sortedActivities.clear();
        sortedActivities.addAll(activities);
        sortedActivities.sort(Comparator.comparingInt(Activity::getStartTime));
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

        sortedActivities.get(0).setAssignedTo("C");
        calculateOverlappingPairs();

        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingPartners = getOverlappingPartners(sortedActivities.get(i));
            if (!overlappingPartners.isEmpty()) {
                sortedActivities.get(i).setAssignedTo(invert(overlappingPartners.get(0).getAssignedTo()));
            } else {
                sortedActivities.get(i).setAssignedTo("C");
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getAssignedTo());
        }
        return result.toString();
    }

    private ArrayList<Activity> getOverlappingPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            if (pair.get(0) == activity) {
                partners.add(pair.get(1));
            } else if (pair.get(1) == activity) {
                partners.add(pair.get(0));
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

    private String invert(String assignedTo) {
        return assignedTo.equals("C") ? "J" : "C";
    }
}

class Activity {
    private int startTime;
    private int endTime;
    private String assignedTo;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public boolean overlaps(Activity other) {
        return (other.startTime < endTime && other.endTime > startTime);
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return startTime + "," + endTime;
    }
}

class Transpose {
    private BufferedReader reader;
    private StringBuilder outputQueue = new StringBuilder();
    private int totalTestCases;
    private int testCaseEnd;

    private Transpose() {
        reader = new BufferedReader(new InputStreamReader(System.in));
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
        String[] input = nextLine().split(" ");
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    public void start(Test test) {
        int[] testCaseInfo = nextIntArray();
        totalTestCases = testCaseInfo[0];
        if (testCaseInfo.length > 1) {
            testCaseEnd = testCaseInfo[1];
        }

        for (int i = 1; i <= totalTestCases; i++) {
            test.onTest(i, totalTestCases);
        }
    }

    public Transpose add(String str) {
        outputQueue.append(str);
        return this;
    }

    public Transpose addCase(int index, String result) {
        return addLine("Case #" + index + ": " + result);
    }

    public Transpose addLine(String line) {
        return add(line + "\n");
    }

    public void flush() {
        if (outputQueue.length() > 0) {
            System.out.print(outputQueue.toString());
            outputQueue.setLength(0);
        }
    }

    abstract static class Test {
        abstract void onTest(int testCaseIndex, int totalTestCases);
    }
}