import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            int lim = 24 * 60, f = 0;
            int a[][] = new int[n][2];
            List<Integer> list[] = new ArrayList[lim + 1];
            for (int i = 0; i <= lim; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int st = sc.nextInt();
                int end = sc.nextInt();
                a[i][0] = st;
                a[i][1] = end;
                for (int j = st; j <= end; j++) {
                    list[j].add(i);
                }
            }
            boolean vis[] = new boolean[n];
            char ch[] = new char[n];
            int p1 = 0, p2 = 0, p1lim = 0, p2lim = 0;
            for (int i = 0; i <= lim; i++) {
                if (f == 1) {
                    break;
                }
                if (i == p1lim) {
                    p1lim = 0;
                    p1 = 0;
                }
                if (i == p2lim) {
                    p2lim = 0;
                    p2 = 0;
                }
                for (int j : list[i]) {
                    if (!vis[j]) {
                        if ((p1 == 0 || p2 == 0) && a[j][0] == i) {
                            vis[j] = true;
                            if (p1 == 0) {
                                p1 = 1;
                                p1lim = a[j][1];
                                ch[j] = 'C';
                            } else {
                                p2 = 1;
                                p2lim = a[j][1];
                                ch[j] = 'J';
                            }
                        } else {
                            f = 1;
                            break;
                        }
                    }
                }
            }
            System.out.print("Case #" + z + ": ");
            if (f == 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(ch[i]);
                }
                System.out.println();
            }
        }
    }
}