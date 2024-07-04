import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            final String IMPOSSIBLE = "IMPOSSIBLE";

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                StringBuilder result = new StringBuilder();
                int activities = scanner.nextInt();
                ArrayList<Integer> jStartTimes = new ArrayList<>();
                ArrayList<Integer> jEndTimes = new ArrayList<>();
                ArrayList<Integer> cStartTimes = new ArrayList<>();
                ArrayList<Integer> cEndTimes = new ArrayList<>();

                for (int activity = 0; activity < activities; activity++) {
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();
                    boolean isJFree = true;
                    boolean isCFree = true;

                    for (int j = 0; j < jStartTimes.size(); j++) {
                        if ((jStartTimes.get(j) < startTime && startTime < jEndTimes.get(j)) ||
                            (jStartTimes.get(j) < endTime && endTime < jEndTimes.get(j))) {
                            isJFree = false;
                            break;
                        }
                    }

                    for (int c = 0; c < cStartTimes.size(); c++) {
                        if ((cStartTimes.get(c) < startTime && startTime < cEndTimes.get(c)) ||
                            (cStartTimes.get(c) < endTime && endTime < cEndTimes.get(c))) {
                            isCFree = false;
                            break;
                        }
                    }

                    if (isJFree) {
                        jStartTimes.add(startTime);
                        jEndTimes.add(endTime);
                        result.append("J");
                    } else if (isCFree) {
                        cStartTimes.add(startTime);
                        cEndTimes.add(endTime);
                        result.append("C");
                    } else {
                        result = new StringBuilder(IMPOSSIBLE);
                        break;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}