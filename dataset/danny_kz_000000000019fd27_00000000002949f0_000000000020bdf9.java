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
                Activity a = new Activity(sc.nextInt(), sc.nextInt(), j);
                activities[j] = a;
            }
            Arrays.sort(activities, Comparator.comparing(Activity::getS));
            
            
            for (int j = 0; j < n; j++) {
                Activity a = activities[j];
                if (j == 0) {
                    a.owner = nextParent("", true);
                } else {
                    if (!conflict) {
                        if (a.s >= activities[j - 1].e) {
                            a.owner = nextParent(activities[j - 1].owner, true);
                        } else {
                            a.owner = nextParent(activities[j - 1].owner, false);
                            conflict = true;
                        }
                    } else {
                        if (a.s >= activities[j - 1].e) {
                            a.owner = nextParent(activities[j - 1].owner, true);
                            conflict = false;
                        } else {
                            if (a.s >= activities[j - 2].e) {
                                a.owner = nextParent(activities[j - 1].owner, false);
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                    }
                }
            }
            if (result != "IMPOSSIBLE") {
                Arrays.sort(activities, Comparator.comparing(Activity::getPosition));
                for (int j = 0; j < n; j++) {
                    result += activities[j].owner;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
    
    public static String nextParent(String previousOwner, boolean same) {
        if (previousOwner.isEmpty())
            return "C";
        if (same)
            return previousOwner;
        return previousOwner == "J" ? "C" : "J";
    }
    
    public static class Activity {
        int s;
        int e;
        int position;
        String owner;
        
        public Activity(int s, int e, int position) {
            this.s = s;
            this.e = e;
            this.position = position;
        }
        
        public int getS() {
            return s;
        }
        
        public int getPosition() {
            return position;
        }
    }
}