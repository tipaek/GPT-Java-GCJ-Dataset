package codejam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingPartneringReturns {

    public static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }


    public static String helper(Activity[] activities) {
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if(o1.start > o2.start) {
                    return 1;
                }
                if(o1.start < o2.start) {
                    return -1;
                }
                return o1.end - o2.end;
            }
        });
        int cEnd = -1;
        int jEnd = -1;
        char[] arr = new char[activities.length];
        for(int i = 0; i < arr.length; i++) {
            if(cEnd <= activities[i].start) {
                arr[activities[i].index] = 'C';
                cEnd = activities[i].end;
            } else if(jEnd <= activities[i].start) {
                arr[activities[i].index] = 'J';
                jEnd = activities[i].end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseN = scanner.nextInt();
        int testCase = 1;
        StringBuilder builder = new StringBuilder();
        while(testCase <= testCaseN) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            int i = 0;
            while(i < N) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
                i++;
            }
            String answer = helper(activities);
            builder.append("Case #" + testCase + ": " + answer + "\n");
            testCase++;
        }

        System.out.println(builder.toString());
    }

}
