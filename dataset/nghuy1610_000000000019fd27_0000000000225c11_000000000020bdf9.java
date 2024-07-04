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

    static String shedule(Activity[] acts) {
        List<Integer> jAct = new ArrayList<>();
        List<Integer> cAct = new ArrayList<>();
        String[] jobDist = new String[acts.length];
        boolean[] isDist = new boolean[acts.length];
        for (int i = 0; i < acts.length; i++) {
            if (isDist[i]) {
                continue;
            }
            List<Integer> overlapIdx = new ArrayList<>();
            overlapIdx.add(i);
            for (int j = i + 1; j < acts.length; j++) {
                if (isDist[j]) {
                    continue;
                }
                if (isOverlap(acts[overlapIdx.get(0)],acts[j])) {
                    overlapIdx.add(j);
                }
            }
            for (int idx : overlapIdx) {
                if (!isOverlapWithActs(acts[idx], cAct, acts)) {
                    cAct.add(idx);
                } else if (!isOverlapWithActs(acts[idx], jAct, acts)) {
                    jAct.add(idx);
                } else {
                    return "IMPOSSIBLE";
                }
            }
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
