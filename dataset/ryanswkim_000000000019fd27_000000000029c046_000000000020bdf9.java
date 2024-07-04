import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), j));
            }
            activities.sort((a,b) -> a.start - b.start);
            String ret = "CJ";
            for (int j = 2; j < activities.size(); j++) {
                if (activities.get(j).start < activities.get(j-2).end && activities.get(j).start < activities.get(j-1).end) {
                    ret = "IMPOSSIBLE";
                    break;
                }
                if (activities.get(j).start < activities.get(j-1).end && activities.get(j).start >= activities.get(j-2).end){
                    char busy = ret.charAt(ret.length()-1);
                    if (busy == 'J'){
                        ret = ret + 'C';
                    }else{
                        ret = ret + 'J';
                    }
                }
                if (activities.get(j).start >= activities.get(j-1).end && activities.get(j).start < activities.get(j-2).end){
                    char busy = ret.charAt(ret.length()-2);
                    if (busy == 'J'){
                        ret = ret + 'C';
                    }else{
                        ret = ret + 'J';
                    }
                }
                if (activities.get(j).start >= activities.get(j-1).end && activities.get(j).start >= activities.get(j-2).end){
                    ret = ret + 'C';
                }
            }

            if (ret == "IMPOSSIBLE"){
                System.out.println("Case #" + i + ": " + ret);
            } else{
                char[] fin = new char[ret.length()];
                for (int j = 0; j < fin.length; j++) {
                    fin[activities.get(j).index] = ret.toCharArray()[j];
                }
                System.out.println("Case #" + i + ": " + new String(fin));
            }
        }
    }

    private static class Activity {
        int start, end, index;
        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
