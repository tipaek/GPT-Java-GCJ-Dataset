import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Set up input scanner
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        //Receive first line (How many cases?)
        int caseCount = in.nextInt();

        for(int i = 1; i <= caseCount; i++){
            //Pass input to question method
            Q_Two(i, in);
        }
    }

    public static void Q_Two(int ident, Scanner in){
        int N = in.nextInt();

        Comparator<Activity> indexOrder = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.index - o2.index;
            }
        };

        List<Activity> activities = new ArrayList<>();
        int[] cameron = new int[1440];
        int[] jamie = new int[1440];

        Arrays.fill(cameron, -1);
        Arrays.fill(jamie, -1);

        for(int i = 0; i < N; i++){
            int startTime = in.nextInt();
            int endTime = in.nextInt();

            activities.add(new Activity(i, startTime, endTime));
        }

        boolean cameronFail = false;
        boolean jamieFail = false;
        boolean allFail = false;
        Collections.sort(activities);

        for(Activity a : activities){
            allFail = false;
            cameronFail = false;
            jamieFail = false;

            for(int j = a.startTime; j < a.endTime; j++){
                if(cameron[j] != -1){
                    cameronFail = true;
                }
                if(jamie[j] != -1){
                    jamieFail = true;
                }
            }

            if(!cameronFail){
                a.name = 'C';
                Arrays.fill(cameron, a.startTime, a.endTime , a.index);
            }
            else if(!jamieFail){
                a.name = 'J';
                Arrays.fill(jamie, a.startTime, a.endTime , a.index);
            }
            else{
                allFail = true;
                Print_Result(ident, "IMPOSSIBLE");
                break;
            }
        }

        if(!allFail){
            String output = "";
            Collections.sort(activities, indexOrder);

            for(Activity a : activities){
                output += a.name;
            }

            Print_Result(ident, output);
        }




    }

    public static void Print_Result(int ident, String output){
        //Print result
        System.out.println("Case #" + ident + ": " + output);
    }
}

class Activity implements Comparable<Activity>{
    int index;
    int startTime;
    int endTime;
    char name;

    Activity(int index, int startTime, int endTime){
        this.index = index;
        this.startTime = startTime;
        this. endTime = endTime;
    }

    public int compareTo(Activity a){
        return this.startTime - a.startTime;
    }
}