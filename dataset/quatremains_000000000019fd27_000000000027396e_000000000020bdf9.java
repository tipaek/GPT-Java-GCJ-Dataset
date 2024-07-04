import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            String RESULT = "";
            boolean isPossible = true;

            for (int i = 0; i < N; i++) { // inputs comes N times
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }

            RESULT += "C";
           for (int i = 1; i < N; i++) {
               boolean trigger = false; // if duplicated set true.
               for (int j = 0; j < i; j ++) {
                   if (RESULT.charAt(j) == 'C') {
                       trigger = isDuplicated(start[i], start[j], end[i], end[j]);
                   }
               }
               if (!trigger) {
                   RESULT+="C";
                   continue;
               }
               trigger = false;
               for (int j = 0; j < i; j ++) {
                   if (RESULT.charAt(j) == 'J') {
                       trigger = isDuplicated(start[i], start[j], end[i], end[j]);
                   }
               }
               if (!trigger) {
                   RESULT += "J";
                   continue;
               }
               else {
                   isPossible = false; break;
               }
            }

            if (!isPossible) RESULT = "IMPOSSIBLE";
            System.out.println("Case #"+testCase+": "+RESULT);
        }
    }
    private static boolean isDuplicated(int start1, int start2, int end1, int end2) {
        if (start1>=start2) {
            if (end2 <= start1)
                return false;
            else
                return true;
        }
        else if (end1<=end2) {
            if (start2 >= end1)
                return false;
            else
                return true;
        }
        else return true;
    }
}

