import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();

        for (int l = 0; l < t; l++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                if (i != 1) {
                    System.out.println(i);
                    System.out.flush();
                }
                arr[i] = in.nextInt();
            }

            System.out.println(1);
            System.out.flush();
            int one = in.nextInt();

            int[] temparr = new int[10];
            for (int i = 2; i < 10; i++) {
                System.out.println(i);
                System.out.flush();
                temparr[i] = in.nextInt();
            }

            int[] arrComp = new int[10];
            int[] arrRev = new int[10];
            int[] arrRevComp = new int[10];

            // Complement array
            for (int i = 2; i < 10; i++) {
                arrComp[i] = arr[i] == 1 ? 0 : 1;
            }

            // Reverse array
            arrRev = arr.clone();
            for (int i = 2; i <= 4; i++) {
                int temp = arrRev[i];
                arrRev[i] = arrRev[9 - i];
                arrRev[9 - i] = temp;
            }

            // Reverse and complement array
            arrRevComp = arrRev.clone();
            for (int i = 2; i < 10; i++) {
                arrRevComp[i] = arrRevComp[i] == 1 ? 0 : 1;
            }

            int matching = -1;

            // Check complement
            for (int i = 2; i < 10; i++) {
                if (temparr[i] == arrComp[i]) {
                    matching = 1;
                } else {
                    matching = 0;
                    break;
                }
            }

            if (matching == 1) {
                arr[1] = one == 1 ? 0 : 1;
                String ans = "";
                for (int i = 0; i < 10; i++) {
                    ans += arr[i];
                }
                System.out.println(ans);
                System.out.flush();
                String ch = in.next();
                if (ch.equals("Y")) {
                    continue;
                }
            }

            // Check reverse
            for (int i = 2; i <= 7; i++) {
                if (temparr[i] == arrRev[i]) {
                    matching = 1;
                } else {
                    matching = 0;
                    break;
                }
            }

            if (matching == 1) {
                arr[1] = temparr[8];
                String ans = "";
                for (int i = 0; i < 10; i++) {
                    ans += arr[i];
                }
                System.out.println(ans);
                System.out.flush();
                String ch = in.next();
                if (ch.equals("Y")) {
                    continue;
                }
            }

            // Check reverse complement
            for (int i = 2; i <= 7; i++) {
                if (temparr[i] == arrRevComp[i]) {
                    matching = 1;
                } else {
                    matching = 0;
                    break;
                }
            }

            if (matching == 1) {
                arr[1] = temparr[8] == 1 ? 0 : 1;
                String ans = "";
                for (int i = 0; i < 10; i++) {
                    ans += arr[i];
                }
                System.out.println(ans);
                System.out.flush();
                String ch = in.next();
                if (ch.equals("Y")) {
                    continue;
                }
            }

            if (l == t - 1) {
                return;
            }
        }
    }
}