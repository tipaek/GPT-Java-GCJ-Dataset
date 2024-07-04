import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt(); 
        for (int i = 0; i < max; i++) {
            int chores = sc.nextInt();
            Parent C = new Parent(new ArrayList<>());
            Parent J = new Parent(new ArrayList<>());
            PriorityQueue<Pair> schedule = new PriorityQueue<>(1, new PairComparator());
            for (int j = 0; j < chores; j++) {
                Pair timings = new Pair(sc.nextInt(), sc.nextInt(), j);
                schedule.add(timings);
            }
            System.out.println("Case #" + (i + 1) + ": " + check(schedule, C, J)); 
        } 
    }

    public static String check(PriorityQueue<Pair> schedule, Parent C, Parent J) {
        String ans = "";
        int c = 0;
        int j = 0;
        String[] ordering = new String[schedule.size()];
        while (schedule.size() > 0) {
            Pair event = schedule.poll();
            if (event.first >= c) {
                ordering[event.ref] = "C";
                c = event.second;
            } else if (event.first >= j) {
                ordering[event.ref] = "J";
                j = event.second;
            } else {
                return "IMPOSSIBLE";
            }
        }
        for (int i = 0; i < ordering.length; i++) {
            ans += ordering[i];
        }
        return ans;
    }

}

class Parent {
    public ArrayList<Pair> chores;

    Parent(ArrayList<Pair> chores) {
        this.chores = chores;
    }

    public boolean canDo(Pair chore) {
        for (Pair c : this.chores) {
            if (chore.overlap(c)) {
                return false;
            }
        }
        return true;
    }

}

class Pair {
    public int first;
    public int second;
    public int ref;

    Pair(int first, int second, int ref) {
        this.first = first;
        this.second = second;
        this.ref = ref;
    }

    public boolean overlap(Pair p) {
        if (this.first > p.first && this.first < p.second) {
            return true;
        }
        if (this.second < p.second && this.second > p.first) {
            return true;
        }
        return false;
    }

}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.first == p2.first) {
            return p1.second - p2.second;
        } else {
            return p1.first - p2.first;
        }
    }

}
