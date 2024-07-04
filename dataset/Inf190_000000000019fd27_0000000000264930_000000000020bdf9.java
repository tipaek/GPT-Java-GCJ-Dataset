import java.util.*;
import java.io.*;

public class Solution {
    class Activity implements Comparable<Activity> {
        public Integer start, end;
        public int index;

        Activity(int i, int s, int e) {
            index = i;
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Activity other) {
            return this.end.compareTo(other.end);
        }
    }
    
    private void myFun(){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tCount = sc.nextInt();
        for (int t = 1; t <= tCount; t++) {
            int n = sc.nextInt();
            Activity[] arr = new Activity[n];
            char[] result = new char[n];

            for (int i = 0; i < n; i++)
                arr[i] = new Activity(i, sc.nextInt(), sc.nextInt());

            Arrays.sort(arr);

            List<Activity> remList = new ArrayList<>();

            result[arr[0].index] = 'J';
            int lastEndTime = 0;
            for (Activity ac : arr) {
                if (ac.start >= lastEndTime) {
                    result[ac.index] = 'J';
                    lastEndTime = ac.end;
                } else {
                    // Conflicting time interval
                    remList.add(ac);
                }
            }

            if (remList.size() > 0) {
                lastEndTime = 0;
                result[remList.get(0).index] = 'C';
                for (Activity ac : remList) {
                    if (ac.start >= lastEndTime) {
                        result[ac.index] = 'C';
                        lastEndTime = ac.end;
                    }
                }
            }

            String resultStr = new String(result);

            for (int i = 0; i < n; i++) {
                if (result[i] != 'C' && result[i] != 'J') {
                    resultStr = "IMPOSSIBLE";
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + resultStr);
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.myFun();
    }
}