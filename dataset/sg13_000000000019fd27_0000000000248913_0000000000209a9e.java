import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int B = scan.nextInt();

            if (B == 10) {
                int[] ar = new int[10];
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    ar[i] = scan.nextInt();
                }
                System.out.println(Arrays.toString(ar));
                scan.nextLine();
                if (scan.next().charAt(0) == 'Y') continue;
                else break;
            }

            else if (B == 20) {
                int [] ar1 = new int[20];
                int [] ar2 = new int[20];
                for (int i = 0; i < 5; i++) {
                    System.out.println(i+1);
                    ar1[i] = scan.nextInt();
                }
                for (int i = 19; i >= 15; i--) {
                    System.out.println(i+1);
                    ar1[i] = scan.nextInt();
                }

                boolean[] qf = {true, true, true, true};
                for (int i = 0; i < 5; i++) {
                    System.out.println(i+1);
                    ar2[i] = scan.nextInt();
                }
                for (int i = 0; i < 5; i++) {
                    if (ar2[i] == ar1[i]) qf[0] = false;
                    if (ar2[i] != ar1[19 - i]) qf[1] = false;
                    if (ar2[i] == ar1[19 - i]) qf[2] = false;
                    if (ar2[i] != ar1[i]) qf[3] = false;
                }
                for (int i = 5; i < 10; i++) {
                    System.out.println(i+1);
                    ar2[i] = scan.nextInt();
                }
                if (qf[0]) for (int i = 19; i >= 15; i++) ar2[i] = 1 - ar1[i];
                if (qf[1]) for (int i = 0; i < 5; i++) ar2[19 - i] = ar1[i];
                if (qf[2]) for (int i = 0; i < 5; i++) ar2[19 - i] = 1- ar1[i];
                if (qf[3]) for (int i = 19; i >= 15; i++) ar2[i] = ar1[i];
                
                qf = new boolean[]{true, true, true, true};
                for (int i = 0; i < 5; i++) {
                    System.out.println(i+1);
                    ar1[i] = scan.nextInt();
                }
                for (int i = 0; i < 5; i++) {
                    if (ar1[i] == ar2[i]) qf[0] = false;
                    if (ar1[i] != ar2[19 - i]) qf[1] = false;
                    if (ar1[i] == ar2[19 - i]) qf[2] = false;
                    if (ar1[i] != ar2[i]) qf[3] = false;
                }
                if (qf[0]) {
                    for (int i = 5; i < 10; i++)
                        ar1[i] = 1 - ar2[i];
                    for (int i = 15; i < 19; i++)
                        ar1[i] = 1 - ar2[i];
                    for (int i = 10; i < 15; i++) {
                        System.out.println(i+1);
                        ar1[i] = scan.nextInt();
                    }
                }
                if (qf[3]) {
                    for (int i = 5; i < 10; i++)
                        ar1[i] = ar2[i];
                    for (int i = 15; i < 19; i++)
                        ar1[i] = ar2[i];
                    for (int i = 10; i < 15; i++) {
                        System.out.println(i+1);
                        ar1[i] = scan.nextInt();
                    }
                }
                if (qf[1]) {
                    for (int i = 5; i < 10; i++) {
                        System.out.println(i + 1);
                        ar1[i] = scan.nextInt();
                    }
                    for (int i = 0; i < 10; i++) ar1[19 - i] = ar1[i];
                }
                if (qf[2]) {
                    for (int i = 5; i < 10; i++) {
                        System.out.println(i + 1);
                        ar1[i] = scan.nextInt();
                    }
                    for (int i = 0; i < 10; i++) ar1[19 - i] = ar1[i];
                }
                
                System.out.println(Arrays.toString(ar1));
                scan.nextLine();
                if (scan.next().charAt(0) == 'Y') continue;
                else break;
            }
        }
    }
}