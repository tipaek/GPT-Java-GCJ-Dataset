import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int tc = 0;

        while (++tc <= T) {
            int[] bits = new int[B];
            Arrays.fill(bits, -1);
            int q = 0;
            int p = 2;
            int done = 0;
            boolean check1Ready = false;
            boolean check2Ready = false;
            int check1 = -1;
            int check2 = -1;
            boolean reversed = false;
            boolean complemented = false;
            while (done < B) {
                if (q > 0 && q % 10 == 0) {
                    // check for fluctuation
                    System.out.println(check1);
                    int check1Resp = scanner.nextInt();
                    if (check1Resp != bits[check1 - 1]) {
                        complement(bits);
                    }
                    System.out.println(check2);
                    int check2Resp = scanner.nextInt();
                    if (check2Resp != bits[check2 - 1]) {
                        reverse(bits);
                    }
                    q += 2;
                }
                else {
                    if (done >= B - 2 && q % 10 != 0) {
                        // last checks
                        if (bits[0] < 0) {
                            System.out.println(1);
                            bits[0] = scanner.nextInt();
                            done++;
                            q++;
                        }
                        if (q % 10 != 0) {
                            System.out.println(B);
                            bits[B - 1] = scanner.nextInt();
                            done++;
                            q++;
                        }
                    }
                    
                    System.out.println(p);
                    int resp1 = scanner.nextInt();
                    bits[p - 1] = resp1;
                    q++;

                    if (q % 10 == 0) continue;

                    System.out.println(B - p + 1);
                    int resp2 = scanner.nextInt();
                    bits[B - p] = resp2;
                    done += 2;
                    q++;

                    if (!check1Ready) {
                        if (resp1 == resp2) {
                            check1Ready = true;
                            check1 = p;
                        }
                    }
                    if (!check2Ready) {
                        if (resp1 != resp2) {
                            check2Ready = true;
                            check2 = p;
                        }
                    }
                    p++;
                }
            }
            String res = "";
            for (int b: bits) res += b;
            System.out.println(res);
            scanner.nextLine();
            //String resp = scanner.nextLine();
            continue;
        }
    }

    public static void complement(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] >= 0) {
                bits[i] ^= 1;
            }
        }
    }

    public static void reverse(int[] bits) {
        int last = bits.length - 1;
        for (int i = 0; i <= (last >> 1); i++) {
            int temp = bits[i];
            bits[i] = bits[last - i];
            bits[last - i] = temp;
        }
    }
}