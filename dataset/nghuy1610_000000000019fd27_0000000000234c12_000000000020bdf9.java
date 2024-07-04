import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.InputStreamReader;

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

    static String shedule(Activity[] acts) {
        List<Integer> jAct = new ArrayList<>();
        List<Integer> cAct = new ArrayList<>();
        String[] jobDist = new String[acts.length];
        boolean[] isDist = new boolean[acts.length];
        String result = distribute(acts, 0, jAct, cAct);
        if (result == "IMPOSSIBLE") {
            return result;
        }
        for (int id : jAct) {
            jobDist[id] = "J";
        }
        for (int id : cAct) {
            jobDist[id] = "C";
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
            System.out.printf("Case #%d: %s\n", i + 1, shedule(acts));
        }
    }
}
