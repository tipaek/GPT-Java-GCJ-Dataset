

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

        for (int i = 0; i < totalTestCases; i++) {
            LinkedList<Activity> james = new LinkedList<>();
            LinkedList<Activity> cameroon = new LinkedList<>();
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                boolean flag = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                if(james.isEmpty()){
                    flag = true;
                }else {
                    for (Activity jame :
                            james) {
                        if (endTime <= jame.startTime || jame.endTime <= startTime) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    stringBuilder.append("J");
                    james.add(activity);

                }

                if (!flag) {
                    if (cameroon.isEmpty()) {
                        flag = true;
                    } else {
                        for (Activity jame :
                                cameroon) {
                            if (endTime <= jame.startTime || jame.endTime <= startTime) {
                                flag = true;
                            }else {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if(flag) {
                        stringBuilder.append("C");
                        cameroon.add(activity);
                    }


                }

                if (!flag) {
                    stringBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }
            System.out.printf("Case #%d: %s %n", i + 1, stringBuilder);
        }
    }
}
