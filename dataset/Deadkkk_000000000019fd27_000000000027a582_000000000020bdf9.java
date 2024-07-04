import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {



    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        int noOfActivities = 0;
        List<Integer> nos = new ArrayList<>();
        List<Activity> activities;
        List<Activity> originalActivities;
        Activity activity;
        List<List<Activity>> tActivities = new ArrayList<>();
        List<List<Activity>> otActivities = new ArrayList<>();

        for(int i =0; i< noOfTestCases; i++)
        {
            noOfActivities = sc.nextInt();
            nos.add(noOfActivities);
            activities = new ArrayList<>();
            originalActivities = new ArrayList<>();
            tActivities.add(activities);
            otActivities.add(originalActivities);
            for(int j =0; j< noOfActivities; j++)
            {
                activity = new Activity(sc.nextInt(),sc.nextInt());
                activities.add(activity);
                originalActivities.add(activity);
            }

        }

        for(int i =0; i< noOfTestCases; i++)
        {
            noOfActivities = nos.get(i);
            activities = tActivities.get(i);
            originalActivities =otActivities.get(i);
            if(plan(noOfActivities,activities))
            {
                System.out.println("Case #"+(i+1) +": " + displayPlan(originalActivities));
            }
            else
            {
                System.out.println("Case #"+(i+1) +": IMPOSSIBLE");
            }
        }
    }

    private static String displayPlan(List<Activity> activities) {
        StringBuilder b = new StringBuilder("");
        for(Activity activity : activities)
        {
            b.append(activity.tag);
        }
        return b.toString();
    }

    private static boolean plan(int noOfActivities, List<Activity> activities)
    {
        Collections.sort(activities, new ActivityComparator());
        Activity C = new Activity(0,0);
        Activity J = new Activity(0,0);
        for(Activity activity : activities)
        {
            if(activity.startTime >= C.endTime)
            {
                activity.setTag("C");
                C.endTime = activity.endTime;
            }
            else if(activity.startTime >= J.endTime)
            {
                activity.setTag("J");
                J.endTime = activity.endTime;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}

class ActivityComparator implements Comparator<Activity> {

    @Override
    public int compare(Activity activity, Activity t1) {
        if(activity.startTime >= t1.startTime)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}

class Activity
{
    int startTime = 0;
    int endTime = 0;
    String tag;

    Activity(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    void setTag(String tag) {
        this.tag = tag;
    }
}
