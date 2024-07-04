import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Solution {
    private static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    private static StreamTokenizer streamTokenizer;

    public static void main(String[] args) throws IOException {
        streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = nextInt();
        for (int i = 0; i < numTests; i++) {
            int activities = nextInt();
            List<int[]> activitiesList = new ArrayList<>();
            for(int m = 0; m < activities; m++) {
                int[] a = new int[2];
                a[0] = nextInt();
                a[1] = nextInt();
                activitiesList.add(a);
            }
            check(i + 1, activitiesList);
        }
    }

    private static void check(int caseNum, List<int[]> activitiesList) {
        StringBuilder res = new StringBuilder();
        TreeSet<int[]> cStart = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<int[]> cEnd = new TreeSet<>(Comparator.comparingInt(a -> a[1]));
        TreeSet<int[]> jStart = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<int[]> jEnd = new TreeSet<>(Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < activitiesList.size(); i++) {
            int[] invert = {activitiesList.get(i)[1], activitiesList.get(i)[0]};

            int[] floor = cStart.floor(invert);// start before my finish
            int[] ceil = cEnd.ceiling(activitiesList.get(i));// finish after my start

            if((floor == null && ceil == null) || (floor != null && floor[1] <= activitiesList.get(i)[0]) ||
                    (ceil != null && ceil[0] >= activitiesList.get(i)[1])){
                res.append("C");
                cStart.add(activitiesList.get(i));
                cEnd.add(activitiesList.get(i));
            } else {
                floor = jStart.floor(invert);// start before my finish
                ceil = jEnd.ceiling(activitiesList.get(i));// finish after my start
                if((floor == null && ceil == null) || (floor != null && floor[1] <= activitiesList.get(i)[0]) ||
                        (ceil != null && ceil[0] >= activitiesList.get(i)[1])){
                    res.append("J");
                    jStart.add(activitiesList.get(i));
                    jEnd.add(activitiesList.get(i));
                } else {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
        }

        System.out.println("Case #" + caseNum + ": " + res);

    }
}
