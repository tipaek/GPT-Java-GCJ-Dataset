import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int matrix;
        int k = 0, r = 0, c = 0;
        int value[][];
        int x = 1;
        while (x <= testcase) {
            matrix = sc.nextInt();
            value = new int[matrix][matrix];
            for (int i = 0; i < matrix; i++) {
                for (int j = 0; j < matrix; j++) {
                    int val = sc.nextInt();
                    value[i][j] = val;
                    if (i == j) {
                        k = k + val;
                    }
                }
            }
            int count = 1;
            int temp = 0;
            for (int i = 0; i < matrix; i++) {
                temp = value[i][0];
                for (int j = 1; j < matrix; j++) {
                    if (temp == value[i][j]) {
                        count += 1;
                    }
                    if (count > r) {
                        r = count;
                        temp = value[i][j];
                    }
                }
                count = 1;
            }
            if (r == 1) {
                r = 0;
            }

            for (int i = 0; i < matrix; i++) {
                temp = value[0][i];
                for (int j = 1; j < matrix; j++) {
                    if (temp == value[j][i]) {
                        count += 1;
                    }
                    if (count > c) {
                        c = count;
                        temp = value[j][i];
                    }
                }
                count = 1;
            }
            if(c == 1) {
                c = 0;
            }

            // System.out.println(Arrays.deepToString(value));
            System.out.println("Case #"+ x +": " + k + " " + r + " " + c);

            k = 0;
            r = 0;
            c = 0;
            x++;
        }
    }
}