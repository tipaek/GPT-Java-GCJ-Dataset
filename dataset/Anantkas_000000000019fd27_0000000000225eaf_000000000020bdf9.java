import java.util.*;
import java.io.*;

public class Solution {

    private static Map<String, String> magic(String[] jbs) {
        String[] jobs = new String[jbs.length];

        for (int i = 0; i < jbs.length; i++) {
            jobs[i] = jbs[i];
        }

        Arrays.sort(jobs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[0]) -
                        Integer.parseInt(o2.split(" ")[0]);
            }
        });

        int endTimeC = -1, endTimeJ = -1;

        Map<String, String> map = new HashMap<String, String>();

        String prev = "";
        int dups = 0;
        for (String job : jobs) {
            if (job.equals(prev)) {
                dups++;
            }

            if (dups > 1) {
                return null;
            }

            int start = Integer.parseInt(job.split(" ")[0]);
            int end = Integer.parseInt(job.split(" ")[1]);

            if (dups == 1) {
                job = job + "#";
            }

            if (endTimeC <= start) {
                map.put(job, "C");
                endTimeC = end;
            } else if (endTimeJ <= start ) {
                map.put(job, "J");
                endTimeJ = end;
            } else {
                return null;
            }

            prev = job;
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();

            String[] jobs = new String[n];

            for (int j = 0; j < n; j++) {
                String str = in.nextLine();
                jobs[j] = str;
            }

            Map<String, String>  map = magic(jobs);
            String ans = "";
            if (map == null) ans = "IMPOSSIBLE";
            else {
                for (String job : jobs) {
                    if (map.containsKey(job)) {
                        ans += map.get(job);
                        map.remove(job);
                    } else {
                        job = job + "#";
                        ans += map.get(job);
                    }

                }
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }
}