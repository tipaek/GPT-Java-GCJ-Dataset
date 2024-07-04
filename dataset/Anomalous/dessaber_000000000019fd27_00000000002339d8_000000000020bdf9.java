import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            PriorityQueue<Triplet> events = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                int start1 = scanner.nextInt();
                events.add(new Triplet(i, start1, 0));
                int start2 = scanner.nextInt();
                events.add(new Triplet(i, start2, 1));
            }

            Map<Integer, Character> assignments = new HashMap<>();
            char[] result = new char[n];
            boolean isFirstEvent = true;
            boolean isImpossible = false;
            char lastAssignedPerson = 'J';
            
            while (!events.isEmpty()) {
                Triplet event = events.poll();
                char currentPerson;
                
                if (isFirstEvent) {
                    isFirstEvent = false;
                    currentPerson = 'C';
                } else {
                    currentPerson = lastAssignedPerson;
                }

                if (event.state == 1) {
                    lastAssignedPerson = assignments.get(event.id);
                    assignments.remove(event.id);
                } else if (assignments.size() == 2) {
                    isImpossible = true;
                    break;
                } else {
                    assignments.put(event.id, currentPerson);
                    result[event.id] = currentPerson;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

    private static class Triplet implements Comparable<Triplet> {
        int id;
        int time;
        int state;

        Triplet(int id, int time, int state) {
            this.id = id;
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Triplet other) {
            int timeComparison = Integer.compare(this.time, other.time);
            if (timeComparison != 0) {
                return timeComparison;
            }
            return -Integer.compare(this.state, other.state);
        }
    }
}