import java.util.*;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int counter = 0; counter < n; counter++) {
            int numberOfActivities = Integer.parseInt(in.nextLine());
            List<Activity> activityList = new ArrayList<>();
            for(int i = 0; i < numberOfActivities; i++){
                activityList.add(new Activity(in.nextLine(), i));
            }

            System.out.print("Case #" + (counter + 1) + ": ");
            List<Activity> sortedActivityList = new ArrayList<>(activityList);
            Collections.sort(sortedActivityList);

            int[] endTime = {0, 0};
            String result = new String();
            for(Activity activity: sortedActivityList) {
                feasible(activity, endTime);
            }
            
            for(Activity activity: activityList) {
                if(activity.getParent() != null) result += activity.getParent();
                else{
                    result = "IMPOSSIBILE";
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static void feasible(Activity activity, int[] endTime){
        if(endTime[0] <= activity.getStart()){
            endTime[0] = activity.getEnd();
            activity.setParent('C');
            return;
        }
        if(endTime[1] <= activity.getStart()){
            endTime[1] = activity.getEnd();
            activity.setParent('J');
            return;
        }
        activity.setParent(null);
    }

    public static class Activity implements Comparable<Activity>{
        private int index;
        private int start;
        private int end;
        private Character parent;

        Activity(String properties, int index){
            this.index = index;
            this.start = Integer.parseInt(properties.split(" ")[0]);
            this.end = Integer.parseInt(properties.split(" ")[1]);
        }

        int getStart() {
            return start;
        }

        int getEnd(){
            return  end;
        }

        void setParent(Character parent){
            this.parent = parent;
        }

        public Character getParent() {
            return parent;
        }

        public int getIndex() {
            return index;
        }

        public int compareTo(Activity otherActivity){
            return this.start - otherActivity.getStart();
        }
    }
}
