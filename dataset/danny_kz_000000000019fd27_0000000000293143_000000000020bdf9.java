import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String result = "";
            boolean conflict = false;
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                Activity a = new Activity(sc.nextInt(), sc.nextInt());
                activities[j] = a;
            }
            Arrays.sort(activities, Comparator.comparing(Activity::getS));
            
            
            for (int j = 0; j < n; j++) {
                Activity a = activities[j];
                // System.out.println("activity " + (j + 1) + ": " + a.s + " " + a.e);
                if (j == 0) {
                    result += nextParent(result, true);
                } else {
                    if (!conflict) {
                        if (a.s >= activities[j - 1].e) {
                            result += nextParent(result, true);
                        } else {
                            result += nextParent(result, false);
                            conflict = true;
                        }
                    } else {
                        if (a.s >= activities[j - 1].e) {
                            result += nextParent(result, true);
                            conflict = false;
                        } else {
                            // if (j == 1) {
                            //     result += nextParent(result, false);
                            // } else {
                            if (a.s >= activities[j - 2].e) {
                                result += nextParent(result, false);
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }
                            // }
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    public static String nextParent(String result, boolean same) {
        if (result.isEmpty())
            return "C";
        if (same)
            return Character.toString(result.charAt(result.length() - 1));
        return result.charAt(result.length() - 1) == 'J' ? "C" : "J";
    }
    
    public static class Activity {
        int s;
        int e;
        
        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        public int getS() {
            return s;
        }
    }
}