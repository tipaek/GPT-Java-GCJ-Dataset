import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int t = 0; t < numberOfTest; t++) {
            // Input
            int N = sc.nextInt(); // the number of activities to assign

            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                activities.add(new Activity(i, sc.nextInt(), sc.nextInt()));
            }

            solve(activities, N, t + 1);
        }

        /*int N = 2;
        List<Activity> activities = new ArrayList<>();
        *//*activities.add(new Activity(1,360, 480));
        activities.add(new Activity(2,420, 540));
        activities.add(new Activity(3, 600, 660));*//*
        *//*activities.add(new Activity(1, 0, 1440));
        activities.add(new Activity(2, 1, 3));
        activities.add(new Activity(3, 2, 4));*//*
        *//*activities.add(new Activity(1, 99, 150));
        activities.add(new Activity(2, 1, 100));
        activities.add(new Activity(3, 100, 301));
        activities.add(new Activity(4, 2, 5));
        activities.add(new Activity(5, 150, 250));*//*
        *//*activities.add(new Activity(1, 0, 720));
        activities.add(new Activity(2, 720, 1440));*//*
        solve(activities, N);*/
    }

    private static void solve(List<Activity> activities, int N, int testLevel) {
        Collections.sort(activities);

        List<Activity> roots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Activity act = activities.get(i);
            if (roots.isEmpty()) {
                roots.add(act);
                continue;
            }

            boolean success = false;
            for (int j = 0; j < roots.size(); j++) {
                Activity root = roots.get(j);

                if (root.refActs.isEmpty()) {
                    if (root.canWorkWith(act)) {
                        root.attachWith(act);
                        success = true;
                        break;
                    } else {
                        // Do nothing
                    }
                } else {
                    if (root.refActs.get(root.refActs.size() - 1).canWorkWith(act)) {
                        root.attachWith(act);
                        success = true;
                    } else {
                        // Do nothing
                    }
                }

                /*if (root.canWorkWith(act)) {
                    // Clone this root to add this activity, then add this clone as new root
                    Activity cloneRoot = root.clone();
                    cloneRoot.attachWith(act);
                    roots.add(cloneRoot);
                    success = true;
                    break;
                }*/
            }

            if (!success) {
                // Add this activity as new root
                roots.add(act);
            }
        }

        if (roots.size() > 2) {
            System.out.println("Case #" + testLevel + ": IMPOSSIBLE");
        } else {
            roots.get(0).assignTo("C");
            if (roots.size() == 2) {
                roots.get(1).assignTo("J");
            }

            System.out.println("Case #" + testLevel + ": " + buildResultFromRoot(roots));
        }
    }

    private static String buildResultFromRoot(List<Activity> roots) {
        List<Activity> resList = new ArrayList<>();

        for (int i = 0; i < roots.size(); i++) {
            resList.add(roots.get(i));
            resList.addAll(roots.get(i).refActs);
        }

        resList.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return Integer.compare(o1.inputPos, o2.inputPos);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resList.size(); i++) {
            result.append(resList.get(i).belongTo);
        }
        return result.toString();
    }

    static class Activity implements Comparable<Activity>, Cloneable {
        int inputPos;
        int start;
        int end;
        List<Activity> refActs = new ArrayList<>();
        String belongTo = "";

        public Activity(int inputPos, int start, int end) {
            this.inputPos = inputPos;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }

        public boolean canWorkWith(Activity act) {
            return end <= act.start;
        }

        public void attachWith(Activity act) {
            refActs.add(act);
        }

        @Override
        protected Activity clone() {
            try {
                return (Activity) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Can't happen!");
            }
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public void assignTo(String name) {
            belongTo = name;
            for (int i = 0; i < refActs.size(); i++) {
                refActs.get(i).belongTo = name;
            }
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}