
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; ++i) {
            int N = in.nextInt();
            Person C = new Person();
            Person J = new Person();
            String schedule = "";
            for(int activityCount = 0 ; activityCount<N;activityCount++) {
                int s = in.nextInt();
                int e = in.nextInt();
                if(C.add(s,e)){
                    schedule=schedule+"C";
                }
                else if(J.add(s,e)){
                    schedule=schedule+"J";
                }
                else{
                    schedule = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    static class Person{
        Diary diary;
        Person(){
            diary = new Diary();
        }
        boolean add(int s,int e){
            Activity activity = new Activity(s,e);
            return diary.add(activity);
        }

    }

    static class Diary{
        List<Activity>  activitiesAssigned = null;
        Diary(){
            activitiesAssigned = new ArrayList();
        }
        boolean add(Activity a){
            if(isOccupied(a)){
                return false;
            }
            else {
                return activitiesAssigned.add(a);
            }
        }
        boolean isOccupied(Activity a){
            for(Activity afromdiary : activitiesAssigned){
                if(afromdiary.start > a.start && afromdiary.start>=a.end ){
//                    isOccupied=false;
                }
                else if(afromdiary.end <= a.start){
//                    isOccupied=false;
                }
                else{
                    return true;
                }

            }
            return false;
        }
    }

    static class Activity{
        int start;
        int end;
        Activity(int s, int e){
            start = s;
            end = e;
        }
    }
}