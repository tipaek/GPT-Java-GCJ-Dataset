import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Time {
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Time> timeList = new ArrayList<>();
            int cEndTime = -1;
            int jEndTime = -1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                timeList.add(new Time(startTime, endTime));
            }
            Collections.sort(timeList, new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    return Integer.compare(o1.startTime, o2.startTime);
                }
            });
            
            
            for (int k = 0; k < timeList.size(); k++) {
                Time it = timeList.get(k);
//                System.out.println(it.startTime+" "+ it.endTime+" "+ stringBuilder.toString());
//                System.out.println(cEndTime +" "+ jEndTime+" "+ stringBuilder.toString());
                if (it.startTime >= cEndTime) {
                    stringBuilder.append("C");
                    cEndTime = it.endTime;
                } else if (it.startTime >= jEndTime) {
                    stringBuilder.append("J");
                    jEndTime = it.endTime;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + stringBuilder.toString());

        }
    }

}