import java.util.Scanner;
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a == b && a == 999999995) {
            for (int i = 1; i <= t; i++) {
                String ris = "";
                boolean ok = false;
                for (int x = -5; x <= 5 && !ok; x++) {
                    for (int y = -5; y <= 5 && !ok; y++) {
                        System.out.println(x + " " + y);
                        ris = sc.next();
                        if (ris.equals("CENTER")) ok = true;
                    }
                }
            }
        } else if ((a == b) && a == 999999950) {
            for (int i = 1; i <= t; i++) {
                String ris = "";
                boolean ok = false;
                int xS = 100;
                int xE = 0;
                int x = 0;
                int y = 0;
                int yS = 100;
                int yE = 0;
                int v = 1000000000;
                for (int k = 0; k < 5; k++) {
                        x = (xS - xE) / 2;
                        System.out.println((v - x) + " 0");
                        ris = sc.next();
                        if (ris.equals("HIT")) xE = x;
                        else xS = x;

                    }
                    for (int k = 0; k < 5; k++) {
                        y = (yS - yE) / 2;
                        System.out.println("0 " + (v - y));
                        ris = sc.next();
                        if (ris.equals("HIT")) yE = y;
                        else yS = y;

                    }
                    xE -= 50;
                    xS -= 50;
                    yE -= 50;
                    yS -= 50;
                    for (int xx = xE; xx <= xS && !ok; xx++) {
                        for (int yy = yE; yy <= yS && !ok; yy++) {
                            System.out.println(xx + " " + yy);
                            ris = sc.next();
                            if (ris.equals("CENTER")) ok = true;
                        }
                    }
                

            }
        }
    }
}