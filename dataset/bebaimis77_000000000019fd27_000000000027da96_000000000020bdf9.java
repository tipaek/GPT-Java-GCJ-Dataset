import java.util.*;
import java.io.*;

class Activity{
    private int activityNo;
    private int startTime;
    private int endTime;

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
    public void setStartTime(int time){
        startTime = time;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public int getActivityNo(){
        return activityNo;
    }
    public void setActivityNo(int no){
        activityNo=no;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=scanner.nextInt();
        for(int z=1;z<=T;z++) {
            int N; //activities

            ArrayList<Activity> data = new ArrayList<Activity>();
            ArrayList<Activity> cameronActivities = new ArrayList<Activity>();
            ArrayList<Activity> jamieActivities = new ArrayList<Activity>();

            N = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                Activity activity = new Activity();
                int activityStart = scanner.nextInt();
                activity.setStartTime(activityStart);
                int activityEnds = scanner.nextInt();
                activity.setEndTime(activityEnds);
                activity.setActivityNo(i);
                data.add(activity);
            }

           
            bubbleSort(data);

            
            boolean flag = true;
            char[] res = new char[100000];
            for (int i = 0; i < N; i++) {
                Activity activity = data.get(i);
                if (isValid(activity, cameronActivities)) {
                    cameronActivities.add(activity);
                    res[activity.getActivityNo()] = 'C';
                } else if (isValid(activity, jamieActivities)) {
                    jamieActivities.add(activity);
                    res[activity.getActivityNo()] = 'J';
                } else {//impossible
                    System.out.println("Case #"+z+": IMPOSSIBLE");
                    flag = false;
                }
            }
            if(flag) {
                System.out.print("Case #" + z + ": ");
                for (int i = 0; i < N; i++) {
                    System.out.print(res[i]);
                }
            }
            System.out.println();
        }
    }

    static private boolean isValid(Activity activity, ArrayList<Activity> arrayList){
        for(int i=0;i<arrayList.size();i++){
             if ((arrayList.get(i).getStartTime() <= activity.getStartTime()) && (activity.getStartTime()<arrayList.get(i).getEndTime())) { //start pakliuna itervale
                 return false;
             }
             if ((arrayList.get(i).getStartTime() < activity.getEndTime()) && (activity.getEndTime()<=arrayList.get(i).getEndTime())){ //end pakliuna i panaudota intervala
                 return false;
             }
             if ((arrayList.get(i).getStartTime() > activity.getStartTime()) && (activity.getEndTime() > arrayList.get(i).getEndTime())){ // naujas ivykis "uzkloja" jau paskirta
                 return false;
             }
        }
        return true;
    }

    static void bubbleSort(ArrayList<Activity> array)
    {
        int i, j;
        for (i = 0; i < array.size()-1; i++) {
            // Last i elements are already in place
            for (j = i+1; j < array.size(); j++)
                if (array.get(i).getStartTime() > array.get(j).getStartTime()) {
                    Activity temp = array.get(i);
                    Activity temp1 = array.get(j);
                    array.set(j, temp);
                    array.set(i, temp1);
                }
        }
    }

    static void bubbleSortByActivityNo(ArrayList<Activity> array)
    {
        int i, j;
        for (i = 0; i < array.size()-1; i++) {
            // Last i elements are already in place
            for (j = 0; j < array.size() - i - 1; j++)
                if (array.get(j).getActivityNo() > array.get(j + 1).getActivityNo()) {
                    Activity temp = array.get(j);
                    Activity temp1 = array.get(j+1);
                    array.set(j+1,temp );
                    array.set(j, temp1);
                }
        }
    }
}