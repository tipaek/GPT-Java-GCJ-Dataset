import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
        static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        public static void main (String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i) 
            oneCase(i);
    }
    static void oneCase(int i)
    {
        int freq = 0;
        int[][] time = new int[24*60][2];
        boolean impossible = false;
        int n = sc.nextInt();
        int[][] ainput = new int[n][3];
        for (int j = 0; j < n; j++) {
            ainput[j][0] = sc.nextInt();
            ainput[j][1] = sc.nextInt();
            ainput[j][2] = freq++;

        }
        Arrays.sort(ainput, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[][] UnformattedAnswer = new int[n][2];
        for (int j = 0; j < n; j++) {
            int start = ainput[j][0];
            int end = ainput[j][1];
            int number = ainput[j][2];
            boolean C = true;
            boolean J = true;

            for (int k = start; k < end; k++) {
                if (time[k][0] == 1) {
                    C = false;
                }
            }


            if (C) {
                for (int k = start; k < end; k++) {
                    time[k][0] = 1;
                }

                UnformattedAnswer[j] = new int[] {number, 1};
            } else {
                for (int k = start; k < end; k++) {
                    if (time[k][1] == 1) {
                        J = false;
                    }
                }

                if (J) {
                    for (int k = start; k < end; k++) {
                        time[k][1] = 1;
                    }
                    UnformattedAnswer[j] = new int[] {number, 2};
                } else {
                    impossible = true;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        if (impossible) {
            answer = new StringBuilder("IMPOSSIBLE");
        } else {
            Arrays.sort(UnformattedAnswer, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

            for (int[] ints : UnformattedAnswer) {
                if (ints[1] == 1) {
                    answer.append("C");
                } else if (ints[1] == 2) {
                    answer.append("J");
                }
            }
        }

        System.out.println("Case #" + i + ": " + answer);
    }
}