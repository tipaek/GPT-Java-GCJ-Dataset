import java.util.Scanner;

class Solution {
    private static char[] ans;
    private static int i, j, r, c, t, b;
    private static char l;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        t = scanner.nextInt();
        b = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            ans = new char[b];
            Arrays.fill(ans, '1');
            resetIndices();

            for (i = 1, j = 0; j < (b + 1) / 2; i += 2) {
                if (i > 10 && i % 10 == 1) {
                    handleSpecialCase();
                } else {
                    handleNormalCase();
                }
            }

            System.out.print(String.valueOf(ans));
            System.out.flush();
            char response = scanner.next().charAt(0);
            if (response == 'N') {
                return;
            }
        }
    }

    private static void resetIndices() {
        r = -1;
        c = -1;
    }

    private static void complementArray(char[] array) {
        for (int i = 0; i < b; i++) {
            array[i] = array[i] == '0' ? '1' : '0';
        }
    }

    private static void reverseArray(char[] array) {
        for (int i = 0; i < b / 2; i++) {
            char temp = array[i];
            array[i] = array[b - i - 1];
            array[b - i - 1] = temp;
        }
    }

    private static void handleNormalCase() {
        System.out.println(j + 1);
        System.out.flush();
        ans[j] = scanner.next().charAt(0);

        System.out.println(b - j);
        System.out.flush();
        ans[b - 1 - j] = scanner.next().charAt(0);

        if (ans[j] == ans[b - 1 - j]) {
            c = j;
        } else {
            r = j;
        }
        j++;
    }

    private static void handleSpecialCase() {
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