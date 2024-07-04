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
        
        if(((endMin <= activity.getStartMin()) || (startMin >= activity.getEndMin())) && !((startMin == activity.getStartMin()) && (endMin == activity.getEndMin()))) {
            //System.out.println(endMin + " " + activity.getStartMin());
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
        
        int n = Integer.parseInt(in.nextLine());
        
        for(int i = 0; i < n; i++) {
         
            StringBuilder actvStrb = new StringBuilder();
            
            int nActv = Integer.parseInt(in.nextLine());
            ArrayList<Activity> cActivities = new ArrayList<Activity>();
            ArrayList<Activity> jActivities = new ArrayList<Activity>();
            
            for(int j = 0; j < nActv; j++) {

                String actvIp = in.nextLine();
                String actv[] = actvIp.split("\\s");
                Activity activity = new Activity(Integer.parseInt(actv[0]), Integer.parseInt(actv[1]));
                
                boolean cJob = true;
                boolean jJob = true;
                for(int c = 0; c < cActivities.size(); c++) {
                    
                    if(! cActivities.get(c).isValid(activity)) {
                        cJob = false;
                        break;
                    }
                }
                
                if(cJob) {
                    
                    actvStrb.append("C") ;
                    cActivities.add(activity);
                } else {
                    for(int c = 0; c < jActivities.size(); c++) {
                    
                        if(! jActivities.get(c).isValid(activity)) {
                            jJob = false;
                            break;
                        }
                    }
                    
                    if(jJob) {
                        actvStrb.append("J");
                        jActivities.add(activity);
                   
                    } else {
                        //System.out.println(actvStrb.toString());
                        actvStrb.delete(0, actvStrb.length());
                        actvStrb.append("IMPOSSIBLE");
                        
                        j++;
                        while(j < nActv) {
                            in.nextLine();
                            j++;
                        }
                        
                        break;
                    }
                }
                
                
            }
            
            System.out.println("Case #" + (i+1) + ": " + actvStrb.toString());   
        }
    }
}