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
            System.exit(0);
        }
    }

}
