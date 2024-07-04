
import java.lang.reflect.Array;
import java.util.*;

class Activity {
    private final int START_TIME;
    private final int END_TIME;
    private char owner;

    Activity(int start_time, int end_time) {
        START_TIME = start_time;
        END_TIME = end_time;
    }

    public int getSTART_TIME() {
        return START_TIME;
    }

    public int getEND_TIME() {
        return END_TIME;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
    }
}

public class Solution {

    private static Scanner scanner;

    private static Comparator<Activity> byStart = Comparator.comparing(Activity::getSTART_TIME);
    private static Comparator<Activity> byEnd = Comparator.comparing(Activity::getEND_TIME);

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        parentingPartneringReturns();
    }

    private static void parentingPartneringReturns(){
        int N;
        int T = scanner.nextInt();
        scanner.nextLine();
        boolean isPossible;
        Stack<Character> free = new Stack<>();
        Activity[] activities, activitiesSortedOnStartTime, activitiesSortedOnEndTime;
        for (int t = 1; t <= T; t++){
            N = scanner.nextInt();
            activities = new Activity[N];
            for (int n = 0; n < N; n++){
                activities[n] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            activitiesSortedOnEndTime = activities.clone();
            activitiesSortedOnStartTime = activities.clone();
            Arrays.sort(activitiesSortedOnStartTime, byStart);
            Arrays.sort(activitiesSortedOnEndTime, byEnd);
            int i =0;
            int j =0;
            free.clear();
            free.push('C');
            free.push('J');
            isPossible = true;
            while (i<N){
                if(activitiesSortedOnStartTime[i].getSTART_TIME() < activitiesSortedOnEndTime[j].getEND_TIME()){
                    if(free.isEmpty()){
                        isPossible = false;
                        break;
                    }
                    activitiesSortedOnStartTime[i].setOwner(free.pop());
                    i++;
                } else {
                    free.push(activitiesSortedOnEndTime[j].getOwner());
                    j++;
                }
            }
            if(isPossible){
                System.out.print("Case #"+ t +": ");
                for (Activity activity : activities){
                    System.out.print(activity.getOwner());
                }
                System.out.println();
            } else
                System.out.println("Case #"+ t +": IMPOSSIBLE");
        }
    }
}
