import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];

            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
            }

            int[] c = new int[9999];
            int[] h = new int[9999];
            int x = 0, y = 0;
            StringBuilder str = new StringBuilder("C");

            for (int j = arr[0][0]; j < arr[0][1]; j++) {
                c[x++] = j;
            }

            boolean impossible = false;

            for (int j = 1; j < n; j++) {
                int inc = 0, inj = 0;

                for (int k = 0; k < c.length; k++) {
                    if (arr[j][0] == c[k] || arr[j][1] - 1 == c[k]) inc++;
                    if (arr[j][0] == h[k] || arr[j][1] - 1 == h[k]) inj++;
                }

                if (inc > 0 && inj == 0) {
                    str.append('J');
                    for (int l = arr[j][0]; l < arr[j][1]; l++) {
                        h[y++] = l;
                    }
                } else if (inc == 0 && inj > 0) {
                    str.append('C');
                    for (int l = arr[j][0]; l < arr[j][1]; l++) {
                        c[x++] = l;
                    }
                } else if (inc == 0 && inj == 0) {
                    str.append('C');
                    for (int l = arr[j][0]; l < arr[j][1]; l++) {
                        c[x++] = l;
                    }
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", ts++);
            } else {
                System.out.printf("Case #%d: %s%n", ts++, str.toString());
            }
        }
    }
}