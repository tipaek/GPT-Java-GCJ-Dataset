import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static class Obj {
        int x, y, id;

        Obj(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static boolean overlap(Obj a, Obj b) {
        return b.x < a.y;
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int i = 1, cnt = 0;

            while (i <= n) {
                System.out.println(i);
                System.out.flush();
                int res = sc.nextInt();
                if (i % 10 == 1) {
                    a[i - 1] = -1;
                    cnt++;
                } else {
                    a[i - 1] = res;
                }
                i++;
            }

            int pos = 1;
            while (cnt > 0) {
                System.out.println(pos);
                System.out.flush();
                int res = sc.nextInt();
                if (i % 10 != 1) {
                    a[pos - 1] = res;
                    pos += 10;
                    cnt--;
                }
                i++;
            }

            StringBuilder ans = new StringBuilder();
            for (int x : a) {
                ans.append(x);
            }
            System.out.println(ans);
            System.out.flush();

            char o = sc.next().charAt(0);
            if (o == 'N') {
                return;
            }
        }

        out.flush();
        out.close();
    }
}