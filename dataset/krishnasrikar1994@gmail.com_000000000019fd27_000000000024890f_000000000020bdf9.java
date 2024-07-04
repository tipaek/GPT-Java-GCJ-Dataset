import java.util.*;

class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder("");
            int n =  sc.nextInt();
            ArrayList<Schedule> a = new ArrayList<Schedule>();
            HashMap<Integer, Integer> map = new HashMap<>();
            while (n-- > 0){
                Schedule s1 = new Schedule(), s2 = new Schedule();
                s1.time =  sc.nextInt();
                s1.index = n;
                s1.type = 0;
                s2.type = 1;
                s2.index = n;
                s2.time =  sc.nextInt();
                a.add(s1);
                a.add(s2);
            }
            a.sort(new Comp());
            boolean cam = false, jam = false;
            for (Schedule schedule : a) {
                if (schedule.type == 0) {
                    if (!cam) {
                        map.put(schedule.index, 0);
                        cam = true;
                        sb.append("C");
                    } else if (!jam) {
                        sb.append("J");
                        map.put(schedule.index, 1);
                        jam = true;
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
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
            System.out.println("Case #" + c + ":" + " " + sb.toString());
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
