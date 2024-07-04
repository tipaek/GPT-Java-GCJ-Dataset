import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            List<Time> schedules = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                schedules.add(new Time(s, e,j));
            }
            schedules.sort(new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    if (o1.e < o2.e) {
                        return -1;
                    } else if (o1.e > o2.e) {
                        return 1;
                    } else
                        return 0;
                }
            });
            String output = "";
            String current = "C";
            int cBusyTill = 0;
            int jBusyTill = 0;
            if(schedules.size()>=1)
            schedules.get(0).person=current;
            cBusyTill = schedules.get(0).e;
            boolean impossible =false;

            for (int j = 1; j < n; j++) {

                Time t1 = schedules.get(j - 1);
                Time t2 = schedules.get(j);
                if (t1.e <= t2.s) {
                    t2.person=current;
                } else {
                    if(current.equals("C") && jBusyTill>t2.s){
                        impossible =true;
                    }else if(current.equals("J") && cBusyTill>t2.s){
                        impossible =true;
                    }else {
                        current = changeCurrent(current);
                        t2.person=current;
                    }
                }
            }
            if(impossible){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                continue;
            }
            schedules.sort(new Comparator<Time>() {
                @Override
                public int compare(Time o1, Time o2) {
                    if (o1.index < o2.index) {
                        return -1;
                    } else if (o1.index > o2.index) {
                        return 1;
                    } else
                        return 0;
                }
            });
            for (int j = 0; j < n; j++) {
                output = output+schedules.get(j).getPerson();
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String changeCurrent(String s) {
        return s.equals("C") ? "J" : "C";
    }


}

class Time {
    int s, e;
    String person="";
    int index;

    Time(int s, int e, int index) {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
