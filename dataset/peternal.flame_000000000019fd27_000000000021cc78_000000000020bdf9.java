import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static class Event{
        int time, no;
        char kind;
        char assigned;
        Event start;
        Event(int time, char kind, int no){
            this.time = time;
            this.kind = kind;
            this.no = no;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList<Event> events = new ArrayList<>();
            for(int j = 0; j<n; j++){
                Event start = new Event(in.nextInt(), 's', j);
                Event end = new Event(in.nextInt(), 'e', j);
                end.start = start;
                events.add(start);
                events.add(end);
            }
            Collections.sort(events, (a, b) -> {
                if(a.time != b.time){
                    return a.time - b.time;
                }
                return a.kind - b.kind;
            });
            boolean j = false, c = false;
            char[] solution = new char[n];
            boolean bad = false;
            for(Event e: events){
                if(e.kind == 'e'){
                    if(e.start.assigned == 'j'){
                        j = false;
                    }else{
                        c = false;
                    }
                }else{
                    if(j&&c){
                        bad = true;
                        break;
                    }
                    if(!j){
                        j = true;
                        e.assigned = 'j';
                        solution[e.no] = 'J';
                    }else{
                        c = true;
                        e.assigned = 'c';
                        solution[e.no] = 'C';
                    }
                }
            }
            if(bad){
                System.out.println("Case #" + i + ": IMPOSSIBLE" );
            }else{
                System.out.println("Case #" + i + ": " + new String(solution));
            }
        }

    }
}

/*
1
5
99 150
1 100
100 301
2 5
150 250
 */