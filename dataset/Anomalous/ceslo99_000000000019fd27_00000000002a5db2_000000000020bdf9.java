import java.util.*;
import java.io.*;

public class Solution {

    static Set<int[]> seen = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < 2; j++) {
                    arr[k][j] = in.nextInt();
                }
            }
            schedule(arr, i);
        }
    }

    public static int[] getArr(int[][] arr, int[][] sorted, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == sorted[k][0] && arr[i][1] == sorted[k][1] && !seen.contains(arr[i])) {
                seen.add(arr[i]);
                return arr[i];
            }
        }
        return arr[0];
    }

    public static void schedule(int[][] arr, int caseNum) {
        int[][] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr, Comparator.comparingInt(q -> q[0]));

        List<int[]> jJobs = new ArrayList<>();
        List<int[]> cJobs = new ArrayList<>();
        Map<int[], String> jobs = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        jJobs.add(new int[]{sortedArr[0][0], sortedArr[0][1]});
        int[] temp = getArr(arr, sortedArr, 0);
        jobs.put(temp, "J");

        int previousS = temp[0], previousE = temp[1];
        int s = 1, e = 1;

        for (int i = 1; i < sortedArr.length; i++) {
            if (previousS == sortedArr[i][0] && previousE == sortedArr[i][1]) {
                s++;
                e++;
                if (s > 2 && e > 2) {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    return;
                }
            } else {
                previousS = sortedArr[i][0];
                previousE = sortedArr[i][1];
                s = 1;
                e = 1;
            }

            if (cJobs.isEmpty()) {
                cJobs.add(new int[]{sortedArr[i][0], sortedArr[i][1]});
                temp = getArr(arr, sortedArr, i);
                jobs.put(temp, "C");
            } else if (overlap(sortedArr[i], jJobs) && overlap(sortedArr[i], cJobs)) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            } else if (overlap(sortedArr[i], jJobs)) {
                cJobs.add(new int[]{sortedArr[i][0], sortedArr[i][1]});
                temp = getArr(arr, sortedArr, i);
                jobs.put(temp, "C");
            } else {
                jJobs.add(new int[]{sortedArr[i][0], sortedArr[i][1]});
                temp = getArr(arr, sortedArr, i);
                jobs.put(temp, "J");
            }
        }

        for (int[] num : arr) {
            answer.append(jobs.get(num));
        }
        System.out.println("Case #" + caseNum + ": " + answer.toString());
    }

    private static boolean overlap(int[] job, List<int[]> jobs) {
        for (int[] j : jobs) {
            if (job[0] < j[1] && job[1] > j[0]) {
                return true;
            }
        }
        return false;
    }
}