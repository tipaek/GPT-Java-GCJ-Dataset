import java.util.*;

class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while (t-- > 0) {
            String sb ="";
            int n =  sc.nextInt();
            ArrayList<Schedule> a = new ArrayList<Schedule>();
            char [] res = new char[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int k = 0;
            while (k< n){
                Schedule s1 = new Schedule(), s2 = new Schedule();
                s1.time =  sc.nextInt();
                s1.index = k;
                s1.type = 0;
                s2.type = 1;
                s2.index = k;
                s2.time =  sc.nextInt();
                a.add(s1);
                a.add(s2);
                k++;
            }
            a.sort(new Comp());
            boolean cam = false, jam = false;
            for (Schedule schedule : a) {
                if (schedule.type == 0) {
                    if (!cam) {
                        map.put(schedule.index, 0);
                        cam = true;
                        res[schedule.index] = 'C';
                    } else if (!jam) {
                        res[schedule.index] = 'J';
                        map.put(schedule.index, 1);
                        jam = true;
                    } else {
                        sb = "IMPOSSIBLE";
                        break;
                    }
                } else {
                    int x = map.get(schedule.index);
                    if (x == 0) {
                        cam = false;
                    } else {
                        jam = false;
                    }
                }
            }
            System.out.println("Case #" + c + ":" + " " +  (sb.equals("IMPOSSIBLE") ? "IMPOSSIBLE" :  new String(res)));
            c++;
        }
    }
    public static class Schedule{
        public int time;
        public int type;
        public int index;
    }
    public static class Comp implements Comparator<Schedule>{

        @Override
        public int compare(Schedule s1, Schedule s2) {
            if(s1.time < s2.time)
                return -1;
            else if(s1.time > s2.time)
                return 1;
            else{
                if(s1.type == 1)
                    return -1;
                else{
                    return 1;
                }
            }
        }
    }
}
