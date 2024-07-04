
import java.util.Scanner;

class Parenting {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
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

    private static boolean overlap(Activity activity, Activity activity1) {
        if (activity.end > activity1.start && activity1.end > activity.start)
            return true;
        else
            return false;
    }

    private static class Activity implements Comparable<Activity> {

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

        @Override
        public int compareTo(Activity o) {
            if (this.start > o.start)
                return 1;
            if (this.start < o.start)
                return -1;
            else
                return 0;
        }
    }
}
