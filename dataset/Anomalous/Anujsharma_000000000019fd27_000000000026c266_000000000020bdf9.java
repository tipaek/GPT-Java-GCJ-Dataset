import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int sq = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            char[] ch = new char[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }

            int c = 0, j = 0, summ = 0;

            for (int j1 = 0; j1 <= 1440; j1++) {
                if (c != 0) c--;
                if (j != 0) j--;

                for (int k = 0; k < n; k++) {
                    if (j1 == a[k]) {
                        if (c == 0) {
                            c = b[k] - a[k];
                            ch[k] = 'J';
                        } else if (j == 0) {
                            j = b[k] - a[k];
                            ch[k] = 'J';
                        } else {
                            System.out.println("Case #" + sq + ": IMPOSSIBLE");
                            summ = -1;
                            break;
                        }
                    }
                }
            }

            if (summ == 0) {
                String s = new String(ch);
                System.out.println("Case #" + sq + ": " + s);
            }
            sq++;
        }

        scanner.close();
    }
}