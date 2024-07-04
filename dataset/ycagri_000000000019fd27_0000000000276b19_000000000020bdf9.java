import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mertyentur
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = s.nextInt();
            int[] times = new int[activityCount * 2];

            for (int j = 0; j < activityCount; j++) {
                times[j * 2] = s.nextInt();
                times[j * 2 + 1] = s.nextInt();
            }

            System.out.println(String.format(parseActivities(i, activityCount, times)));
        }
    }

    private static String parseActivities(int testCase, int activityCount, int[] times) {
        char[] result = new char[activityCount];
        for (int j = 0; j < activityCount; j++) {
            if (result[j] != 0) {
                continue;
            }

            List<Integer> overlapIndexes = new ArrayList<>();
            for (int k = j + 1; k < activityCount; k++) {
                if (isOverlapping(times, k, j)) {
                    overlapIndexes.add(k);
                }
            }

            result[j] = 'C';
            for (int k = 0; k < overlapIndexes.size(); k++) {
                int index = overlapIndexes.get(k);
                for (int l = k + 1; l < overlapIndexes.size(); l++) {
                    int o = overlapIndexes.get(l);
                    if (isOverlapping(times, index, o)) {
                        return String.format("Case #%d: IMPOSSIBLE", testCase);
                    }
                }
            }
            
            overlapIndexes.forEach((k) -> {
                result[k] = 'J';
            });
        }

        return String.format("Case #%d: %s", testCase, new String(result));
    }

    private static boolean isOverlapping(int[] arr, int i, int j) {
        return (arr[i * 2] >= arr[j * 2] && arr[i * 2] < arr[j * 2 + 1])
                || (arr[i * 2 + 1] > arr[j * 2] && arr[i * 2 + 1] <= arr[j * 2 + 1])
                || (arr[j * 2] >= arr[i * 2] && arr[j * 2] < arr[i * 2 + 1])
                || (arr[j * 2 + 1] > arr[i * 2] && arr[j * 2 + 1] <= arr[i * 2 + 1]);
    }
}
