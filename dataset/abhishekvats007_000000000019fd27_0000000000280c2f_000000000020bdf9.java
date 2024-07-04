

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();

        for (byte i = 0; i < totalTestCases; i++) {
            LinkedList<Activity> james = new LinkedList<>();
            LinkedList<Activity> cameroon = new LinkedList<>();
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            james.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            stringBuilder.append("J");
            for (byte j = 1; j < n; j++) {
                boolean flag = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime,endTime);
                    for (Activity jame:
                         james) {
                        if(endTime <= jame.startTime || jame.endTime <= startTime){
                            james.add(activity);
                            stringBuilder.append("J");
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        if(cameroon.isEmpty()) {
                            cameroon.add(activity);
                            stringBuilder.append("C");
                            flag = true;
                        }else{
                        for (Activity jame:
                                cameroon) {
                            if(endTime <= jame.startTime || jame.endTime <= startTime){
                                james.add(activity);
                                stringBuilder.append("C");
                                flag = true;
                                break;
                            }
                        }
                    }



                }

                if(!flag) {
                    stringBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }
            System.out.printf("Case #%d: %s %n",i+1,stringBuilder);
        }
    }
}
