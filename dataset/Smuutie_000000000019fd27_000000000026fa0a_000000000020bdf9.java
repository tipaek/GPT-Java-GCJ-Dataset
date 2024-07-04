import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfActivities = Integer.parseInt(br.readLine().trim());
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
                activities.add(readActivity(br));
            }
            results.add("Case #" + (i + 1) + ": " + assignActivities(activities));
        }
        br.close();
        results.forEach(System.out::println);
    }

    private static String assignActivities(List<Activity> activities) {
        StringBuilder builder = new StringBuilder();
        List<Activity> copy = new ArrayList<>(activities);
        copy.sort(Comparator.comparing(Activity::getStartTime));
        if (!checkPossible(copy)) {
            
        }
        for (int i = 0; i < activities.size() - 1; i++) {
            Activity activity = activities.get(i);
            if(activity.getAssigned()!= null){
                continue;
            } else {
                activity.assign('C');
            }
            List<Activity> overLapped = new ArrayList<>();
            for(int j = i; j<activities.size();j++){
                Activity otherActivity = activities.get(j);
                if(!activity.equals(otherActivity) && activity.overLap(otherActivity)){
                    overLapped.add(otherActivity);
                    otherActivity.assign('J');
                }
            }
            for(Activity overLap: overLapped){
                for(Activity otherOverlap : overLapped){
                    if(activity.equals(otherOverlap)
                            && !overLap.equals(otherOverlap)
                            && overLap.overLap(otherOverlap)){
                        return "IMPOSSIBLE";
                    }
                }
            }
            
        }
        activities.forEach(a -> builder.append(a.toString()));
        return builder.toString();
    }

    private static Activity readActivity(BufferedReader br) throws IOException {
        List<Integer> collect = Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        return new Activity(collect.get(0), collect.get(1));
    }

    static boolean checkPossible(List<Activity> activities) {
        if (activities.size() < 3) {
            return true;
        }
        
        return true;
    }

    static class Activity {

        Integer startTime;
        Integer endTime;
        Character assigned;

        public Activity(Integer startTime, Integer endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        boolean overLap(Activity activity) {
            return (this.endTime > activity.startTime && activity.startTime > this.startTime)
                    || (this.startTime < activity.startTime && activity.startTime < this.endTime);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Activity) {
                Activity a = (Activity) o;
                return Objects.equals(a.startTime, this.startTime) && Objects.equals(a.endTime, this.endTime);
            }
            return false;
        }

        @Override
        public String toString() {
            return this.assigned.toString();
        }

        void assign(Character c) {
            this.assigned = c;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
        }

        public Character getAssigned() {
            return assigned;
        }

        public void setAssigned(Character assigned) {
            this.assigned = assigned;
        }
    }
}