import java.util.*;
public class Solution {
    public static class Event{
        public int start;
        public int end;
        public int id;
        public String assignment;
        public Event(int start, int end, int id){
            this.start = start;
            this.end = end;
            this.id = id;
            assignment = "N";
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int cas = 0; cas < t; cas++){
            int e = sc.nextInt();
            Event[] eve = new Event[e];
            for(int i = 0; i < e; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                Event newEvent = new Event(start, end, i);
                eve[i] = newEvent;
            }
            Arrays.sort(eve, new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return o1.start - o2.start;
                }
            });
            int c_opp = 0;
            int j_opp = 0;
            boolean conflict_flag = false;
            for(int i = 0; i < e; i++){
                int start = eve[i].start;
                int end = eve[i].end;

                if(c_opp <= start){
                        eve[i].assignment = "C";
                        c_opp = end;
                }else if(j_opp <= start){
                    eve[i].assignment = "J";
                    j_opp = end;
                }else{
                    conflict_flag = true;
                    break;
                }
            }
            if(conflict_flag){
                System.out.println("Case #" + (cas + 1) + ": " + "IMPOSSIBLE");
            }else{
                Arrays.sort(eve, new Comparator<Event>() {
                    @Override
                    public int compare(Event o1, Event o2) {
                        return o1.id - o2.id;
                    }
                });
                System.out.print("Case #" + (cas + 1) + ": ");
                for(int i = 0; i < e; i++){
                    System.out.print(eve[i].assignment);
                }
                System.out.println();
            }
        }
    }
}
