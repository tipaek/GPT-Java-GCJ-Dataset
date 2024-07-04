import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int[][] ar = new int[11][26];
            int ct = 0;
            String[] ten = new String[500];
            int u = sc.nextInt();

            for (int i = 1; i <= 10000; i++) {
                int n = sc.nextInt();
                String s = sc.next();

                if (n < 10) {
                    ar[n][s.charAt(0) - 'A']++;
                } else if (n == 10) {
                    ten[ct] = s;
                    ct++;
                }
            }

            String res = "";

            for (int i = 1; i < 10; i++) {
                int max = ar[i][0];
                int in = 0;

                for (int j = 1; j < 26; j++) {
                    if (ar[i][j] > max) {
                        max = ar[i][j];
                        in = j;
                    }
                }

                for (int j = 1; j < 10; j++) {
                    ar[j][in] = 0;
                }

                res += (char) ('A' + in);
            }

            for (int i = 0; i < ct; i++) {
                if (ten[i].length() > 1) {
                    res = ten[i].charAt(1) + res;
                    break;
                }
            }

            System.out.println("Case #" + t1 + ": " + res);
        }

        sc.close();
    }
}