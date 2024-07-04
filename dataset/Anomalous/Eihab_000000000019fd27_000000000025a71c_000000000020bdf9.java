import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer sc;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new StringTokenizer("");

        TaskD solver = new TaskD();
        solver.solve();

        br.close();
        out.close();
    }

    static class Activity {
        int id;
        char person;
        int start;
        int end;
    }

    static class TaskD {
        public void solve() throws IOException {
            int t = nxtInt();

            for (int ii = 0; ii < t; ii++) {
                int n = nxtInt();
                Activity[] acts = new Activity[n];
                List<Activity> actList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    acts[i] = new Activity();
                    acts[i].start = nxtInt();
                    acts[i].end = nxtInt();
                    acts[i].id = i;
                    actList.add(acts[i]);
                }

                sortActivitiesByStart(acts);

                List<Activity> timeline = new ArrayList<>();
                Activity firstAct = new Activity();
                firstAct.person = acts[0].person = 'C';
                firstAct.start = acts[0].start;
                firstAct.end = acts[0].end;
                firstAct.id = 1;
                timeline.add(firstAct);

                if (!assignActivities(timeline, acts, n)) {
                    out.println("Case #" + (ii + 1) + ": IMPOSSIBLE");
                    continue;
                }

                sortActivitiesById(acts);

                StringBuilder result = new StringBuilder();
                for (Activity act : acts) {
                    result.append(act.person);
                }
                out.println("Case #" + (ii + 1) + ": " + result);
            }
        }

        private void sortActivitiesByStart(Activity[] acts) {
            for (int i = 0; i < acts.length - 1; i++) {
                for (int j = i + 1; j < acts.length; j++) {
                    if (acts[i].start > acts[j].start) {
                        swapActivities(acts, i, j);
                    }
                }
            }
        }

        private void sortActivitiesById(Activity[] acts) {
            for (int i = 0; i < acts.length - 1; i++) {
                for (int j = i + 1; j < acts.length; j++) {
                    if (acts[i].id > acts[j].id) {
                        swapActivities(acts, i, j);
                    }
                }
            }
        }

        private void swapActivities(Activity[] acts, int i, int j) {
            Activity temp = acts[i];
            acts[i] = acts[j];
            acts[j] = temp;
        }

        private boolean assignActivities(List<Activity> timeline, Activity[] acts, int n) {
            List<Activity> newTimeline = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                boolean intersect = false;
                for (int j = 0; j < timeline.size(); j++) {
                    if (acts[i].start < timeline.get(j).end && acts[i].end > timeline.get(j).start) {
                        intersect = true;
                        if (timeline.get(j).id == 2) {
                            return false;
                        }

                        acts[i].person = (timeline.get(j).person == 'C') ? 'J' : 'C';

                        int[] times = {acts[i].start, acts[i].end, timeline.get(j).start, timeline.get(j).end};
                        sortTimes(times);

                        if (times[0] != times[1]) {
                            newTimeline.add(createActivity(times[0], times[1], 1, (acts[i].start > timeline.get(j).start) ? timeline.get(j).person : acts[i].person));
                        }

                        newTimeline.add(createActivity(times[1], times[2], 2, ' '));

                        if (times[2] != times[3]) {
                            newTimeline.add(createActivity(times[2], times[3], 1, (acts[i].end < timeline.get(j).end) ? timeline.get(j).person : acts[i].person));
                        }

                        timeline.remove(j);
                        j--;
                    }
                }

                if (intersect) {
                    timeline.addAll(newTimeline);
                    newTimeline.clear();
                } else {
                    timeline.add(createActivity(acts[i].start, acts[i].end, 1, acts[i].person = 'C'));
                }
            }
            return true;
        }

        private void sortTimes(int[] times) {
            for (int k = 0; k < times.length - 1; k++) {
                for (int l = k + 1; l < times.length; l++) {
                    if (times[k] > times[l]) {
                        int temp = times[k];
                        times[k] = times[l];
                        times[l] = temp;
                    }
                }
            }
        }

        private Activity createActivity(int start, int end, int id, char person) {
            Activity act = new Activity();
            act.start = start;
            act.end = end;
            act.id = id;
            act.person = person;
            return act;
        }

        class Trie {
            Node root;

            Trie() {
                root = new Node();
            }

            void add(long x) {
                Node cur = root;
                while (x > 0) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    cur.cnt[ls]++;
                    if (cur.nodes[ls] == null)
                        cur.nodes[ls] = new Node();
                    cur = cur.nodes[ls];
                }
            }

            void sub(long x) {
                Node cur = root;
                while (x > 0) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    cur.cnt[ls]--;
                    cur = cur.nodes[ls];
                }
            }

            long[] getcnt(long x) {
                int res = 0;
                int prev = 0;
                int depth = 0;
                Node cur = root;

                while (x > 0 && depth < 10) {
                    int ls = (int) (x % 10);
                    x /= 10;
                    res = cur.cnt[9 - ls];
                    if (res != 0) {
                        depth++;
                        prev = res;
                        cur = cur.nodes[9 - ls];
                    } else
                        break;
                }

                return new long[]{depth, prev};
            }
        }

        class Node {
            Node[] nodes;
            int[] cnt;

            Node() {
                nodes = new Node[10];
                cnt = new int[10];
            }
        }
    }

    static String nxtTok() throws IOException {
        while (!sc.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            sc = new StringTokenizer(s.trim());
        }
        return sc.nextToken();
    }

    static int nxtInt() throws IOException {
        return Integer.parseInt(nxtTok());
    }

    static long nxtLng() throws IOException {
        return Long.parseLong(nxtTok());
    }

    static double nxtDbl() throws IOException {
        return Double.parseDouble(nxtTok());
    }

    static int[] nxtIntArr(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nxtInt();
        }
        return a;
    }

    static long[] nxtLngArr(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nxtLng();
        }
        return a;
    }

    static char[] nxtCharArr() throws IOException {
        return nxtTok().toCharArray();
    }

    static int getMin(int[] arr, int count) {
        int min = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int getMax(int[] arr, int count) {
        int max = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void sortAsc(int[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void sortDesc(int[] arr, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}