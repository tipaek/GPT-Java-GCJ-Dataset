import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CLASS_NAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RANDOM = new Random();

    private static String join(Collection<?> collection) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Object obj : collection) {
            if (!first) sb.append(',');
            sb.append(obj.toString());
            first = false;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CLASS_NAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int sliceCount = scanner.nextInt();
            int divisor = scanner.nextInt();
            long[] slices = new long[sliceCount];
            for (int i = 0; i < sliceCount; i++) {
                slices[i] = scanner.nextLong();
            }

            Arrays.sort(slices);
            TreeMap<Long, Integer> sliceMap = new TreeMap<>();
            for (long slice : slices) {
                sliceMap.put(slice, sliceMap.getOrDefault(slice, 0) + 1);
            }

            int result = calculateResult(divisor, sliceMap);
            System.out.format("Case #%d: %d\n", t, result);
        }
        scanner.close();
    }

    private static int calculateResult(int divisor, TreeMap<Long, Integer> sliceMap) {
        if (divisor == 2) {
            for (int count : sliceMap.values()) {
                if (count >= 2) {
                    return 0;
                }
            }
            return 1;
        } else if (divisor == 3) {
            int result = 2;
            for (Map.Entry<Long, Integer> entry : sliceMap.entrySet()) {
                long key = entry.getKey();
                int count = entry.getValue();
                if (count >= 3) {
                    return 0;
                }
                if (sliceMap.containsKey(2 * key)) {
                    result = 1;
                }
            }
            return result;
        }
        return 0;
    }
}