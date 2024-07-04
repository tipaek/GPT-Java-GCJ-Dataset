import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        
        for (int t = 1; t <= tc; t++) {
            int n = scn.nextInt();
            Map<Integer, Activity> activities = new HashMap<>();
            
            for (int i = 1; i <= n; i++) {
                int start = scn.nextInt();
                int end = scn.nextInt();
                activities.put(i, new Activity(i, start, end));
            }
            
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    Activity a = activities.get(i);
                    Activity b = activities.get(j);
                    if ((a.end > b.start && a.start <= b.start) || 
                        (b.end > a.start && b.start <= a.start)) {
                        a.neighbors.add(b);
                        b.neighbors.add(a);
                    }
                }
            }
            
            if (isBipartite(activities, n)) {
                System.out.print("Case #" + t + ": ");
                for (int i = 1; i <= n; i++) {
                    System.out.print(activities.get(i).partner);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static class Activity {
        int id;
        int start;
        int end;
        List<Activity> neighbors;
        Character partner;

        Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
            this.neighbors = new ArrayList<>();
        }
    }

    private static class Assignment {
        Activity activity;
        Character partner;

        Assignment(Activity activity, Character partner) {
            this.activity = activity;
            this.partner = partner;
        }
    }

    public static boolean isBipartite(Map<Integer, Activity> activities, int n) {
        Queue<Assignment> queue = new LinkedList<>();
        Map<Integer, Character> assignedPartners = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (assignedPartners.containsKey(i)) continue;

            queue.add(new Assignment(activities.get(i), 'J'));

            while (!queue.isEmpty()) {
                Assignment current = queue.poll();
                Activity activity = current.activity;
                Character currentPartner = current.partner;

                if (!assignedPartners.containsKey(activity.id)) {
                    assignedPartners.put(activity.id, currentPartner);

                    for (Activity neighbor : activity.neighbors) {
                        if (!assignedPartners.containsKey(neighbor.id)) {
                            queue.add(new Assignment(neighbor, currentPartner == 'J' ? 'C' : 'J'));
                        }
                    }
                } else if (!assignedPartners.get(activity.id).equals(currentPartner)) {
                    return false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            activities.get(i).partner = assignedPartners.get(i);
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}