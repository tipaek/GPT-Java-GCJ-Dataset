import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static int[] a;
    private static int b;
    private static Scanner sc;
    private static int sameIndex, diffIndex;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        b = sc.nextInt();
        a = new int[b];
        out = new PrintWriter(System.out);

        for (int test = 1; test <= t; test++) {
            int count = 0;
            sameIndex = -1;
            diffIndex = -1;

            for (; count < 5; count++) {
                findPair(count);
            }

            findChange();

            while (count < b / 2) {
                int i = 0;
                for (; i < 4 && count < b / 2; i++, count++) {
                    findPair(count);
                }
                if (i != 4) continue;
                findChange();
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(a[i]);
            }
            out.println(result);
            out.flush();

            String response = sc.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }

        out.close();
        sc.close();
    }

    private static int query(int index) {
        out.println(index + 1);
        out.flush();
        return sc.nextInt();
    }

    private static void findPair(int index) {
        a[index] = query(index);
        a[b - index - 1] = query(b - index - 1);

        if (sameIndex == -1 && a[index] == a[b - index - 1]) {
            sameIndex = index;
        }

        if (diffIndex == -1 && a[index] != a[b - index - 1]) {
            diffIndex = index;
        }
    }

    private static void findChange() {
        boolean complement = false;
        if (sameIndex != -1 && a[sameIndex] != query(sameIndex)) {
            complement = true;
        }

        boolean reverse = complement;
        if (diffIndex != -1 && a[diffIndex] != query(diffIndex)) {
            reverse = !complement;
        }

        if (complement) {
            for (int i = 0; i < b; i++) {
                a[i] = a[i] == 0 ? 1 : 0;
            }
        }

        if (reverse) {
            for (int i = 0; i < b / 2; i++) {
                int temp = a[i];
                a[i] = a[b - i - 1];
                a[b - i - 1] = temp;
            }
        }
    }
}