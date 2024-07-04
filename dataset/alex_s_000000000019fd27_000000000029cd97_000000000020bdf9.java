import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String[] NAMES = new String[] {"*", "C", "J"};
    
    static Boolean[][] mem;
    static int[] owners;
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for(int t = 1; t <= numCases; t++) {
            System.out.print("Case #" + t + ": ");
            List<Activity> data = readData(input);
            System.out.println(solve(data));
        }
        
        input.close();
    }
    
    static List<Activity> readData(Scanner input){
        int dim = input.nextInt();
        List<Activity> result = new ArrayList<Solution.Activity>(dim);
        for(int row = 0; row < dim; row++) {
            result.add(new Activity(input.nextInt(), input.nextInt(), row));
        }
        return result;
    }

    static String solve(List<Activity> data){
        int dim = data.size();
        mem = new Boolean[dim][dim];
        owners = new int[dim];
        Actor[] actors = new Actor[] {new Actor(1, "C"), new Actor(2, "J")};

        Collections.sort(data, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return -(o1.dur - o2.dur);
            }
        });
        
        int actorIdx = -1;
        int count = 0;
        try {
            while(count < dim) {
                Activity free = findFree(data);
                if(null == free) {
                    break;
                }
                actorIdx = findAssignableActor(actors, free, data);
                if(actorIdx < 0) {
                    break;
                }
                Actor current = actors[actorIdx];
                current.assign(free);
                owners[free.id] = current.id;
                count++;

                List<Activity> conflicting = findConflicting(free, data);
                if(!conflicting.isEmpty()) {
                    Actor other = actors[1 - actorIdx];
                    for(Activity c : conflicting) {
                        other.assign(c);
                        owners[c.id] = other.id;
                        count++;
                    }
                }
            }
            
        } catch (Exception e) {
            return IMPOSSIBLE;
        }

        if(count < dim) {
            return IMPOSSIBLE;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dim; i++) {
            sb.append(NAMES[owners[i]]);
        }
        
        return sb.toString();
    }

    static List<Activity> findConflicting(Actor act, List<Activity> data){
        List<Activity> result = new LinkedList<Activity>();
        for(Activity a : data) {
            if(owners[a.id] > 0) {
                continue;
            }
            if(check(a, act.assigned)) {
                result.add(a);
            }
        }
        return result;
    }

    static List<Activity> findConflicting(Activity test, List<Activity> data){
        List<Activity> result = new LinkedList<Activity>();
        for(Activity a : data) {
            if(a.id == test.id) {
                continue;
            }
            if(owners[a.id] > 0) {
                continue;
            }
            if(check(a, test)) {
                result.add(a);
            }
        }
        return result;
    }

    static int findAssignableActor(Actor[] actors, Activity test, List<Activity> data){
        for(int i = 0; i < actors.length; i++) {
            Actor actor = actors[i];
            if(check(test, actor.assigned)) {
                continue;
            }
            List<Activity> conflicting = findConflicting(test, data);
            Actor other = actors[1-i];
            if(check(conflicting, other.assigned)) {
                continue;
            }
            return i;
        }
        
        return -1;
    }

    static Activity findFree(Actor act, List<Activity> data){
        for(Activity a : data) {
            if(owners[a.id] > 0) {
                continue;
            }
            if(check(a, act.assigned)) {
                continue;
            }
            return a;
        }
        return null;
    }

    static Activity findFree(List<Activity> data){
        for(Activity a : data) {
            if(owners[a.id] > 0) {
                continue;
            }
            return a;
        }
        return null;
    }
    
    static boolean check(Activity a, Activity other) {
        int id1 = a.id;
        int id2 = other.id;
        if(id1 > id2) {
            id1 = other.id;
            id2 = a.id;
        }
        
        Boolean result = mem[id1][id2];
        if(null != result) {
            return result;
        }
        int newStart = Math.max(a.start, other.start);
        int newEnd   = Math.min(a.end, other.end);
        result = newEnd > newStart;
        mem[id1][id2] = result;
        return result;
    }

    static boolean check(Activity a, List<Activity> others) {
        for(Activity o : others) {
            if(check(a, o)) {
                return true;
            }
        }
        return false;
    }

    static boolean check(List<Activity> tests, List<Activity> others) {
        for(Activity o : others) {
            if(check(o, tests)) {
                return true;
            }
        }
        return false;
    }
    
    static class Actor {
        int id;
        String name;
        List<Activity> assigned = new LinkedList<Solution.Activity>();
        public Actor(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        void assign(Activity a) {
            if(check(a, assigned)) {
                throw new IllegalArgumentException();
            }
            assigned.add(a);
        }
    }

    static class Activity {
        public int id = -1;
        public int start;
        public int end;
        public int dur;
        
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            dur = end - start;
        }

        public Activity(int start, int end, int id) {
            this(start, end);
            this.id = id;
        }

        @Override
        public String toString() {
            return "{ " + id + " | " + start + " : " + end + " }";
        }
    }
    
}