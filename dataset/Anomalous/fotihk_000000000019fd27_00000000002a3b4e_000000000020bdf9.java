import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine().trim());
            List<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                String[] descript = in.readLine().trim().split(" ");
                int start = Integer.parseInt(descript[0]);
                int end = Integer.parseInt(descript[1]);
                activities.add(new Activity(start, end, j));
            }
            
            activities.sort(Comparator.comparingInt(Activity::getStart));
            
            boolean impossible = false;
            for (int k = 0; k < activities.size(); k++) {
                if (k == 0) {
                    activities.get(0).assign("C");
                } else if (k == 1) {
                    if (activities.get(0).getEnd() <= activities.get(1).getStart()) {
                        activities.get(1).assign("C");
                    } else {
                        activities.get(1).assign("J");
                    }
                } else {
                    boolean cAvailable = true;
                    boolean jAvailable = true;
                    
                    for (int l = k - 1; l >= 0; l--) {
                        if (activities.get(l).getEnd() > activities.get(k).getStart()) {
                            if (activities.get(l).getAssign().equals("C")) {
                                cAvailable = false;
                            } else {
                                jAvailable = false;
                            }
                        }
                    }
                    
                    if (!cAvailable && !jAvailable) {
                        impossible = true;
                        break;
                    } else if (cAvailable) {
                        activities.get(k).assign("C");
                    } else {
                        activities.get(k).assign("J");
                    }
                }
            }
            
            activities.sort(Comparator.comparingInt(Activity::getPlace));
            
            StringBuilder result = new StringBuilder();
            for (Activity activity : activities) {
                result.append(activity.getAssign());
            }
            
            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }
}

class Activity {
    private final int start;
    private final int end;
    private final int place;
    private String person = "";

    Activity(int start, int end, int place) {
        this.start = start;
        this.end = end;
        this.place = place;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }

    int getPlace() {
        return place;
    }

    String getAssign() {
        return person;
    }

    void assign(String person) {
        this.person = person;
    }
}