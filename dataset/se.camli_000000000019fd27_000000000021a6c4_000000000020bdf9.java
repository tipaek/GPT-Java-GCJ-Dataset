import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//     owner: sedatcamli
//     04.04.2020
public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        s.start();
    }

    public void start(){
        Scanner scanIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanIn.nextInt();
        for (int i = 1; i <= numberOfTestCases; i++) {
            List<Activity> activityList = new ArrayList<>();
            int activitiesNumber = scanIn.nextInt();
            for(int j = 0 ; j<activitiesNumber; j++){
                Activity activity = new Activity(j);
                int start = scanIn.nextInt();
                int end = scanIn.nextInt();
                activity.start = start;
                activity.end = end;
                activityList.add(activity);
            }
            List<Activity> jamieList = new ArrayList<>();
            List<Activity> cameronList = new ArrayList<>();
            boolean assigned = true;
            activityList.sort(new DurationComparator());
            for(Activity activity : activityList){
                if(isApplicableForList(jamieList,activity)){
                    activity.owner = "J";
                    jamieList.add(activity);
                } else if(isApplicableForList(cameronList,activity)) {
                    activity.owner = "C";
                    cameronList.add(activity);
                } else {
                    System.out.println("Case #"+i+": "+ "IMPOSSIBLE");
                    assigned = false;
                    break;
                }
            }
            if(!assigned){
                continue;
            }
            activityList.sort(new IDComparator());
            StringBuilder sb = new StringBuilder();
            for(Activity activity : activityList){
                sb.append(activity.owner);
            }

            System.out.println("Case #"+i+": "+ sb.toString());
        }
    }

    public boolean isApplicableForList(List<Activity> activityList, Activity activitiy){
        if(activitiy.owner != null){
            return false;
        }
        for(int i = 0 ; i<activityList.size();i++){
            Activity scheduledActivity = activityList.get(i);
            if(activitiy.start >= scheduledActivity.start && activitiy.start< scheduledActivity.end || activitiy.end>=scheduledActivity.start && activitiy.end<scheduledActivity.end){
                return false;
            }
        }
        return true;
    }

    class Activity{
        int id;
        int  start;
        int end;
        int duration;
        String owner;

        Activity(int id){
            this.id = id;
        }

        void setTimes(int start, int end){
            this.start = start;
            this.end = end;
            duration = end-start;
        }
    }

    class DurationComparator implements Comparator<Activity>{

        @Override
        public int compare(Activity o1, Activity o2) {
            return o2.duration-o1.duration;
        }
    }

    class IDComparator implements Comparator<Activity>{

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.id-o2.id;
        }
    }
}
