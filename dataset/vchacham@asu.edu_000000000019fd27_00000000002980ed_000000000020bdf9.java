import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Parent {
        String name;
        public int startTime = -1;
        public int endTime = -1;

        Parent(String name){
            this.name = name;
        }

        void setTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Activity {
        public int startTime;
        public int endTime;
        public int id;

        public Activity(int id, int startTime, int endTime){
            this.id = id;
            this.endTime = endTime;
            this.startTime = startTime;
        }

        public String toString(){
            return id+":"+startTime+":"+endTime;
        }
    }

    static class Result {
        public int id;
        public String name;
        public Result(int id, String name){
            this.id = id;
            this.name = name;
        }

        public String toString(){
            return id+":"+name;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                StringBuilder res = new StringBuilder();
                List sortedActivities = new ArrayList<Activity>();
                Parent c = new Parent("C");
                Parent j = new Parent("J");
                int actCnt = scanner.nextInt();
                for(int i=0; i<actCnt; i++) {
                    int st = scanner.nextInt();
                    int et = scanner.nextInt();
                    sortedActivities.add(new Activity(i+1, st, et));
                }
                Comparator<Activity> comp = Comparator.comparingInt((Activity a) -> a.endTime);
                sortedActivities.sort(comp);
                List r = new ArrayList<Result>();
                for(int i=0;i<sortedActivities.size();i++) {
                    Activity ac = (Activity) sortedActivities.get(i);
                    if(c.endTime<=ac.startTime) {
                        c.setTime(ac.startTime, ac.endTime);
                        r.add(new Result(ac.id, "C"));
                    }
                    else if (j.endTime<=ac.startTime) {
                        j.setTime(ac.startTime, ac.endTime);
                        r.add(new Result(ac.id, "J"));
                    } else {
                        res.append("IMPOSSIBLE");
                        r = null;
                        break;
                    }
                }
                Comparator<Result> rc =  Comparator.comparingInt((Result a) -> a.id);
                if(r!=null) {
                    r.sort(rc);
                    for(Object rr: r){
                        Result rrr = (Result)rr;
                        res.append(rrr.name);
                    }
                }
                System.out.println("Case #"+testNumber+": "+res.toString());
            }
        }
    }
}