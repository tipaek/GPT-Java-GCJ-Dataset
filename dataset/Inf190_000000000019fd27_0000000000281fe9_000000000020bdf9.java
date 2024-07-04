import java.util.*;
import java.io.*;

public class Solution {
    class Activity implements Comparable<Activity> {
        public int start, end;
        public int index;

        Activity(int i, int s, int e) {
            index = i;
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Activity other) {
            return this.start - other.start;
        }
    }

    private String getOrder(Activity[] arr) {
        char[] result = new char[arr.length];
        int cStart = arr[0].start;
        int cEnd = arr[0].end;
        result[arr[0].index] = 'C';
        int jStart = -1;
        int jEnd = -1;

        for (int i = 1; i < arr.length; i++) {
            int currStart = arr[i].start;
            int currEnd = arr[i].end;
            int currIndex = arr[i].index;
            if (currStart >= cStart && currStart < cEnd) {
                if (currStart >= jStart && currStart < jEnd) {
                    return null;
                } else {
                    jStart = currStart;
                    jEnd = currEnd;
                    result[currIndex] = 'J';
                }
            } else {
                cStart = currStart;
                cEnd = currEnd;
                result[currIndex] = 'C';
            }
        }

        return new String(result);
    }

    private void myFun() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tCount = sc.nextInt();
        for (int t = 1; t <= tCount; t++) {
            int n = sc.nextInt();
            Activity[] arr = new Activity[n];

            for (int i = 0; i < n; i++)
                arr[i] = new Activity(i, sc.nextInt(), sc.nextInt());

            Arrays.sort(arr);

            String resultStr = getOrder(arr);
            if (resultStr == null)
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + t + ": " + resultStr);
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.myFun();
    }
}