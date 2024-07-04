import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];
            
            for (int j = 0; j < activityCount; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt());
            }
            
            Arrays.sort(activities, Comparator.comparingInt(Activity::getStart));
            
            StringBuilder result = new StringBuilder();
            boolean conflict = false;
            
            for (int j = 0; j < activityCount; j++) {
                Activity current = activities[j];
                
                if (j == 0) {
                    result.append(assignParent(result, true));
                } else {
                    if (!conflict) {
                        if (current.getStart() >= activities[j - 1].getEnd()) {
                            result.append(assignParent(result, true));
                        } else {
                            result.append(assignParent(result, false));
                            conflict = true;
                        }
                    } else {
                        if (current.getStart() >= activities[j - 1].getEnd()) {
                            result.append(assignParent(result, true));
                            conflict = false;
                        } else {
                            if (j > 1 && current.getStart() >= activities[j - 2].getEnd()) {
                                result.append(assignParent(result, false));
                            } else {
                                result = new StringBuilder("IMPOSSIBLE");
                                break;
                            }
                        }
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
    
    private static String assignParent(StringBuilder result, boolean same) {
        if (result.length() == 0) {
            return "C";
        }
        char lastChar = result.charAt(result.length() - 1);
        return same ? Character.toString(lastChar) : (lastChar == 'J' ? "C" : "J");
    }

    private static class Activity {
        private final int start;
        private final int end;
        
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getStart() {
            return start;
        }
        
        public int getEnd() {
            return end;
        }
    }
}