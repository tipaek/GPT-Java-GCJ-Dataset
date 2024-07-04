import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int counter = 1;
        while (t-- > 0){
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            for(int i=0;i<n;i++){
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                activities[i] = new Activity(i,s,e);
            }
            Arrays.sort(activities,new SortByStartTime());
            String result = schedule(activities);
            System.out.println("Case #" + counter + ": " + result);
            counter++;
        }
    }

    public static String schedule(Activity[] activities){
        int n = activities.length;
        char[] result = new char[n];
        int cameron = 0;
        int jamie = 0;

        for(int i=0;i<n;i++){
            if(cameron <= activities[i].startTime){
                cameron = activities[i].endTime;
                activities[i].whoDidIt = 'C';
            }
            else if(jamie <= activities[i].startTime){
                jamie = activities[i].endTime;
                activities[i].whoDidIt = 'J';
            }
            else{
                return "IMPOSSIBLE";
            }
        }

        for(int i=0;i<n;i++){
            result[activities[i].index] = activities[i].whoDidIt;
        }

        StringBuilder ans = new StringBuilder();

        for(char c : result){
            ans.append(c);
        }

        return ans.toString();
    }
}

class SortByStartTime implements Comparator<Activity>{
    public int compare(Activity a,Activity b){
        return a.startTime - b.startTime;
    }
}

class Activity{
    int index;
    int startTime;
    int endTime;
    char whoDidIt;
    public Activity(int i, int s,int e){
        index = i;
        startTime = s;
        endTime = e;
    }
}