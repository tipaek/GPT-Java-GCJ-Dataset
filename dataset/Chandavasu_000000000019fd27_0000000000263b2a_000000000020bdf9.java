import java.lang.*;
import java.util.*;

class Activity {
    private int startMin;
    private int endMin;
    
    public Activity(int startMin, int endMin) {
        this.startMin = startMin;
        this.endMin = endMin;
        
        //System.out.println(startMin + " " + endMin);
    }
    
    public boolean isValid(Activity activity) {
       // System.out.println(endMin + " " + activity.getStartMin());
        /*if(((endMin <= activity.getStartMin()) || (startMin >= activity.getEndMin())) && !((startMin == activity.getStartMin()) && (endMin == activity.getEndMin()))) {
            //System.out.println(endMin + " " + activity.getStartMin());
            return true;
        } */
        
        if((endMin <= activity.getStartMin() || activity.getEndMin() <= startMin) && !((startMin == activity.getStartMin()) && (endMin == activity.getEndMin()))) {
            
            return true;
        }
        
        return false;
    }
    
    public int getStartMin() {
        
        return startMin;
    }
    
    public int getEndMin() {
        return endMin;
    }
}

public class Solution {
    
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        for(int i = 0; i < n; i++) {
         
            StringBuilder actvStrb = new StringBuilder();
            
            int nActv = in.nextInt();
            ArrayList<Activity> cActivities = new ArrayList<Activity>();
            ArrayList<Activity> jActivities = new ArrayList<Activity>();
            
            for(int j = 0; j < nActv; j++) {

                Activity activity = new Activity(in.nextInt(), in.nextInt());
                
                boolean cJob = true;
                boolean jJob = true;
                for(int c = 0; c < Math.max(cActivities.size(), jActivities.size()); c++) {
                    
                    if((c < cActivities.size()) && !cActivities.get(c).isValid(activity)) {
                        cJob = false;
                    }
                    
                    if((c < jActivities.size()) && !jActivities.get(c).isValid(activity)) {
                        jJob = false;
                    }
                    
                    if(!cJob && !jJob) {
                        break;
                    }
                }
                
                if(cJob) {
                    
                    actvStrb.append("c") ;
                    cActivities.add(activity);
                } else if(jJob) {
                    actvStrb.append("j");
                    jActivities.add(activity);
                   
                } else {
                        //System.out.println(actvStrb.toString());
                    actvStrb.delete(0, actvStrb.length());
                    actvStrb.append("IMPOSSIBLE");
                    
                    j++;
                    while(j < nActv) {
                        in.nextInt();
                        in.nextInt();
                        j++;
                    }
                    
                    break;
                }
            }
            
            System.out.println("Case #" + (i+1) + ": " + actvStrb.toString());   
        }
    }
}