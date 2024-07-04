import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static char[] ans;
    static int i, j, r, c, t, b;
    static char l;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        t = scanner.nextInt();
        b = scanner.nextInt();
        for (int tim = 0; tim < t; tim++) {
            ans = new char[b];
            Arrays.fill(ans, '1');
            for (i = 1, j = 0, r = -1, c = -1; j < (b + 1) / 2; i += 2) {
                if (i > 10 && i % 10 == 1) {
                    performSpecialOperations();
                } else {
                    performStandardOperations();
                }
            }
            System.out.println(String.valueOf(ans));
            System.out.flush();
            char feedback = scanner.next().charAt(0);
            if (feedback == 'N') {
                return;
            }
        }
    }

    static void complementArray(char[] array) {
        for (int i = 0; i < b; i++) {
            array[i] = (array[i] == '0') ? '1' : '0';
        }
    }

    static void reverseArray(char[] array) {
        for (int i = 0; i < b / 2; i++) {
            char temp = array[i];
            array[i] = array[b - i - 1];
            array[b - i - 1] = temp;
        }
    }

    static void performStandardOperations() {
        System.out.println(j + 1);
        System.out.flush();
        if (j != b - j) {
            System.out.println(b - j);
            System.out.flush();
            ans[b - 1 - j] = scanner.next().charAt(0);
        }
        if (ans[j] == ans[b - 1 - j]) {
            c = j;
        } else {
            r = j;
        }
        j++;
    }

    static void performSpecialOperations() {
        if (c != -1) {
            System.out.println(c + 1);
            l = scanner.next().charAt(0);
            if (ans[c] != l) {
                complementArray(ans);
            }
        } else {
            System.out.println(1);
            l = scanner.next().charAt(0);
        }
        if (r != -1) {
            System.out.println(r + 1);
            l = scanner.next().charAt(0);
            if (ans[r] != l) {
                reverseArray(ans);
            }
        } else {
            System.out.println(1);
            l = scanner.next().charAt(0);
        }
        System.out.flush();
    }
}