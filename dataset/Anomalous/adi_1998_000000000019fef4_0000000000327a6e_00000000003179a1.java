import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int[][] frequency = new int[11][26];
            String[] tenDigits = new String[500];
            int tenCount = 0;
            int u = sc.nextInt();

            for (int i = 1; i <= 10000; i++) {
                String n1 = sc.next();
                String s = sc.next();

                if (n1.length() == 1) {
                    int n = Integer.parseInt(n1);
                    frequency[n][s.charAt(0) - 'A']++;
                } else if (n1.equals("10")) {
                    tenDigits[tenCount] = s;
                    tenCount++;
                }
            }

            String result = "";

            for (int i = 1; i < 10; i++) {
                int max = frequency[i][0];
                int index = 0;

                for (int j = 1; j < 26; j++) {
                    if (frequency[i][j] > max) {
                        max = frequency[i][j];
                        index = j;
                    }
                }

                for (int j = 1; j < 10; j++) {
                    frequency[j][index] = 0;
                }

                result += (char) ('A' + index);
            }

            for (int i = 0; i < tenCount; i++) {
                if (tenDigits[i].length() > 1) {
                    result = tenDigits[i].charAt(1) + result;
                    break;
                }
            }

            System.out.println("Case #" + t1 + ": " + result);
        }
    }
}