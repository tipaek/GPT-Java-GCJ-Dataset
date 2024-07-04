

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                List<LocalTime> startTimes = new ArrayList<>();
                List<LocalTime> endTimes = new ArrayList<>();
                int activitiesNum = in.nextInt();
                for (int i = 0; i < activitiesNum; i++) {
                    int startMins = in.nextInt();
                    int hours = startMins / 60;
                    int minutes = startMins % 60;
                    startTimes.add(LocalTime.of(hours, minutes));
                    int endMins = in.nextInt();
                    int endHours = endMins / 60;
                    int endMinutes = endMins % 60;
                    if (endHours == 24) {
                        endHours = 23;
                        endMinutes = 59;
                    }
                    endTimes.add(LocalTime.of(endHours, endMinutes));
                }
                String result = "";
                String[] resultArr = new String[activitiesNum];
                resultArr[0] = "C";
                outer: for (int i = 0; i < startTimes.size() - 1; i++) {
                    int overlaps = 0;
                    for (int j = i; j < startTimes.size() - 1; j++) {
                        LocalTime startA = startTimes.get(j);
                        LocalTime stopA = endTimes.get(j);
                        LocalTime startB = startTimes.get(j + 1);
                        LocalTime stopB = endTimes.get(j + 1);
                        if (startA.isBefore(stopB) && stopA.isAfter(startB)) {
                            overlaps++;
                            if(resultArr[j] !=null) {
                                if(resultArr[j].equals("C")) {
                                    resultArr[j+1]="J";
                                } else {
                                    resultArr[j+1]="C";
                                }
                            }
                        }
                        if (overlaps > 1) {
                            result = "IMPOSSIBLE";
                            break outer;
                        }
                    }
                }
                if (!result.equalsIgnoreCase("IMPOSSIBLE")) {
                    /*StringBuilder sb = new StringBuilder("C");
                    for (int j = 0; j < startTimes.size() - 1; j++) {
                        if(resultArr[j].equals(null)) {
                            resultArr[j]="C";
                        }
                        LocalTime startA = startTimes.get(j);
                        LocalTime stopA = endTimes.get(j);
                        LocalTime startB = startTimes.get(j + 1);
                        LocalTime stopB = endTimes.get(j + 1);
                        if (startA.isBefore(stopB) && stopA.isAfter(startB)) {
                            if (sb.substring(sb.length()-1, sb.length()).equalsIgnoreCase("C")) {
                                sb.append("J");
                            } else {
                                sb.append("C");
                            }
                        } else {
                            sb.append("C");
                        }
                    }*/
                    for (int j = 0; j < startTimes.size(); j++) {
                        if(resultArr[j]==null) {
                            resultArr[j]="C";
                        }
                    }
                    result = String.join("", resultArr);
                }
                System.out.println("Case #" + t + ": " + result);
            }
        } finally {
            in.close();
        }
    }

}
