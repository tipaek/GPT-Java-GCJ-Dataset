import java.util.Scanner;

public class Solution {
    static int e, ne;
    static int[] a;
    public static void solve(Scanner input, int b) {
        e = -1; ne = -1;
        a = new int[b];
        int i = 1, pos = 0, bit = -1, bit2 = -1;
        boolean e_change = false, ne_change = false;
        while (i <= 150 && pos <= (b - 1) / 2) {
            if (i > 1 && i % 10 == 1) {
                if (e > -1) {
                    System.out.println(e + 1);
                    bit = input.nextInt();
                    e_change = a[e] != bit;
                    i++;
                }
                if (ne > -1) {
                    System.out.println(ne + 1);
                    bit = input.nextInt();
                    ne_change = a[ne] != bit;
                    i++;
                }

                if (e > -1 && ne == -1) {
                    if (e_change) comp(pos, b);
                } else if (e == -1 && ne > -1) {
                    if (ne_change) reverse(pos, b);
                } else {
                    if (e_change && ne_change) comp(pos, b);
                    else if (e_change && !ne_change) {comp(pos, b); reverse(pos, b);}
                    else if (!e_change && ne_change) reverse(pos, b);
                }
            } else {
                System.out.println(pos + 1); // query pair: i + 1 <-> b - i
                bit = input.nextInt();
                a[pos] = bit;
                System.out.println(b - pos);
                bit2 = input.nextInt();
                a[b - pos - 1] = bit2;

                if (bit == bit2) e = pos;
                else ne = pos;
                i += 2;
                pos++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int aa : a) sb.append(aa);
        System.out.println(sb.toString());
        if (input.next().equals("N")) throw new RuntimeException("test fail");
    }

    // reverse up to index k
    private static void reverse(int k, int b) {
        for (int i = 0; i < k; i++) {
            int temp = a[i];
            a[i] = a[b - i - 1];
            a[b - i - 1] = temp;
        }
    }

    // complement up to index k
    private static void comp(int k, int b) {
        for (int i = 0; i < k; i++) {
            toggle(i);
            toggle(b - i - 1);
        }
    }

    private static void toggle(int k) {
        if (a[k] == 1) a[k] = 0;
        else a[k] = 1;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            solve(input, B);
        }
    }
}