import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            ArrayList<ArrayList<Double>> cameron = new ArrayList<>();
            ArrayList<ArrayList<Double>> jamie = new ArrayList<>();
            long numberOfTimes = Long.parseLong(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numberOfTimes; i++) {
                ArrayList<Double> timeSlot = parseTimes(scanner.nextLine());
                if (timeSlot.size() <= 1) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (!hasOverlap(jamie, timeSlot)) {
                    jamie.add(timeSlot);
                    result.append("J");
                } else if (!hasOverlap(cameron, timeSlot)) {
                    cameron.add(timeSlot);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static ArrayList<Double> parseTimes(String times) {
        String[] splitTimes = times.split(" ");
        ArrayList<Double> parsedTimes = new ArrayList<>();
        for (String time : splitTimes) {
            parsedTimes.add(Double.parseDouble(time));
        }
        return parsedTimes;
    }

    private static boolean hasOverlap(ArrayList<ArrayList<Double>> schedule, ArrayList<Double> timeSlot) {
        for (ArrayList<Double> slot : schedule) {
            if (isOverlapping(slot.get(0), slot.get(1), timeSlot.get(0), timeSlot.get(1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(double start1, double end1, double start2, double end2) {
        return (start1 < end2 && end1 > start2);
    }
}