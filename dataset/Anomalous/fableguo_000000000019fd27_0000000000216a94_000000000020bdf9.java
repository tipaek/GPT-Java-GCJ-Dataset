import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] schedules = new int[n][3];

            for (int i = 0; i < n; i++) {
                schedules[i][0] = scanner.nextInt();
                schedules[i][1] = scanner.nextInt();
                schedules[i][2] = i;
            }

            Arrays.sort(schedules, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            char[] resultCharArray = new char[n];
            int endTimeC = 0;
            int endTimeJ = 0;
            String result = "";

            for (int i = 0; i < n; i++) {
                if (schedules[i][0] >= endTimeC) {
                    endTimeC = schedules[i][1];
                    resultCharArray[schedules[i][2]] = 'C';
                } else if (schedules[i][0] >= endTimeJ) {
                    endTimeJ = schedules[i][1];
                    resultCharArray[schedules[i][2]] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (result.isEmpty()) {
                result = new String(resultCharArray);
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}