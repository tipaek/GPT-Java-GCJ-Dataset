import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            int numberOfCases = Integer.parseInt(scanner.nextLine());
            
            for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
                int numberOfIntervals = Integer.parseInt(scanner.nextLine());
                int[][] intervals = new int[numberOfIntervals][2];
                
                for (int intervalIndex = 0; intervalIndex < numberOfIntervals; intervalIndex++) {
                    intervals[intervalIndex][0] = scanner.nextInt();
                    intervals[intervalIndex][1] = scanner.nextInt();
                    scanner.nextLine(); // Consume the remaining newline character
                }
                
                Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
                
                StringBuilder result = new StringBuilder();
                PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
                String[] options = {"C", "J"};
                int currentOptionIndex = 0;
                
                for (int intervalIndex = 0; intervalIndex < numberOfIntervals; intervalIndex++) {
                    if (result.toString().equals("IMPOSSIBLE")) {
                        scanner.nextLine(); // Skip the remaining input for this case
                        continue;
                    }
                    
                    if (endTimeQueue.isEmpty()) {
                        endTimeQueue.add(intervals[intervalIndex][1]);
                        result.append(options[currentOptionIndex]);
                    } else {
                        if (intervals[intervalIndex][0] < endTimeQueue.peek()) {
                            if (endTimeQueue.size() == 2) {
                                result = new StringBuilder("IMPOSSIBLE");
                                continue;
                            }
                            endTimeQueue.add(intervals[intervalIndex][1]);
                            currentOptionIndex = (currentOptionIndex + 1) % 2;
                            result.append(options[currentOptionIndex]);
                        } else {
                            while (!endTimeQueue.isEmpty() && intervals[intervalIndex][0] >= endTimeQueue.peek()) {
                                endTimeQueue.poll();
                            }
                            endTimeQueue.add(intervals[intervalIndex][1]);
                            result.append(options[currentOptionIndex]);
                        }
                    }
                }
                
                System.out.println("Case #" + (caseIndex + 1) + ": " + result + "\n");
            }
        }
        
        scanner.close();
    }
}