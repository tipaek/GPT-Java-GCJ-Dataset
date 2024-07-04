
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner io = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = io.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int N = io.nextInt();
            Activity[] list = new Activity[N];
            for (int j = 0; j < N; j++) {
                int start = io.nextInt();
                int end = io.nextInt();
                list[j] = new Activity(start, end, false, -1);
            }
            boolean possible = true;
            for (int j = 0; j <N-1; j++) {
                Activity first = list[j];
                for (int k = j+1; k < N; k++) {
                    if (overlap(first, list[k])) {
                        if(list[k].person){
                            possible=false;
                            break;
                        }
                        list[k].person = !first.person;
                    }
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String answer = "Case #" + i + ": ";
                for (int j = 0; j < N; j++) {
                    if (list[j].person) {
                        answer = answer + "C";
                    } else
                        answer = answer + "J";
                }
                System.out.println(answer);
            }


        }
    }
    /*private static boolean overlap(Activity activity, Activity activity1) {
        if(activity.start<activity1.start && activity.end< activity1.start)
            return false;
        if(activity1.start<activity.start && activity1.end<activity.start)
            return false;
        else
            return true;
    }*/

    private static boolean overlap(Activity activity, Activity activity1) {
        if(activity.start==activity1.start)
            return true;
        if(activity.end==activity1.end)
            return true;
        if(activity.start<activity1.start && activity.end>activity1.start)
            return true;
        if(activity.start<activity1.start && activity.end>activity1.end)
            return true;
        if(activity1.start<activity.start && activity1.end>activity.start)
            return true;
        if(activity1.start<activity.start && activity1.end>activity.end)
            return true;
        if(activity.start>activity1.start && activity.end>activity1.start)
            return true;
        if(activity1.start>activity.start && activity1.end>activity.start)
            return true;
        else
            return false;
    }

    private static class Activity {

        private final int start;
        private final int end;
        private boolean person;
        private int group;

        public Activity(int start, int end, boolean person, int group) {
            this.start = start;
            this.end = end;
            this.person = person;
            this.group = group;
        }


    }
}
