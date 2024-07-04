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
            Pair[] schedule = new Pair[chores];
            for (int j = 0; j < chores; j++) {
                Pair timings = new Pair(sc.nextInt(), sc.nextInt());
                schedule[j] = timings;
            }
            System.out.println("Case #" + (i + 1) + ": " + check(schedule, C, J)); 
        } 
    }

    public static String check(Pair[] schedule, Parent C, Parent J) {
        String ans = "";
        for (int i = 0; i < schedule.length; i++) {
            if (C.canDo(schedule[i])) {
                C.chores.add(schedule[i]);
                ans += "C";
                continue;
            } else if (J.canDo(schedule[i])) {
                J.chores.add(schedule[i]);
                ans += "J";
                continue;
            } else {
                return "IMPOSSIBLE";
            }
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

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
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
