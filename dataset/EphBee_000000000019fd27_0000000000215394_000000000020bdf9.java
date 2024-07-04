import java.util.*;
import java.io.*;
public class Solution {
    
    static class Activity {
        int startTime;
        int endTime;
        int location;
        String executer;
        
        public static Comparator<Activity> originalComparator = new Comparator<Activity>() {
            public int compare(Activity a1, Activity a2) {
                return a1.location - a2.location;
            }
        };
        
        public static Comparator<Activity> timeComparator = new Comparator<Activity>() {
            public int compare(Activity a1, Activity a2) {
                return a1.startTime - a2.startTime;
            }
        };
    }
    
    static class User {
        String ID;
        int finishingTime;
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int count = in.nextInt();
    int caseID = 1;
    for(int e=0;e<count;e++) {
        int activitiesCount = in.nextInt();
        
        ArrayList <Activity> activities = new ArrayList<Activity>();
        for(int i=0;i<activitiesCount;i++) {
            Activity activ = new Activity();
            activ.startTime = in.nextInt();
            activ.endTime = in.nextInt();
            activ.location = i;
            activities.add(activ);
        }
        
        User cameron = new User(); 
        cameron.ID = "C"; cameron.finishingTime = -1;
        User jamie = new User();
        jamie.ID = "J"; jamie.finishingTime = -1;
        
        Collections.sort(activities, Activity.timeComparator);
        String finalResult = "";
        for(int i=0;i<activitiesCount;i++) {
            Activity activ = activities.get(i);
            if(activ.startTime >= cameron.finishingTime) {
                finalResult += cameron.ID; cameron.finishingTime = activ.endTime;
            } else if(activ.startTime >= jamie.finishingTime) {
                finalResult += jamie.ID; jamie.finishingTime = activ.endTime;
            } else {
                finalResult = "IMPOSSIBLE";
                break;
            }
        }
        
        System.out.println("Case #" + caseID + ": " + finalResult);
        caseID += 1;
    }
  }
}