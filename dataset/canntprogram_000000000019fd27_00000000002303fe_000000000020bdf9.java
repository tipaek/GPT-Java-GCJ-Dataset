import java.util.*;
import java.io.*;

public class Solution {

    static class Event{
        int start;
        int end;
        char assign;
        int order;
        public Event(int s, int e, char a, int o){
            this.start = s;
            this.end = e;
            this.assign = a;
            this.order = o;
        }

    }

    public static void solve(int ks, int N, Event []e) {
        Boolean possible = helper(N, e);
        String schedule;
        if(!possible){
            schedule = "IMPOSSIBLE";
        }else{
            Arrays.sort(e, Comparator.comparingInt(a ->a.order));
            StringBuilder sb = new StringBuilder();
            for(Event i:e){
                sb.append(i.assign);
            }
            schedule = sb.toString();
        }
        System.out.println("Case #" + ks + ": "+schedule);
    }

    public static Boolean helper(int N, Event[]e){
        Arrays.sort(e, Comparator.comparingInt(a ->a.start));
        int C_ave = -1;
        int J_ave = -1;
        for(int i=0;i<N; i++){
            if(e[i].start>=C_ave){
                C_ave = e[i].end;
                e[i].assign = 'C';
            }else if(e[i].start>=J_ave){
                J_ave = e[i].end;
                e[i].assign = 'J';
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        //T test cases
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            //number of activities
            int N = input.nextInt();
            Event [] e= new Event[N];
            for(int i=0; i<N; i++){
                int start = input.nextInt();
                int end = input.nextInt();
                Event temp = new Event(start, end, 'X', i);
                e[i] = temp;
            }
            solve(ks, N, e);
        }
    }
}
