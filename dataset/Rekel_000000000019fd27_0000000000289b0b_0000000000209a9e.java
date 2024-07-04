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
            if (B==10) testTien(test);
            else test(test);
            char succes = sc.next().charAt(0);
            if (succes == 'N') break;
        }
    }

    static BitSet bits;

    private static void testTien(int test){
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

    private static void test(int test) {
        bits = new BitSet(B);

        // EERSTE 10
        leesVijf(1, true);
        leesVijf(B - 5 + 1, true);

        // VOLGENDE 5
        leesVijf(6, true);
        BitSet check = leesVijf(1, false);

        int equalLeft = 0;
        int equalRight = 0;
        for (int i = 0; i < 5; i++) {
            if (check.get(i) == bits.get(i)) equalLeft++;
            if (check.get(i) == bits.get(B - i - 1)) equalRight++;
        }
        boolean nothing = equalLeft == 5;
        boolean reverse = equalRight == 5 || equalRight == 0;
        boolean complement = equalLeft == 0 || equalRight == 0;

        if (!nothing) {
            if (reverse) wisselVijf(0);
            if (complement) complementVijf(0);
        }

        leesVijf(B - 10 + 1, true);

        StringBuilder S = new StringBuilder(B);
        for (int i = 0; i < B; i++)
            S.append(bits.get(i) ? '1' : '0');
        System.out.println(S.toString());
    }

    private static void volgende(){

    }

    private static BitSet leesVijf(int index, boolean verander) {
        BitSet b = new BitSet(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(index + i);
            char getal = sc.next().charAt(0);
            b.set(i, getal == '1');
            if (verander) bits.set(index + i - 1, getal == '1');
        }
        return b;
    }

    private static void wisselVijf(int index) {
        BitSet temp = bits.get(index, index + 5);
        for (int i = 0; i < 5; i++) {
            bits.set(index + i, bits.get(B - index - i));
        }
        for (int i = 0; i < 5; i++) {
            bits.set(B - index - i, temp.get(i));
        }
    }

    private static void complementVijf(int index) {
        for (int i = 0; i < 5; i++) {
            bits.flip(index + i);
        }
        for (int i = 0; i < 5; i++) {
            bits.flip(B - index - i);
        }
    }
}