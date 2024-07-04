import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
            int numIntervals = scanner.nextInt();
            Node[] intervals = new Node[numIntervals];
            
            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Node(start, end);
            }
            
            Arrays.sort(intervals, new StartTimeComparator());
            PriorityQueue<Node> activeIntervals = new PriorityQueue<>(new EndTimeComparator());
            List<String> availableWorkers = new ArrayList<>(Arrays.asList("C", "J"));
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;
            
            for (Node interval : intervals) {
                while (!activeIntervals.isEmpty() && activeIntervals.peek().end <= interval.begin) {
                    availableWorkers.add(activeIntervals.poll().responsible);
                }
                
                if (availableWorkers.isEmpty()) {
                    isPossible = false;
                    break;
                }
                
                String assignedWorker = availableWorkers.remove(0);
                interval.responsible = assignedWorker;
                schedule.append(assignedWorker);
                activeIntervals.offer(interval);
            }
            
            if (isPossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + schedule);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }
    
    static class Node {
        int begin;
        int end;
        String responsible;
        
        Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    
    static class StartTimeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.begin, node2.begin);
        }
    }
    
    static class EndTimeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.end, node2.end);
        }
    }
}