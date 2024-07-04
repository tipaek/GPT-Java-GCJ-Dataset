import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Solution {
    private static int convertCharToInt(char c) {
        return (int) (c - '0');
    }

    private static String solve(int[][] eventTimes) {
        // may need sorting eventTimes
        int[][] eventTimesAppendIdx = new int[eventTimes.length][3];
        for (int i = 0; i < eventTimes.length; i++) {
            for (int j = 0; j < 2; j++) {
                eventTimesAppendIdx[i][j] = eventTimes[i][j];
            }
            eventTimesAppendIdx[i][2] = i;
        }
        Arrays.sort(eventTimesAppendIdx, java.util.Comparator.comparingInt(a -> a[0]));
        int cLastEventEndTime = 0;
        int jLastEventEndTime = 0;
        char[] retChars = new char[eventTimes.length];
        for (int[] eventTime: eventTimesAppendIdx) {
            if (eventTime[0] >= cLastEventEndTime) {
                retChars[eventTime[2]] = 'C';
                cLastEventEndTime = eventTime[1];
                continue;
            }
            if (eventTime[0] >= jLastEventEndTime) {
                retChars[eventTime[2]] = 'J';
                jLastEventEndTime = eventTime[1];
                continue;
            }
            return "IMPOSSIBLE";
        }
        return String.valueOf(retChars);
    }
    
    public static void main(String... args) {
        try {
            // BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            // int n = Integer.parseInt(in.readLine());
            int n = in.nextInt();
            int[] numOfEvents = new int[n];
            List<int[][]> eventTimes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
                numOfEvents[i] = in.nextInt();
                eventTimes.add(new int[numOfEvents[i]][2]);
                for (int j = 0; j < numOfEvents[i]; j++) {
                    eventTimes.get(i)[j][0] = in.nextInt();
                    eventTimes.get(i)[j][1] = in.nextInt();
                }
			}
			for (int i = 0; i < n; i++) {
				String result = solve(eventTimes.get(i));
				System.out.println(String.format("Case #%d: %s", i + 1, result));
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}