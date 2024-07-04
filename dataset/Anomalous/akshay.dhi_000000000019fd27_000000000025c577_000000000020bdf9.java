import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            int no = Integer.parseInt(br.readLine());
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < no; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(str.nextToken());
                int end = Integer.parseInt(str.nextToken());
                activities.add(new Activity(start, end, i));
            }
            
            Collections.sort(activities, Comparator.comparingInt(a -> a.start));
            
            int cEnd = -1, jEnd = -1;
            boolean impossible = false;
            char[] result = new char[no];
            
            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    result[activity.index] = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    result[activity.index] = 'J';
                    jEnd = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(result));
            }
        }
    }
}

class Activity {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}