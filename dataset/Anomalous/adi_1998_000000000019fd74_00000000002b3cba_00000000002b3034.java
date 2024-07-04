import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            String[] ar = new String[n];
            int max = 0;
            String smax = "";

            for (int i = 0; i < n; i++) {
                ar[i] = sc.next();
                if (ar[i].length() > max) {
                    max = ar[i].length();
                    smax = ar[i].substring(1);
                }
            }

            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if (!smax.contains(ar[i].substring(1))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (t1 + 1) + ": " + smax);
            } else {
                System.out.println("Case #" + (t1 + 1) + ": *");
            }
        }
    }
}