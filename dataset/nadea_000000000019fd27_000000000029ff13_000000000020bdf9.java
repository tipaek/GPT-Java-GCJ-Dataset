import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                int size = Integer.parseInt(in.nextLine());
                List<Activity> activities = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    String[] time = in.nextLine().split(" +");
                    activities.add(new Activity(Integer.parseInt(time[0]), Integer.parseInt(time[1]), j));
                }
                activities.sort((activity, t1) -> activity.a == t1.a ? activity.b - t1.b : activity.a - t1.a);
                boolean playing = true;
                int first = -1;
                int second = -1;
                for (int j = 0; j < activities.size() && playing; j++) {
                    if (activities.get(j).a < first && activities.get(j).a < second){
                        playing = false;
                    }else {
                        if (activities.get(j).a >= first){
                            first = activities.get(j).b;
                            activities.get(j).name="C";
                        }else {
                            second = activities.get(j).b;
                            activities.get(j).name="J";
                        }
                    }
                }
                System.out.print("Case #" + (i + 1) + ": ");
                if (!playing){
                    System.out.print("IMPOSSIBLE");
                }else {
                    activities.sort(Comparator.comparingInt(activity -> activity.num));
                    StringBuilder sb = new StringBuilder();
                    for (Activity activity : activities) {
                        sb.append(activity.name);
                    }
                    System.out.print(sb.toString());
                }
                if (i < cases - 1) {
                    System.out.println();
                }
            }
        }
    }

    static class Activity {
        public int a;
        public int b;
        public int num;
        public String name;

        public Activity(int a, int b, int num) {
            this.a = a;
            this.b = b;
            this.num = num;
        }
    }
}