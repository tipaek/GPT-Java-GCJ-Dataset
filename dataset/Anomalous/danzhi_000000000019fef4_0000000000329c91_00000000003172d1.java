import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    // Constants for user directory and class name
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    // Join elements of a collection into a comma-separated string
    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Determine input source
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt(); // Number of slices
            int D = scanner.nextInt(); // Number of people
            long[] slices = new long[N];
            
            for (int i = 0; i < N; i++) {
                slices[i] = scanner.nextLong();
            }

            // Count occurrences of each slice size
            TreeMap<Long, Integer> sliceCountMap = new TreeMap<>();
            for (long slice : slices) {
                sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
            }

            int result = calculateResult(sliceCountMap, D);
            System.out.format("Case #%d: %d\n", t, result);
        }
        
        scanner.close();
    }

    // Calculate the result based on the slice count map and number of people
    private static int calculateResult(TreeMap<Long, Integer> sliceCountMap, int D) {
        if (D == 2) {
            for (int count : sliceCountMap.values()) {
                if (count >= 2) {
                    return 0;
                }
            }
            return 1;
        } else if (D == 3) {
            for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
                long sliceSize = entry.getKey();
                int count = entry.getValue();

                if (count >= 3) {
                    return 0;
                }
                
                if (count == 2) {
                    for (Long otherSliceSize : sliceCountMap.tailMap(sliceSize, false).keySet()) {
                        return 1;
                    }
                }
                
                if (sliceCountMap.containsKey(2 * sliceSize)) {
                    return 1;
                }
            }
            return 2;
        } else {
            return 0;
        }
    }
}