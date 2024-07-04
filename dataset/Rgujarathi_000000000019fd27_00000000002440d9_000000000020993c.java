//package coadjam;

import java.util.Scanner;

 class CoadJam {

    public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            if(t<101&&t>0){
            int k[] = new int[t], r[] = new int[t];;
            int c[] = new int[t];
            int h, z = 0, l, m, n;
            while (t != 0) {
                h = 0;
                l = 0;
                m = 0;
                n = 0;
                int N = sc.nextInt();
                int a[][] = new int[N + 1][N + 1];
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        h = sc.nextInt();
                        if (h <= N && h > 0) {
                            a[i][j] = h;
                        } else {
                            System.out.println("try again!!");
                            System.exit(1);
                        }
                        if (i == j) {
                            c[z] += a[i][j];
                        }
                    }
                }
                for (int s = 1; s <= N; s++, n = 0, l = 0) {
                    for (int q = 1; q <= N; q++) {
                        m = a[s][q];
                        h = a[q][s];
                        for (int y = q + 1; y <= N; y++) {
                            if (m - a[s][y] == 0) {
                                l++;
                            }
                            if (h - a[y][s] == 0) {
                                n++;
                            }
                            if (l > 0 && n > 0) {
                                break;
                            }
                        }
                        if (l > 0 && n > 0) {
                            break;
                        }
                    }
                    if (l > 0) {
                        r[z] += 1;
                    }
                    if (n > 0) {
                        k[z] += 1;
                    }
                }
                t--;
                z++;
            }

            for (int a = 0; a < c.length; a++) {
                System.out.println("case#" + (a + 1) + " " + c[a] + " " + r[a] + " " + k[a]);
            }}else{
                System.out.println("test cases are less than 101 and greater than 0");
            }
        
    }

}