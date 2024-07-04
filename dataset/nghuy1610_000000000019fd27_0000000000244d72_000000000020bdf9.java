
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Activity {
        int start;
        int end;
    }

    static boolean isOverlap(Activity a1, Activity a2) {
        if (a1.start > a2.start && a1.start < a2.end) {
            return true;
        }
        if (a1.end < a2.end && a1.end > a2.start) {
            return true;
        }
        if (a1.start <= a2.start && a1.end >= a2.end) {
            return true;
        }
        return false;
    }
    static boolean isOverlapWithActs(Activity a1, List<Integer> ids, Activity[] acts) {
        for (Integer id : ids) {
            if (isOverlap(a1, acts[id])) {
                return true;
            }
        }
        return false;
    }
    
       static boolean isOverlapWithActs(Activity a1, List<Activity> acts) {
        for (Activity act : acts) {
            if (isOverlap(a1, act)) {
                return true;
            }
        }
        return false;
    }

    static String distribute(Activity[] acts, int pos, List<Integer> jAct, List<Integer> cAct) {
        if (pos >= acts.length) {
            return "POSSIBLE";
        }
        String result = "IMPOSSIBLE";
        if (!isOverlapWithActs(acts[pos], jAct, acts)) {
            jAct.add(pos);
            result = distribute(acts, pos+1, jAct, cAct);
            if (result == "IMPOSSIBLE") {
                jAct.remove(jAct.size() - 1);
            } else {
                return result;
            }
        }
        if (!isOverlapWithActs(acts[pos], cAct, acts)) {
            cAct.add(pos);
            result = distribute(acts, pos+1, jAct, cAct);
            if (result == "IMPOSSIBLE") {
                cAct.remove(cAct.size() - 1);
            } else {
                return result;
            }
        }
        return "IMPOSSIBLE";
    }

    static String schedule(Activity[] acts) {
        List<Integer> jAct = new ArrayList<>();
        List<Integer> cAct = new ArrayList<>();
        String[] jobDist = new String[acts.length];
        Map<Activity, Integer> map = new HashMap<>();
        for (int i = 0; i < acts.length; i++) {
            map.put(acts[i], i);
        }
        Arrays.sort(acts, (act1, act2) -> {
            if (act1.start != act2.start) {return act1.start - act2.start;}
            else {
                return act1.end - act2.end;
            }
        });
        String result = distribute(acts, 0, jAct, cAct);
        if (result == "IMPOSSIBLE") {
            return result;
        }
        for (int id : jAct) {
            jobDist[map.get(acts[id])] = "J";
        }
        for (int id : cAct) {
            jobDist[map.get(acts[id])] = "C";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : jobDist) {
            sb.append(s);
        }
        return sb.toString();
    }


    static String schedule3(Activity[] acts) {
        List<Activity> jAct = new ArrayList<>();
        List<Activity> cAct = new ArrayList<>();
        String[] jobDist = new String[acts.length];
        Map<Activity, Integer> map = new HashMap<>();
        for (int i = 0; i < acts.length; i++) {
            map.put(acts[i], i);
        }
        Arrays.sort(acts, (act1, act2) -> {
            if (act1.start != act2.start) {return act1.start - act2.start;}
            else {
                return act1.end - act2.end;
            }
        });
        for (Activity ac :  acts) {
            if (!isOverlapWithActs(ac, jAct)) {
                jAct.add(ac);
            } else if (!isOverlapWithActs(ac, cAct)) {
                cAct.add(ac);
            } else {
                return "IMPOSSIBLE";
            }
        }
        for (Activity act : jAct) {
            jobDist[map.get(act)] = "J";
        }
        for (Activity act : cAct) {
            jobDist[map.get(act)] = "C";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : jobDist) {
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            int nAct = scanner.nextInt();
            Activity[] acts = new Activity[nAct];
            for (int j = 0; j < nAct; j++) {
                Activity act = new Activity();
                act.start = scanner.nextInt();
                act.end = scanner.nextInt();
                acts[j] = act;
            }
            System.out.printf("Case #%d: %s\n", i + 1, schedule3(acts));
        }
    }
}
