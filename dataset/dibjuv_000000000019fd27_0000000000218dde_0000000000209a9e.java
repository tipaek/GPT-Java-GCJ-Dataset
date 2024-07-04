/*
 * Created by cravuri on 4/3/20
 */

import java.util.Scanner;

public class Solution {

    /*

    00 -> c:11,r:00,rc:11,n:00
    01 -> c:10,r:10,rc:01,n:01
    10 -> c:01,r:01,rc:10,n:10
    11 -> c:00,r:11,rc:00,n:11

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                int[] ans = new int[10];
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    ans[i] = sc.nextInt();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            } else if (B == 20) {
                int[] ans = new int[20];
                boolean[] same = new boolean[10];
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    ans[i] = sc.nextInt();
                    System.out.print(B - i);
                    ans[B - i - 1] = sc.nextInt();
                    if (ans[i] == ans[B - i - 1]) {
                        same[i] = true;
                    } else {
                        same[i] = false;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    ans[i] = sc.nextInt();
                }
                for (int i = 0; i < 10; i++) {
                    if (same[i]) {
                        ans[B - i - 1] = ans[i];
                    } else {
                        ans[B - i - 1] = 1 - ans[i];
                    }
                }
                for (int i = 0; i < 20; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            } else {
//                int[] testers = new int[2];
//                testers[0] = -1; // same
//                testers[1] = -1; // different
//                int[] ans = new int[B];
//                for (int i = 0; i < ans.length; i++) {
//                    ans[i] = -1;
//                }
//                boolean[] same = new boolean[B];
//                for (int i = 0; i < ans.length / 2; i++) {
//                    System.out.println(i + 1);
//                    ans[i] = sc.nextInt();
//                    System.out.print(B - i);
//                    ans[B - i - 1] = sc.nextInt();
//                    if (ans[i] == ans[B - i - 1]) {
//                        if (testers[0] == -1) {
//                            testers[0] = i;
//                        }
//                        same[i] = true;
//                        same[B - i - 1] = true;
//                    } else {
//                        if (testers[1] == -1) {
//                            testers[1] = i;
//                        }
//                        same[i] = false;
//                        same[B - i - 1] = false;
//                    }
//                }
            }
        }
    }

}
