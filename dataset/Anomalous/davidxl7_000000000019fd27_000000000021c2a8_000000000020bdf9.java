import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int activitiesCount = Integer.parseInt(reader.readLine());
            Activity[] activities = new Activity[activitiesCount];
            
            for (int j = 0; j < activitiesCount; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities[j] = new Activity(start, end);
            }
            
            Arrays.sort(activities);
            StringBuilder result = new StringBuilder();
            boolean isSolvable = true;
            int lastC = -1;
            int lastJ = -1;
            
            for (int j = 0; j < activitiesCount; j++) {
                if (lastC != -1 && activities[lastC].end <= activities[j].start) {
                    lastC = -1;
                }
                if (lastJ != -1 && activities[lastJ].end <= activities[j].start) {
                    lastJ = -1;
                }
                if (lastC == -1) {
                    result.append("C");
                    lastC = j;
                } else if (lastJ == -1) {
                    result.append("J");
                    lastJ = j;
                } else {
                    isSolvable = false;
                    break;
                }
            }
            
            if (isSolvable) {
                System.out.print(result.toString());
            } else {
                System.out.print("IMPOSSIBLE");
            }
            
            if (i != testCases - 1) {
                System.out.println();
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, end;
        
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}