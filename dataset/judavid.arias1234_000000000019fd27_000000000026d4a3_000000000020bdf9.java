
import java.util.*;

public class Solution {

    static class Activity {
        Integer posOri;
        Integer begin;
        Integer end;
        Character assign;


        public Activity(Integer posOri, Integer begin, Integer end) {
            this.posOri = posOri;
            this.begin = begin;
            this.end = end;
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
                Activity current = new Activity(i,s,e);
                activities.add(current);
            }

            String result = "";

            Integer finJ = 0;
            Integer finC = 0;
            boolean firts = true;

            activities.sort((o1, o2) -> {
                if(o1.begin == o2.begin){
                    if(o1.end < o2.end)
                        return 1;
                    else  if(o1.end == o2.end)
                        return 0;
                    else
                        return -1;
                }
                return o1.begin.compareTo(o2.begin);
            });

            for (Activity current: activities) {

                if(firts){
                    current.assign = 'J';
                    finJ = current.end;
                    firts = false;

                }else{

                    if(current.begin >= finC){
                        current.assign =  'C';
                        finC = current.end;
                    }else if( current.begin >= finJ){
                        current.assign =  'J';
                        finJ = current.end;
                    }else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }

            }

            if(result.equals("")){
                activities.sort(Comparator.comparing(o -> o.posOri));
                for(Activity a : activities)
                    result += a.assign;
            }

            System.out.println("Case #"+(t+1)+": "+result);
        }
    }

}
