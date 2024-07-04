import java.util.Scanner;

public class Solution {
    static String result;
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String res = "";
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];

            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            boolean safe = isSafe(1, arr, 0,"C");
            if (!safe) result="IMPOSSIBLE";
            res += "Case #" + t + ": " + result;
            if (t != T) res += "\n";
        }
        System.out.print(res);
    }

    private static boolean isSafe(int p, int[][] ar, int job,String com) {
        int start = ar[job][0];
        int end = ar[job][1];
        String tmp="";
        for (int i = com.length(); i < ar.length; i++) {
            ar[i][2]=0;
        }
        for (int[] ints : ar) {
            if (ints[2] == p && (start >= ints[0] && start < ints[1] || end > ints[0] && end <= ints[1])) {
                return false;
            }
        }
        ar[job][2] = p;
        if (job == ar.length - 1) {
            result = "";
            for (int[] a:ar){
                result+=(a[2]==1)?"C":"J";
            }
            return true;
        }
        return isSafe(1,ar.clone(),job+1,com+"C")||isSafe(2,ar.clone(),job+1,com+"J");

    }
}