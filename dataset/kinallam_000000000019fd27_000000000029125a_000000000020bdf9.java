import java.util.*;

public class Solution {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m =0; m<testcases;m++) {
            int length = in.nextInt();
            int[][] nums = new int[length][2];

            for (int i=0; i< length; i++) {
                for (int j =0; j<2; j++) {
                    nums[i][j] = in.nextInt();
                }
            }

            getSchedule(nums, m+1);
        }

    }

    public static void getSchedule(int[][] nums, int t) {
        Integer jack = null;
        Integer cam  = null;
        String output = "";
        boolean isPrint = false;

        Arrays.sort(nums, (a,b) -> a[0] - b[0]);

        for (int[] a : nums) {
            if (jack == null) {
                jack = a[1];
                output = output + "J";
                continue;
            } else if (cam == null) {
                cam = a[1];
                output = output + "C";
                continue;
            } else if (jack <= a[0]) {
                jack = a[1];
                output = output + "J";
                continue;
            } else if (cam <= a[0]) {
                cam = a[1];
                output = output + "C";
                continue;
            } else {
                output = "IMPOSSIBLE";
                isPrint = true;
                System.out.println("Case #" + t + ": " + output);
                break;
            }
        }

        if (!isPrint) {
            System.out.println("Case #" + t + ": " + output);

        }


    }
}
