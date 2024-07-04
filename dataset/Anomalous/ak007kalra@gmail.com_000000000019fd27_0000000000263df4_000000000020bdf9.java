import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            outerLoop:
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] c = new int[1][2];
                int[][] x = new int[1][2];
                int[][] a = new int[n][2];
                
                for (int j = 0; j < n; j++) {
                    a[j][0] = input.nextInt();
                    a[j][1] = input.nextInt();
                }

                StringBuilder s = new StringBuilder("C");
                c[0][0] = a[0][0];
                c[0][1] = a[0][1];

                for (int j = 1; j < n; j++) {
                    if (a[j][0] > c[0][0]) {
                        if (a[j][0] < c[0][1]) {
                            if (a[j][0] < x[0][0]) {
                                if (a[j][1] <= x[0][0]) {
                                    s.append("J");
                                    x[0][0] = a[j][0];
                                    x[0][1] = a[j][1];
                                } else {
                                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                                    continue outerLoop;
                                }
                            } else {
                                if (a[j][0] > x[0][1]) {
                                    s.append("J");
                                    x[0][0] = a[j][0];
                                    x[0][1] = a[j][1];
                                } else {
                                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                                    continue outerLoop;
                                }
                            }
                        } else {
                            s.append("C");
                            c[0][0] = a[j][0];
                            c[0][1] = a[j][1];
                        }
                    } else {
                        if (a[j][1] < c[0][0]) {
                            s.append("C");
                            c[0][0] = a[j][0];
                            c[0][1] = a[j][1];
                        } else {
                            s.append("J");
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + s.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}