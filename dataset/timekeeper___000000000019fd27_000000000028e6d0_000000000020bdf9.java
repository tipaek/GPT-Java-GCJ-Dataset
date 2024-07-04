import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Parent {
        String name;
        public int startTime = 0;
        public int endTime = 0;
        public boolean isFree;

        Parent(String name){
            this.name = name;
        }

        void setFree(boolean isFree){
            this.isFree = isFree;
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
                    sortedActivities.add(new Activity(i+1,st, et));
                }
                Comparator<Activity> comp = (Activity a, Activity b) -> {
                    return (a.endTime > b.endTime)?1:-1;
                };
                sortedActivities.sort(comp);
//                System.out.println("---++----");
//                sortedActivities.forEach(x->{
//                    System.out.println(x.toString());
//                });
//                System.out.println("---------");
                List r = new ArrayList<Result>();
                for(int i=0;i<sortedActivities.size();i++) {
                    Activity ac = (Activity) sortedActivities.get(i);
                    if(c.endTime<=ac.startTime) {c.setFree(true);}
                    else if (j.endTime<=ac.startTime) {j.setFree(true);}
                    if(c.isFree){
                        c.setTime(ac.startTime, ac.endTime);
                        c.setFree(false);
//                        res.append("C");
                        r.add(new Result(ac.id, "C"));
                    } else if (j.isFree) {
                        j.setTime(ac.startTime, ac.endTime);
                        j.setFree(false);
//                        res.append("J");
                        r.add(new Result(ac.id, "J"));
                    } else {
                        res.setLength(0);
                        res.append("IMPOSSIBLE");
                        r = null;
                        break;
                    }
//                    System.out.println(ac.startTime+":"+ac.endTime);
//                    System.out.println("C: "+c.startTime+":"+c.endTime+":"+c.isFree);
//                    System.out.println("J: "+j.startTime+":"+j.endTime+":"+j.isFree);
                }
                Comparator<Result> rc = (Result a, Result b) -> {
                    return (a.id > b.id)?1:-1;
                };
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