import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) throws Exception {
        String fileName = "read_p.txt";
        Scanner in = new Scanner(System.in );
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream(fileName));
//        PrintStream o = new PrintStream(new FileOutputStream(fileName + ".out"));
        PrintStream o = new PrintStream(System.out);
//        Scanner in = new Scanner(System.in.available() > 0 ? System.in : new FileInputStream("resource/gcj2020/qr/read_p.txt"));
        int cases = in.nextInt();
        for (int i = 0; i<cases; i++ ) {
            o.println(solve(in, i));
        }
        in.close();



        o.close();
    }

    private static String solve(Scanner in, int cc) {
        int n = in.nextInt();
        Activity[] activities = new Activity[n];
        Activity lastJ = null;
        Activity lastC = null;
        for (int i = 0; i<n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            activities[i] = new Activity(start, end, i);
        }
        Arrays.sort(activities);
        for (int i = 0; i<n; i++) {
            if (lastJ == null) {
                lastJ = activities[i];
                activities[i].parent = "J";
            } else {
                if (activities[i].start >= lastJ.end && (lastC == null || lastC.end > activities[i].start) ) {
                    lastJ = activities[i];
                    activities[i].parent = "J";
                } else {
                    if (lastC == null) {
                        lastC = activities[i];
                        activities[i].parent = "C";
                    } else {
                        if (activities[i].start  >=  lastJ.end) {
                            lastJ = activities[i];
                            activities[i].parent = "J";
                        } else {
                            if (  lastC.end <= activities[i].start) {
                                lastC = activities[i];
                                activities[i].parent = "C";
                            } else {
                                return "Case #" + (cc + 1) + ": IMPOSSIBLE";
                            }
                        }
                    }
                }
            }
        }
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if (o1.order>o2.order) {
                    return 1;
                }
                if (o1.order<o2.order) {
                    return -1;
                }
                return 0;            }
        });
        String result = Arrays.stream(activities).map(o -> o.parent).collect(Collectors.joining());
        return "Case #" + (cc+1) +": " + result;
    }

    static class Activity implements Comparable<Activity>{
        final int start;
        final int end;
        final int order;

        String parent;

        Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }

        @Override
        public int compareTo(Activity o) {
            if (o.start>this.start) {
                return -1;
            }
            if (o.start<this.start) {
                return 1;
            }
            return 0;
        }
    }
}
