import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    private static String join(Collection<?> objs, String delimiter) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0])
                                             .thenComparingInt(interval -> interval[1]));

            StringBuilder result = new StringBuilder();
            int jEnd = 0, cEnd = 0;
            for (int[] interval : intervals) {
                if (cEnd <= interval[0]) {
                    result.append('C');
                    cEnd = interval[1];
                } else if (jEnd <= interval[0]) {
                    result.append('J');
                    jEnd = interval[1];
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s%n", t, result.toString());
        }
        scanner.close();
    }
}