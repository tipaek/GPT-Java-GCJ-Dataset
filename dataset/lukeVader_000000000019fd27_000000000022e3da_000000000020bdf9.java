import java.util.*;

public class Solution {

    private static Scanner scn = new Scanner(System.in);

    private static int[][] arr;

    // C- 67 J- 74
    public static void main(String[] args) {
        int tcases = scn.nextInt();
        int tcpy = tcases;
        while (tcases-- > 0) {
            int tasks = scn.nextInt();
            arr = new int[tasks][4];
            for (int i = 0; i < tasks; i++) {
                arr[i][0] = scn.nextInt();
                arr[i][1] = scn.nextInt();
                arr[i][2] = i;
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] k1, int[] k2) {
                    Integer a = k1[0];
                    Integer b = k2[0];
                    return a.compareTo(b);
                }
            });
            int cend = 0;
            int jend = 0;
            int old = 0;
            for (int i = 0; i < tasks; i++) {
                if (cend > arr[i][0]) {
                    if (jend > arr[i][0]) {
                        System.out.printf("Case #%d: IMPOSSIBLE\n", tcpy-tcases);
                        old = 1;
                        break;
                    }
                }

                if (cend <= arr[i][0]) {
                    arr[i][3] = 67;
                    cend = arr[i][1];
                } else if (jend <= arr[i][0]) {
                    arr[i][3] = 74;
                    jend = arr[i][1];
                }
            }
            if (old == 0) {
                for (int i = 0; i < tasks; i++) {
                    Arrays.sort(arr, new Comparator<int[]>() {
                        public int compare(int[] k1, int[] k2) {
                            Integer a = k1[2];
                            Integer b = k2[2];
                            return a.compareTo(b);
                        }
                    });
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < tasks; i++) {
                    stringBuilder.append((char)arr[i][3]);
                }
                System.out.printf("Case #%d: %s\n",tcpy-tcases, stringBuilder.toString());
            }
        }
    }
}