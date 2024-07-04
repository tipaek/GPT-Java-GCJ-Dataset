
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t-1; ++i) {
            int J = 1;
            int C = 2;
            int BOTH_ARE_FREE = -1;
            int J_IS_FREE = 1;
            int C_IS_FREE = 0;

            int activities = in.nextInt();
            String schedule = "";
            int[] minuteOfTheDay = new int[25*60];
            Arrays.fill(minuteOfTheDay,-1);

            for (int activityCount = 0; activityCount < activities; activityCount++) {
                int WHO_IS_FREE = BOTH_ARE_FREE;
                int s = in.nextInt();
                int e = in.nextInt();
                for(int k = s; k<=e;k++){
                    if(minuteOfTheDay[k]<=WHO_IS_FREE){
                        continue;
                    }
                    else{

                        if(minuteOfTheDay[k]==C_IS_FREE){
                            WHO_IS_FREE=C_IS_FREE;
                            continue;
                        }
                        else if(minuteOfTheDay[k]==J_IS_FREE){
                            WHO_IS_FREE=J_IS_FREE;
                            continue;
                        }
                        else{
                            // WHO_IS_FREE==J_IS_FREE || WHO_IS_FREE==C_IS_FREE) at some point of time between start and end.
                            // Both of them were occupied at some point of time
                            if(minuteOfTheDay[k]==2 && (k==e || k==s)){
                                continue;
                            }
                            WHO_IS_FREE = minuteOfTheDay[k];
                            break;
                        }
                    }
                }
                if(WHO_IS_FREE==BOTH_ARE_FREE || WHO_IS_FREE==C_IS_FREE){
                    schedule = schedule+ "C";
                    updateSchedule(minuteOfTheDay,s,e,C);
                }
                else if(WHO_IS_FREE==J_IS_FREE){
                    schedule = schedule + "J";
                    updateSchedule(minuteOfTheDay,s,e,J);
                }
                else{
                    schedule="IMPOSSIBLE";
                    break;
                }

            }
            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static void updateSchedule(int[] minuteOfTheDay, int s, int e, int scheduledFor) {
        for(int k = s; k<=e;k++){
            minuteOfTheDay[k] = minuteOfTheDay[k]+scheduledFor;
        }
    }


}

