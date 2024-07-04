import java.util.*;
import java.io.*;

public class Solution {

    public static class Pair implements Comparable<Pair> {
        int time, type, index;

        public Pair(int time, int type, int index) {
            this.time = time;
            this.type = type;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.time == other.time) {
                return this.type == 1 ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int n = scanner.nextInt();
            PriorityQueue<Pair> events = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                events.add(new Pair(scanner.nextInt(), 0, i));
                events.add(new Pair(scanner.nextInt(), 1, i));
            }
            
            boolean isPossible = true;
            int activeTasks = 0;
            char[] schedule = new char[n];
            boolean cOccupied = false, jOccupied = false;
            
            while (!events.isEmpty()) {
                Pair currentEvent = events.poll();
                
                if (currentEvent.type == 0) { // Start of a task
                    activeTasks++;
                    if (activeTasks > 2) {
                        isPossible = false;
                        break;
                    } else if (!cOccupied) {
                        cOccupied = true;
                        schedule[currentEvent.index] = 'C';
                    } else {
                        jOccupied = true;
                        schedule[currentEvent.index] = 'J';
                    }
                } else { // End of a task
                    activeTasks--;
                    if (schedule[currentEvent.index] == 'C') {
                        cOccupied = false;
                    } else {
                        jOccupied = false;
                    }
                }
            }
            
            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}