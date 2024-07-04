import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxCases = Integer.valueOf(scanner.nextLine());
        int currentCase = 0;
        while (maxCases != currentCase) {
            StringBuilder resultString = new StringBuilder();
            Integer numberOfActivity = Integer.valueOf(scanner.nextLine());
            ArrayList<Integer> cameronSchedule = new ArrayList<>();
            ArrayList<Integer> jamieSchedule = new ArrayList<>();
            Boolean possible = true;
            for (int actCount = 0; actCount < numberOfActivity; actCount++) {
                String line = scanner.nextLine();
                if (possible) {
                    String[] processLine = line.split("\\s+");
                    int startTime = Integer.valueOf(processLine[0]);
                    int endTime = Integer.valueOf(processLine[1]);
                    boolean cameronFree = true;
                    for (int i = startTime; i < endTime; i++) {
                        if (cameronSchedule.contains(i)) {
                            cameronFree = false;
                        }
                    }
                    boolean jamieFree = true;
                    for (int i = startTime; i < endTime; i++) {
                        if (jamieSchedule.contains(i)) {
                            jamieFree = false;
                        }
                    }
                    if (cameronFree) {
                        for (int i = startTime; i < endTime; i++) {
                            cameronSchedule.add(i);
                        }
                        resultString.append('C');
                    } else if (jamieFree) {
                        for (int i = startTime; i < endTime; i++) {
                            jamieSchedule.add(i);
                        }
                        resultString.append('J');
                    } else {
                        possible = false;
                        resultString = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            System.out.println("Case #" + (currentCase + 1) + ": " + resultString);
            currentCase++;
        }
    }
}