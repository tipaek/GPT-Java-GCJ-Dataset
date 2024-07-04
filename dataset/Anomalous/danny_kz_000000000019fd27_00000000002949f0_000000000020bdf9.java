import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(Activity::getStart));
            
            boolean conflict = false;
            String result = "";
            
            for (int i = 0; i < activityCount; i++) {
                Activity current = activities[i];
                
                if (i == 0) {
                    current.setOwner(assignOwner("", true));
                } else {
                    Activity previous = activities[i - 1];
                    
                    if (!conflict) {
                        if (current.getStart() >= previous.getEnd()) {
                            current.setOwner(assignOwner(previous.getOwner(), true));
                        } else {
                            current.setOwner(assignOwner(previous.getOwner(), false));
                            conflict = true;
                        }
                    } else {
                        if (current.getStart() >= previous.getEnd()) {
                            current.setOwner(assignOwner(previous.getOwner(), true));
                            conflict = false;
                        } else if (i > 1 && current.getStart() >= activities[i - 2].getEnd()) {
                            current.setOwner(assignOwner(previous.getOwner(), false));
                        } else {
                            result = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
            }
            
            if (!"IMPOSSIBLE".equals(result)) {
                Arrays.sort(activities, Comparator.comparingInt(Activity::getPosition));
                StringBuilder resultBuilder = new StringBuilder();
                for (Activity activity : activities) {
                    resultBuilder.append(activity.getOwner());
                }
                result = resultBuilder.toString();
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
    
    private static String assignOwner(String previousOwner, boolean same) {
        if (previousOwner.isEmpty()) {
            return "C";
        }
        return same ? previousOwner : (previousOwner.equals("J") ? "C" : "J");
    }
    
    private static class Activity {
        private final int start;
        private final int end;
        private final int position;
        private String owner;
        
        public Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
        
        public int getStart() {
            return start;
        }
        
        public int getEnd() {
            return end;
        }
        
        public int getPosition() {
            return position;
        }
        
        public String getOwner() {
            return owner;
        }
        
        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}