import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            int numberOfActivities = Integer.parseInt(sc.nextLine());
            List<Activity> activities = new ArrayList<>();
            for (int activity = 0; activity < numberOfActivities; activity++) {
                String[] activityTimes = sc.nextLine().split("\\s+");
                activities.add(new Activity(Integer.parseInt(activityTimes[0]), Integer.parseInt(activityTimes[1])));
            }
            List<Activity> originalOrder = new ArrayList<>(activities);
            Collections.sort(activities);

            int cameronBusyUntil = -1;
            int jamieBusyUntil = -1;
            boolean impossible = false;

            boolean[] isAssignedToCameron = new boolean[activities.size()];
            int index = 0;

            for (Activity activity : activities) {
                if (activity.startTime >= cameronBusyUntil) {
                    cameronBusyUntil = activity.endTime;
                    isAssignedToCameron[index] = true;
                }else if(activity.startTime >= jamieBusyUntil){
                    jamieBusyUntil = activity.endTime;
                }else{
                    impossible = true;
                    break;
                }
                index++;
            }

            if(impossible){
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }else{
                boolean[] sortedIsAssignedToCameron = sort(isAssignedToCameron, activities, originalOrder);
                StringBuilder sb = new StringBuilder("Case #");
                sb.append((testCase + 1));
                sb.append(": ");
                for(boolean b: sortedIsAssignedToCameron){
                    if(b){
                        sb.append("C");
                    }else{
                        sb.append("J");
                    }
                }
                System.out.println(sb);
            }

        }
        sc.close();
    }

    private static boolean[] sort(boolean[] isAssignedToCameron, List<Activity> activities, List<Activity> originalOrder) {
        boolean[] result = new boolean[isAssignedToCameron.length];
        for(int i = 0; i<isAssignedToCameron.length; i++){
            int pos = originalOrder.lastIndexOf(activities.get(i));
            result[pos] = isAssignedToCameron[i];
        }
        return result;
    }
}

class Activity implements Comparable<Activity> {
    int startTime;
    int endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Activity activity) {
        return Integer.compare(this.startTime, activity.startTime);
    }

    @Override
    public String toString() {
        return startTime + " " + endTime;
    }
}
