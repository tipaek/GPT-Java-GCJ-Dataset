import java.util.*;
import java.io.*;
public class Solution  {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int caseNum = in.nextInt();
        for(int i = 0; i < caseNum;i++) {
            calculate(i+1);
        }
    }

    private static void calculate(int caseNum){
        int actCount = in.nextInt();

        HashMap<String, String> map = new HashMap<>();
        Activity[] activities = new Activity[actCount];

        for(int i = 0;i < actCount;i++) {
            Activity act = new Activity();
            act.from = in.nextInt();
            act.to = in.nextInt();
            act.num = i;
            activities[i] = act;
        }

        Arrays.sort(activities, new Comp());

        int lastJ = 0;
        int lastC = 0;

        for(int i = 0;i < actCount;i++) {

            Activity act = activities[i];
            if(lastJ <= act.from) {
                act.who  = "J";
                lastJ = act.to;
            } else if(lastC <= act.from) {
                act.who = "C";
                lastC = act.to;
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(activities, Comparator.comparingInt(x->x.num));
        StringBuilder sb = new StringBuilder();
        for(Activity act : activities) sb.append(act.who);

        System.out.println("Case #" + caseNum + ": " + sb.toString());
    }

    private static class Activity {
        public int num;
        public int from;
        public int to;
        public String who;
    }

    private static class Comp implements Comparator<Activity> {
        @Override
        public int compare(Activity o1, Activity o2) {
            if(o1.from == o2.from) return o1.to - o2.to;
            return o1.from - o2.from;
        }
    }

}
