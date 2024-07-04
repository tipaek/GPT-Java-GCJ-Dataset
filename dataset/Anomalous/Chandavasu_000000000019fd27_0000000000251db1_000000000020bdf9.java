import java.util.ArrayList;
import java.util.Scanner;

class Activity {
    private final int startMin;
    private final int endMin;
    
    public Activity(int startMin, int endMin) {
        this.startMin = startMin;
        this.endMin = endMin;
    }
    
    public boolean isValid(Activity activity) {
        return (endMin <= activity.startMin || startMin >= activity.endMin) && !(startMin == activity.startMin && endMin == activity.endMin);
    }
    
    public int getStartMin() {
        return startMin;
    }
    
    public int getEndMin() {
        return endMin;
    }
}

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < n; i++) {
            StringBuilder actvStrb = new StringBuilder();
            int nActv = Integer.parseInt(in.nextLine());
            ArrayList<Activity> cActivities = new ArrayList<>();
            ArrayList<Activity> jActivities = new ArrayList<>();
            
            for (int j = 0; j < nActv; j++) {
                String[] actv = in.nextLine().split("\\s");
                Activity activity = new Activity(Integer.parseInt(actv[0]), Integer.parseInt(actv[1]));
                
                boolean cJob = true;
                boolean jJob = true;
                
                for (Activity cActivity : cActivities) {
                    if (!cActivity.isValid(activity)) {
                        cJob = false;
                        break;
                    }
                }
                
                if (cJob) {
                    actvStrb.append("C");
                    cActivities.add(activity);
                } else {
                    for (Activity jActivity : jActivities) {
                        if (!jActivity.isValid(activity)) {
                            jJob = false;
                            break;
                        }
                    }
                    
                    if (jJob) {
                        actvStrb.append("J");
                        jActivities.add(activity);
                    } else {
                        actvStrb.setLength(0);
                        actvStrb.append("IMPOSSIBLE");
                        while (++j < nActv) {
                            in.nextLine();
                        }
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + actvStrb);
        }
    }
}