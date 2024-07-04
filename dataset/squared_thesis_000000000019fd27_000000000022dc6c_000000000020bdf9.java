import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class MyActivity{
    public MyActivity(int id, int startTime, int endTime){
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.assignee = "NONE";
    }
    int id;
    int startTime;
    int endTime;
    String assignee;
    public boolean equals(MyActivity activity){
        if(this.id == activity.id) return true;
        return false;
    }
}

class MyTestCase{
    public MyTestCase(List<MyActivity> activities){
        this.activities = activities;
    }
    List<MyActivity> activities;
}

public class Solution {

    private static List<MyTestCase> testCases = new ArrayList<>();
    private static List<String> solutionList = new ArrayList<>();

    public static void main(String[] arg){
        setDataFromUserInput();
        setOutputList();
        printOutput();
    }

    private static void setOutputList(){
        for(int i = 0; i< testCases.size(); i++){
            List<MyActivity> sortedActivities = sortActivities(new ArrayList<>(testCases.get(i).activities));
            List<MyActivity> assignedSortedActivities = assignParent(sortedActivities);
            solutionList.add(getSolutionForActivityList(testCases.get(i).activities, assignedSortedActivities));
        }
    }

    private static String getSolutionForActivityList(List<MyActivity> activities, List<MyActivity> sortedActivities){
        String solution = "";
        for(MyActivity sortedActivity : sortedActivities){
            for(MyActivity activity : activities){
                if(sortedActivity.equals(activity)){
                    activity.assignee = sortedActivity.assignee;
                }
            }
        }
        for(int i=0; i<activities.size(); i++){
            if(activities.get(i).assignee.equalsIgnoreCase("NONE")){
                return "IMPOSSIBLE";
            }
            solution = solution + activities.get(i).assignee;
        }
        return solution;
    }

    private static List<MyActivity> assignParent(List<MyActivity> activities){
        int cFreeTime = 0, jFreeTime = 0;
        for(int i = 0; i < activities.size(); i++){
            if(activities.get(i).startTime >= cFreeTime){
                activities.get(i).assignee = "C";
                cFreeTime = activities.get(i).endTime;
            }else if(activities.get(i).startTime >= jFreeTime){
                activities.get(i).assignee = "J";
                jFreeTime = activities.get(i).endTime;
            }else{
                break;
            }
        }
        return activities;
    }

    private static List<MyActivity> sortActivities(List<MyActivity> activities){
        for(int i=0; i<activities.size(); i++){
            for(int j=i+1; j<activities.size(); j++){
                if(activities.get(i).startTime > activities.get(j).startTime){
                    MyActivity temp = activities.get(i);
                    activities.set(i, activities.get(j));
                    activities.set(j, temp);
                }
            }
        }
        return activities;
    }

    private static void setDataFromUserInput(){

        Scanner scan = new Scanner(System.in);

        int numberOfTestCases = scan.nextInt();
        for(int i=0; i<numberOfTestCases; i++){
            int numberOfActivities = scan.nextInt();
            scan.nextLine();

            List<MyActivity> activityList = new ArrayList<>();
            for(int j = 0; j< numberOfActivities; j++){
                String timing = scan.nextLine();
                String[] tokens = timing.split(" ");
                activityList.add(new MyActivity(j, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
            testCases.add(new MyTestCase(activityList));
        }

    }

    private static void printOutput(){
        for(int i=0; i<solutionList.size(); i++){
            System.out.println("Case #"+(i+1)+": "+solutionList.get(i));
        }
    }

}
