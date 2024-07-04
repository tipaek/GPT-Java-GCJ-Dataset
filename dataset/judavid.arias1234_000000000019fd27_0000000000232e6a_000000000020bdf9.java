import java.util.*;

public class Solution {

    static class Activity implements Comparable<Activity>{
        Integer begin;
        Integer end;

        public Activity(Integer begin, Integer end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return this.begin.compareTo(o.begin);
        }
    }


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {

            int N = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                Activity current = new Activity(s,e);
                activities.add(current);
            }

            String result = "";

            int finJ = 0;
            int finC = 0;
            boolean firts = true;

            activities.sort(Comparator.comparing(o -> o.begin));
            for (Activity current: activities) {

                if(firts){
                    result += "J";
                    finJ = current.end;
                    firts = false;

                }else{

                    if(current.begin >= finC){
                        result += "C";
                        finC = current.end;
                    }else if( current.begin >= finJ){
                        result += "J";
                        finJ = current.end;
                    }else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }

            }

            System.out.println("Case #"+(t+1)+": "+result);
        }
    }

}
