import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Activity  [] activities = new Activity[n];
            for(int k =0 ; k<n ;k++){
                int start = in.nextInt();
                int end = in.nextInt();
                Activity activity = new Activity(start,end,k);
                //System.out.println(activity);
                activities[k] = activity;
            }
            findPattern(activities);
            StringBuilder builder= new StringBuilder();
            boolean ans = false;
            Arrays.sort(activities, Comparator.comparingInt(o -> o.index));
            for(Activity activity : activities){
                if(activity.assign =='I'){
                    ans = true;
                    break;
                }
                builder.append(activity.assign);
            }

            System.out.println("Case #" + i + ": "+(ans ?"IMPOSSIBLE":builder.toString()));
        }


    }

    private static void findPattern(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(o -> o.end));
        int i=0;
        activities[i].assign ='C';
        for(int j =1;j< activities.length;j++){
            if(activities[j].start>= activities[i].end){
                activities[j].assign = 'C';
                i=j;
            }
        }
        Activity init = null;
        for(int j =0 ; j< activities.length;j++){
            if(activities[j].assign == 'I' ){
                init= activities[j];
                init.assign = 'J';
                break;
            }
        }
        if(init == null){
            return;
        }
        for(int j =0 ; j< activities.length;j++){
            if(activities[j].assign == 'I' && init.end  <= activities[j].start ){
                activities[j].assign ='J';
                init= activities[j];
            }
        }


    }


    static class Activity{
        int start;
        int end;
        char assign = 'I';
        int index ;

        public Activity(int start, int end, int  i) {
            this.start = start;
            this.end = end;
            this.index = i;
        }

       
    }


}