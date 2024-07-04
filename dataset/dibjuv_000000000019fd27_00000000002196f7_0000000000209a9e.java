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
                    System.out.flush();
                    ans[i] = sc.nextInt();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
                System.out.flush();
                String ok = sc.next();
            } else if (B == 20) {
                int[] ans = new int[20];
                boolean[] same = new boolean[10];
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    System.out.flush();
                    ans[i] = sc.nextInt();
                    System.out.print(B - i);
                    System.out.flush();
                    ans[B - i - 1] = sc.nextInt();
                    if (ans[i] == ans[B - i - 1]) {
                        same[i] = true;
                    } else {
                        same[i] = false;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    System.out.flush();
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
                System.out.flush();
                String ok = sc.next();
            }
        }
    }

}
