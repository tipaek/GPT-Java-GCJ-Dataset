import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numberOfIntervals = scanner.nextInt();
            int[][] intervals = new int[numberOfIntervals][2];

            for (int j = 0; j < numberOfIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = "Case #" + i + ": " + determineMeetingRooms(intervals);
            System.out.println(result);
        }
    }

    private static String determineMeetingRooms(int[][] intervals) {
        StringBuilder sequence = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();
        int roomCount = 0;

        for (int[] interval : intervals) {
            if (endTimeHeap.isEmpty()) {
                sequence.append("C");
                cameronEndTime = interval[1];
                roomCount++;
                endTimeHeap.offer(interval[1]);
            } else {
                if (interval[0] >= endTimeHeap.peek()) {
                    if (cameronEndTime <= interval[0]) {
                        sequence.append("C");
                        cameronEndTime = interval[1];
                    } else if (jamieEndTime <= interval[0]) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    }
                    endTimeHeap.poll();
                } else {
                    if (jamieEndTime == 0) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    }
                    roomCount++;
                }
                if (roomCount > 2) {
                    return "IMPOSSIBLE";
                }
                endTimeHeap.offer(interval[1]);
            }
        }
        return sequence.toString();
    }
}