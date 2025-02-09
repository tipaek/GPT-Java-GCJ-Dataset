import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();

        for (int l = 0; l < t; l++) {
            int[] arr = new int[10];
            for (int i = 0; i <= 9; i++) {
                if (i != 1) {
                    System.out.println(i);
                    System.out.flush();
                    arr[i] = in.nextInt();
                }
            }
            System.out.println(1);
            System.out.flush();
            int one = in.nextInt();

            int[] temparr = new int[10];
            for (int i = 2; i <= 9; i++) {
                System.out.println(i);
                System.out.flush();
                temparr[i] = in.nextInt();
            }

            int[] arrComp = new int[10];
            for (int i = 2; i <= 9; i++) {
                arrComp[i] = arr[i] == 1 ? 0 : 1;
            }

            int[] arrRev = arr.clone();
            for (int i = 2; i <= 4; i++) {
                int temp = arrRev[i];
                arrRev[i] = arrRev[9 - i];
                arrRev[9 - i] = temp;
            }

            int[] arrRevComp = arrRev.clone();
            for (int i = 2; i <= 9; i++) {
                arrRevComp[i] = arrRevComp[i] == 1 ? 0 : 1;
            }

            if (checkMatching(temparr, arrComp)) {
                arr[1] = one == 1 ? 0 : 1;
                printResult(arr, in);
                continue;
            }

            if (checkMatching(temparr, arrRev)) {
                arr[1] = temparr[8];
                printResult(arr, in);
                continue;
            }

            if (checkMatching(temparr, arrRevComp)) {
                arr[1] = temparr[8] == 1 ? 0 : 1;
                printResult(arr, in);
                continue;
            }
        }
    }

    private static boolean checkMatching(int[] temparr, int[] arr) {
        for (int i = 2; i <= 7; i++) {
            if (temparr[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int[] arr, Scanner in) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            ans.append(arr[i]);
        }
        System.out.println(ans);
        System.out.flush();
        String ch = in.next();
        if (ch.equals("Y")) {
            return;
        }
    }
}