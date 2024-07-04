import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    public static void main (String[] args) {
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; ++i) {
            eachCase(i);
        }
    }

    static void eachCase(int i) {
        int frequency = 0;
        int[][] time = new int[24*60][2];
        boolean impossible = false;
        int n = scanner.nextInt();
        int[][] input_1 = new int[n][3];
        for (int j = 0; j < n; j++) {
            input_1[j][0] = scanner.nextInt();
            input_1[j][1] = scanner.nextInt();
            input_1[j][2] = frequency++;

        }
        Arrays.sort(input_1, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[][] UnformattedAnswer = new int[n][2];
        for (int j = 0; j < n; j++) {
            int start = input_1[j][0];
            int end = input_1[j][1];
            int number = input_1[j][2];
            boolean Cameron = true;
            boolean Jamie = true;

            for (int k = start; k < end; k++) {
                if (time[k][0] == 1) {
                    Cameron = false;
                }
            }


            if (Cameron) {
                for (int k = start; k < end; k++) {
                    time[k][0] = 1;
                }

                UnformattedAnswer[j] = new int[] {number, 1};
            } else {
                for (int k = start; k < end; k++) {
                    if (time[k][1] == 1) {
                        Jamie = false;
                    }
                }

                if (Jamie) {
                    for (int k = start; k < end; k++) {
                        time[k][1] = 1;
                    }
                    UnformattedAnswer[j] = new int[] {number, 2};
                } else {
                    impossible = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (impossible == true) {
            result = new StringBuilder("IMPOSSIBLE");
        } else {
            Arrays.sort(UnformattedAnswer, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

            for (int[] ints : UnformattedAnswer) {
                if (ints[1] == 1) {
                    result.append("C"); // Cameron
                } else if (ints[1] == 2) {
                    result.append("J"); // Jamie
                }
            }
        }

        System.out.println("Case #" + i + ": " + result);
    }
}