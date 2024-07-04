import java.util.*;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        Scanner myInput = new Scanner(System.in);
        int cases = myInput.nextInt();
        for (int i = 0; i < cases; i++) {
            int intervals = myInput.nextInt();
            ArrayList<Event> events = new ArrayList<>();
            for (int j = 1; j <= intervals; j++) {
                events.add(new Event(myInput.nextInt(), j));
                events.add(new Event(myInput.nextInt(), -j));
            }
            events.sort(new EventCompartor());
            System.out.println("Case #"+(i+1)+": " +convertEventSequence(events));
        }
        return;
    }

    public static String convertEventSequence(ArrayList<Event> events) {
        StringBuilder sb = new StringBuilder();
        Character[] buffer = new Character[events.size()/2];
        HashMap<Integer, Character> executors = new HashMap<>();
        HashSet<Character> pool = new HashSet<>();
        pool.add('C');
        pool.add('J');
        for (Event event: events) {
            Character executor;
            if (event.id<0) {
                //closing event;
                executor = executors.get(-event.id);
                executors.remove(-event.id);
                pool.add(executor);
            } else {
                //opening event;
                if (pool.size()<=0)
                    return "IMPOSSIBLE";
                executor = pool.iterator().next();
                buffer[event.id-1] = executor;
                pool.remove(executor);
                executors.put(event.id, executor);
            }
        }

        for (Character ch: buffer) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

class Event {
    public int time;
    int id;

    public Event(int time, int id) {
        this.time = time;
        this.id = id;
    }
}

class EventCompartor implements Comparator {
    public int compare(Object o1, Object o2) {
        Event e1 = (Event)o1;
        Event e2 = (Event)o2;
        if (e1.time > e2.time)
            return 1;
        if (e1.time < e2.time)
            return -1;
        if (e1.time == e2.time) {
            if ((e1.id>0) && (e2.id<0))
                return 1;
            if ((e1.id<0) && (e2.id>0))
                return -1;
        }
        return 0;
    }
}
