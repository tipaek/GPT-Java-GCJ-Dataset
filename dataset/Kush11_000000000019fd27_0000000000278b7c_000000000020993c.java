import java.util.Arrays;
import java.util.Scanner;
class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int sum[] = new int[T], r[] = new int[T], c[] = new int[T];
        for (int x = 0; x < T; x++) {
            sum[x] = 0;
            c[x] = 0;
            r[x] = 0;
            int N = sc.nextInt();
            int n[][] = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int z = 0; z < N; z++) {
                    n[y][z] = sc.nextInt();
                    if (y == z) {
                        sum[x] = sum[x] + n[y][z];
                    }
                }
            }
            for (int y = 0; y < N; y++) {
                for (int z = 0; z < N; z++) {
                    int n1 = n[y][z];
                    int r1=0;
                    for (int z1 = z + 1; z1 < N; z1++) {
                        if (n1 == n[y][z1]) {
                            r[x]++;
                            r1++;
                            break;
                        }
                    }
                    if(r1>0)
                        break;
                }
            }
            for (int z = 0; z < N; z++) {
                for (int y = 0; y < N; y++) {
                    int n1 = n[y][z];
                    int c1=0;
                    for (int y1 = y + 1; y1 < N; y1++) {
                        if (n1 == n[y1][z]) {
                            c[x]++;
                            c1++;
                            break;
                        }
                    }
                    if(c1>0)
                        break;
                }
            }
        }
        for (int x = 0; x < T; x++) {
            System.out.println("Case #" + (x + 1) + ": " + sum[x] + " " + r[x] + " " + c[x]);
        }
    }
}
