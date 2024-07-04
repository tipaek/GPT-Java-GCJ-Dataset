import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x = 1;
        while (T > 0) {
            int n = sc.nextInt();
            ActivityTime[] activityTimes =new ActivityTime[n];
            int sC = -1;
            int eC = -1;
            int sJ = -1;
            int eJ = -1;
            char chars[] =new char[n];
            for (int i = 0; i < n; i++) {
                activityTimes[i]=new ActivityTime(sc.nextInt(),sc.nextInt(),i);
            }
            sortActivities(activityTimes,n);
            for(int i=0;i<n;i++){
                //System.out.println(activityTimes[i].toString());
                if(eC<=activityTimes[i].startTime){
                    eC=activityTimes[i].endTime;
                    sC=activityTimes[i].startTime;
                    chars[activityTimes[i].index]='C';
                }
                else if(eJ<=activityTimes[i].startTime){
                    eJ=activityTimes[i].endTime;
                    sJ=activityTimes[i].startTime;
                    chars[activityTimes[i].index]='J';
                }
            }
            String output="";
            for(int i=0;i<n;i++){
                if(chars[i]=='C' || chars[i]=='J'){
                    output+=chars[i];
                }
            }
            if (output.length()==n) {
                System.out.println("Case #" + x + ": " + output);
            } else {
                System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
            }
            T--;
            x++;
        }
    }
    public static void sortActivities(ActivityTime[] activityTimes,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(activityTimes[i].startTime>activityTimes[j].startTime){
                    ActivityTime temp=activityTimes[j];
                    activityTimes[j]=activityTimes[i];
                    activityTimes[i]=temp;
                }
            }
        }
    }

}
class ActivityTime {
    int startTime;
    int endTime;
    int index;
    public ActivityTime(int startTime, int endTime, int index){
        this.endTime=endTime;
        this.startTime=startTime;
        this.index=index;
    }

    @Override
    public String toString() {
        return "ActivityTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", index=" + index +
                '}';
    }
}