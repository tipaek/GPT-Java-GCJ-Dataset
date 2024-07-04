import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = (int)Math.pow(10, 9);
        for (int t = 1; t <= t1; t++) {
            boolean isEnd = false;
            if (b == c - 5) {
                for (int i = 0; i <= 10; i++) {
                    if (!isEnd) {
                        for (int j = 0; j <= 10; j++) {
                            System.out.println((-5 + i) + " " + (-5 + j));
                            String str = in.next();
                            if (str.equals("CENTER")) {
                                isEnd = true;
                                break;
                            }
                        }
                    }
                }
            } else if (b == c - 50) {
                int x1 = -50;
                int x2 = 50;
                int y1 = -50;
                int y2 = 50;
                while ((x2 - x1) > 1 || (y2 - y1) > 1) {
                    System.out.println((-c + ((x1 + x2) / 2 - x1) / 2) + " " + (y1 + y2) / 2);
                    String str = in.next();
                    if (str.equals("HIT")) {
                        x2 -= ((x1 + x2) / 2 - x1) / 2;
                    } else {
                        x1 += (x2 - (x1 + x2) / 2) / 2;
                    }
                    System.out.println((c - (x2 - (x1 + x2) / 2) / 2) + " " + (y1 + y2) / 2);
                    str = in.next();
                    if (str.equals("HIT")) {
                        x1 += (x2 - (x1 + x2) / 2) / 2;
                    } else {
                        x2 -= ((x1 + x2) / 2 - x1) / 2;
                    }
                    System.out.println((x1 + x2) / 2 + " " + (-c + ((y1 + y2) / 2 - y1) / 2));
                    str = in.next();
                    if (str.equals("HIT")) {
                        y2 -= ((y1 + y2) / 2 - y1) / 2;
                    } else {
                        y1 += (y2 - (y1 + y2) / 2) / 2;
                    }
                    System.out.println((x1 + x2) / 2 + " " + (c - (y2 - (y1 + y2) / 2) / 2));
                    str = in.next();
                    if (str.equals("HIT")) {
                        y1 += (y2 - (y1 + y2) / 2) / 2;
                    } else {
                        y2 -= ((y1 + y2) / 2 - y1) / 2;
                    }
                }
                for (int i = x1; i <= x2; i++) {
                    if (!isEnd) {
                        for (int j = y1; j <= y2; j++) {
                            System.out.println(i + " " + j);
                            String str = in.next();
                            if (str.equals("CENTER")) {
                                isEnd = true;
                                break;
                            }
                        }
                    }
                }
            }

        }
    }
}