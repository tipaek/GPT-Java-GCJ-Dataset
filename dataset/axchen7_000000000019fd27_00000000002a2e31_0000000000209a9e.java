import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        for (int c = 1; c <= t; c++) {
            boolean[] a = new boolean[b];
            boolean[] match = new boolean[b / 2];
            for (int i = 0; i < b / 2; i++) {
                System.out.println(i + 1);
                a[i] = scanner.nextInt() == 1;
                System.out.println(b - i);
                a[b - i - 1] = scanner.nextInt() == 1;
                match[i] = a[i] == a[b - i - 1];
            }
            boolean[] comp = new boolean[b / 10];
            boolean[] rev = new boolean[b / 10];
            for (int i = 0; i < b / 10; i++) {
                boolean allMatch = true;
                boolean allDiff = true;
                int firstMatch = -1;
                int firstDiff = -1;
                for (int j = 0; j < 5; j++) {
                    if (match[i * 5 + j]) {
                        allDiff = false;
                        firstMatch = j;
                    } else {
                        allMatch = false;
                        firstDiff = j;
                    }
                }
                if (allMatch || allDiff) {
                    System.out.println(i * 5 + 1);
                    comp[i] = ((scanner.nextInt() == 1) != a[i * 5]);
                    System.out.println(1);
                    scanner.nextInt();
                } else {
                    System.out.print(i * 5 + firstMatch + 1);
                    comp[i] = ((scanner.nextInt() == 1) != a[i * 5 + firstMatch]);
                    System.out.print(i * 5 + firstDiff + 1);
                    rev[i] = ((scanner.nextInt() == 1) == a[i * 5 + firstDiff]) == comp[i];
                }
            }
        //     for (int i = 0; i < b / 10; i++) {
        //         if (comp[i]) {
        //             for (int j = 0; j < 5; j++) {
        //                 int ind = i * 5 + j;
        //                 a[ind] = !a[ind];
        //                 a[b - ind - 1] = !a[b - ind - 1];
        //             }
        //         }
        //         if (rev[i]) {
        //             for (int j = 0; j < 5; j++) {
        //                 int ind = i * 5 + j;
        //                 boolean temp = a[ind];
        //                 a[ind] = a[b - ind - 1];
        //                 a[b - ind - 1] = temp;
        //             }
        //         }
        //     }
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < b; i++) {
                if (a[i]) out.append('1');
                else out.append('0');
            }
            System.out.println(out);
            if (scanner.next().equals("N")) break;
        }
    }
}
