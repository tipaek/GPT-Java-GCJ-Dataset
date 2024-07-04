import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> resultList = new ArrayList<>();
        while(testCases-->0) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            while(n-->0) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            resultList.add(solveProblem(activities));
        }
        int count = 0;
        for(String result: resultList) {
            System.out.println("Case #"+ ++count +": "+result);
        }
    }

    private static String solveProblem(List<Activity> activities) {

        // Sort by activity
        List<Activity> sortedActivities = activities.stream().sorted(Comparator.comparingInt(Activity::getDuration).reversed()).collect(Collectors.toList());

        Schedule jSchedule = new Schedule();
        Schedule cSchedule = new Schedule();

        for(Activity activity:sortedActivities) {
            if(!cSchedule.bookActivity(activity) && !jSchedule.bookActivity(activity))
            return "IMPOSSIBLE";
        }

        return activities.stream().map(activity -> jSchedule.activities.contains(activity)?"J":"C").reduce((a,b)->a+b).get();
    }

    static class Schedule{
        List<Activity> activities = new ArrayList<>();

        boolean bookActivity(Activity newActivity) {
            for(Activity activity: activities) {
                if (activity.startTime<=newActivity.startTime && activity.endTime>newActivity.startTime) return false;
                if (activity.startTime<newActivity.endTime && activity.endTime>=newActivity.endTime) return false;
                if (activity.startTime>=newActivity.startTime && activity.endTime<=newActivity.endTime) return false;
            }
            activities.add(newActivity);
            return true;
        }
    }

    static class Activity{
        int startTime;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int getDuration(){
            return endTime-startTime;
        }
    }



}
