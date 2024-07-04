import java.util.*;
import java.io.*;
import java.lang.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            boolean possible = true;
            int endC = 0;
            int endJ = 0;
            ArrayList<String> activities = new ArrayList<String>();
            ArrayList<String> orderedActivities = new ArrayList<String>();
            Set<String> setC = new HashSet();
            Set<String> setJ = new HashSet();
            int actNum = in.nextInt();
            
            for (int j = 1; j <= actNum; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                String act = start + "." + end;
                activities.add(act);
                orderedActivities.add(act);
            }
            
            Collections.sort(orderedActivities, new Comparator<String>() {
                public int compare(String s1,String s2) {
                    if (Float.parseFloat(s1) < Float.parseFloat(s2)) {
                        return -1;
                    } else if (Float.parseFloat(s1) > Float.parseFloat(s2)) {
                        return 1;
                    }
                    return 0;
                }
            });
            
            for (int j = 0; j < actNum; j++) {
                String currentAct = orderedActivities.get(j);
                int start = Integer.valueOf(currentAct.split("\\.")[0]);
                int end = Integer.valueOf(currentAct.split("\\.")[1]);
                if (start >= endC) {
                    setC.add(currentAct);
                    endC = end;
                } else if (start >= endJ) {
                    setJ.add(currentAct);
                    endJ = end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (possible) {
                for (int j = 0; j < activities.size(); j++) {
                    String currentAct = activities.get(j);
                    if (setC.contains(currentAct)) {
                        result.append("C");
                        setC.remove(currentAct);
                    } else if (setJ.contains(currentAct)) {
                        result.append("J");
                        setJ.remove(currentAct);
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + (possible ? result.toString() : "IMPOSSIBLE"));
        }
    }
}