import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int cn = 1; cn <= T; cn++) {
            int N = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for(int i=0;i<N;i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                activities.add(new Activity(i, s, e));
            }

            Collections.sort(activities, new SortByEndTime());
            int currentC = 0;
            int currentJ = 0;
            boolean possible = true;
            for(Activity a: activities){
                if (a.s >= currentC){
                    currentC = a.e;
                    a.setP('C');
                } else if(a.s >= currentJ){
                    currentJ = a.e;
                    a.setP('J');
                } else{
                    possible = false;
                    break;
                }
            }

            Collections.sort(activities, new SortByIndex());
            StringBuffer sb = new StringBuffer();
            for (Activity a: activities){
                sb.append(a.p);
            }
            if(possible){
                System.out.println("Case #" + cn + ": " + sb.toString());
            } else{
                System.out.println("Case #" + cn + ": IMPOSSIBLE" );
            }
        }
    }

    static class Activity{
        int i,s,e;
        char p;
        Activity(int i, int s, int e){
            this.i=i;
            this.s=s;
            this.e=e;
        }

        public void setP(char p) {
            this.p = p;
        }
    }

    static class SortByIndex implements Comparator<Activity>{

        @Override
        public int compare(Activity a, Activity b) {
            return a.i - b.i;
        }
    }

    static class SortByEndTime implements Comparator<Activity>{
        @Override
        public int compare(Activity a, Activity b) {
            return a.e - b.e;
        }
    }

}
