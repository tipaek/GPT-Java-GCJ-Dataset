import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution{

    public static void main(String []args){
        int amount;
        StringBuilder order = new StringBuilder("");
        boolean isImp = false;
        int freeTimeC = 0;
        int freeTimeJ = 0;

        Scanner in = new Scanner(System.in);
        amount = Integer.parseInt(in.nextLine());

        for (int i = 0; i<amount; i++){

            int act = Integer.parseInt(in.nextLine());
            ArrayList<Activity> activities = new ArrayList<>();
            for (int j =0; j<act;j++){
                Activity activity = new Activity(in.nextLine());
                activity.number = (short)j;
                activities.add(activity);
            }

            Collections.sort(activities, (a, b) -> a.compareTo(b));

            for (Activity active: activities
                 ) {
                if (active.start >= freeTimeC){
                    freeTimeC = active.end;
                    active.user = 'C';
                } else {
                    if (active.start >= freeTimeJ){
                        freeTimeJ = active.end;
                        active.user = 'J';
                    } else {
                       isImp = true;
                       continue;
                    }
                }
            }
            freeTimeC = 0;
            freeTimeJ = 0;
            Collections.sort(activities, (a, b) -> a.coolCompare(b));

            if (isImp) {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                isImp = false;
            } else {
                for (Activity a: activities
                     ) {
                    order.append(a.user);
                }
                System.out.println("Case #" + (i + 1) + ": " + order);
                order.delete(0, order.length());
            }
        }
    }

    static class Activity{
        public short number;
        public int start;
        public int end;
        public char user;

        public Activity(String a){
            String[]b = a.split(" ");
            start = Integer.parseInt(b[0]);
            end = Integer.parseInt(b[1]);
        }

        int compareTo(Activity c){
            return this.start - c.start;
        }

        int coolCompare (Activity c){
            return this.number - c.number;
        }
    }
}
