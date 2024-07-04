import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<Activity>();
            List<Activity> copy = new ArrayList<Activity>();
            for(int i = 0 ; i < n ; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                Activity activity = new Activity(start,end);
                activities.add(activity);
                copy.add(activity);
            }
            activities.sort((a,b) -> a.start - b.start);
            int cEnd = 0 ;
            int jEnd = 0;
            StringBuffer ans = new StringBuffer();
            boolean isImpossible = false;
            for(Activity activity : activities){
                if(activity.start >= cEnd){
                    activity.setAssigned('C');
                    cEnd = activity.end;
                }
                else if(activity.start >= jEnd){
                    activity.setAssigned('J');
                    jEnd = activity.end;
                }
                else{
                    ans = new StringBuffer("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            if(!isImpossible){
                for(Activity original: copy){
                    ans.append(original.getAssigned());
                }
            }
            System.out.printf("\nCase #%d: %s",(x),ans);
        }
    }
}
class Activity
{
    int start;
    int end;
    char assigned;
    public Activity(int start, int end){
        this.start = start;
        this.end  = end;
    }
    public void setAssigned(char assigned){
        this.assigned = assigned;
    }
    public char getAssigned(){
        return this.assigned;
    }
}