import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    private static boolean isTimeOverlap(int startTime, int endTime, int startTimeC, int endTimeC) {
        if (startTime == startTimeC) return true;
        if (startTime == endTimeC || endTime == startTimeC) return false;
        if (startTimeC > startTime && startTimeC < endTime) return true;
        if (endTimeC > startTime && endTimeC < endTime) return true;
        if (startTime > startTimeC && startTime < endTimeC) return true;
        return false;
    }

    private static boolean checkTimeOverlap(List<String> list, int startTime, int endTime) {
        for (String time : list) {
            String[] timeValues = time.split(" ");
            int start = Integer.parseInt(timeValues[0]);
            int end = Integer.parseInt(timeValues[1]);
            if (isTimeOverlap(startTime, endTime, start, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/parent.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int noOfActivities = scanner.nextInt();
                List<String> cameron = new ArrayList<>();
                List<String> jamie = new ArrayList<>();
                boolean isOverlapped = false;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < noOfActivities; i++) {
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();

                    if (!checkTimeOverlap(cameron, startTime, endTime)) {
                        cameron.add(startTime + " " + endTime);
                        result.append("C");
                    } else if (!checkTimeOverlap(jamie, startTime, endTime)) {
                        jamie.add(startTime + " " + endTime);
                        result.append("J");
                    } else {
                        isOverlapped = true;
                        break;
                    }
                }

                if (isOverlapped) {
                    result = new StringBuilder("IMPOSSIBLE");
                }
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }
}