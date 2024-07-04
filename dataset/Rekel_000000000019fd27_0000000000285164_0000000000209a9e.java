import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    static Scanner sc;
    static int T;
    static int B;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        B = sc.nextInt();
        sc.nextLine();

        for (int test = 1; test <= T; test++) {
            test(test);
            char succes = sc.next().charAt(0);
            if (succes == 'N') break;
        }
    }

    private static void test(int test) {
        BitSet b = new BitSet(B);

        for (int i = 1; i <= B; i++) {
            System.out.println(i);
            char getal = sc.next().charAt(0);
            b.set(i - 1, getal == '1');
        }

        StringBuilder S = new StringBuilder(B);
        for (int i = 0; i < B; i++)
            S.append(b.get(i) ? '1' : '0');
        System.out.println(S.toString());
    }
}