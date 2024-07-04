import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            String res = solve(arr);
            System.out.println("Case #" + t + ": " + res);
        }
        sc.close();
    }

    private static String solve(int[][] rawArr) {
        int N = rawArr.length;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new int[]{rawArr[i][0], rawArr[i][1], i});
        }
        arr.sort(Comparator.comparingInt(a -> a[0]));

        int cEnd = 0, jEnd = 0;
        char[] resArr = new char[N];
        for (int[] interval : arr) {
            int start = interval[0], end = interval[1], idx = interval[2];
            if (start < cEnd && start < jEnd) {
                return "IMPOSSIBLE";
            }
            if (start >= cEnd) {
                resArr[idx] = 'C';
                cEnd = end;
            } else {
                resArr[idx] = 'J';
                jEnd = end;
            }
        }
        return new String(resArr);
    }
}