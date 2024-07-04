import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            boolean isImpossible = false;
            int activitiesCount = scanner.nextInt();
            StringBuilder answer = new StringBuilder();
            List<Integer> cTimes = new ArrayList<>();
            List<Integer> jTimes = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isTimeOccupied(start, end, cTimes) && isTimeOccupied(start, end, jTimes)) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else if (!isTimeOccupied(start, end, cTimes)) {
                    fillTimeSlots(start, end, cTimes);
                    answer.append("C");
                } else {
                    fillTimeSlots(start, end, jTimes);
                    answer.append("J");
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (i + 1) + ": " + answer.toString());
            }
        }

        scanner.close();
    }

    static void fillTimeSlots(int start, int end, List<Integer> times) {
        for (int i = start; i < end; i++) {
            times.add(i);
        }
    }

    static boolean isTimeOccupied(int start, int end, List<Integer> times) {
        for (int i = start; i < end; i++) {
            if (times.contains(i)) {
                return true;
            }
        }
        return false;
    }
}

/*
1
3
1 2 
1 10
10 12
*/