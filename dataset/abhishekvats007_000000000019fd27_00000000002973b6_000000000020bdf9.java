

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity{
        int startTime ;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalTestCases = scanner.nextInt();

        for (int i = 0; i < totalTestCases; i++) {
            int n = scanner.nextInt();
            List<Activity> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
               list.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            List<Activity> james = new LinkedList<>();
            List<Activity> cameroon = new LinkedList<>();
            StringBuilder task = new StringBuilder();
            for (Activity act:
                 list) {
                     {
               
                boolean flag = false;
                if(james.isEmpty()){
                    flag = true;
                }else{
                    for (Activity jame:
                        james ) {
                        if (act.endTime <= jame.startTime || act.startTime >= jame.endTime) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    james.add(act);
                    task.append("J");
                }

                if(!flag){
                    if(cameroon.isEmpty())
                        flag = true;
                    else {
                        for (Activity cam:
                             cameroon) {
                            if (act.endTime <= cam.startTime || act.startTime >= cam.endTime) {
                                flag = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag) {
                        cameroon.add(act);
                        task.append("C");
                    }
                }

                if(!flag){
                    task = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }
                 }
            System.out.printf("Case #%d: %s %n", i + 1, task);
        }
    }
}
