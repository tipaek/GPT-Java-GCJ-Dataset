import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static boolean solve(Scanner sc, int n) {
        int[] bit = new int[n];
        int eq = -1, neq = -1;
        int left = 0, right = n - 1;
        int query = 0;
        while (left < right) {
            if ((query++) % 5 == 0) {
                if ((eq >= 0) && (neq >= 0)) {
                    System.out.println(eq + 1);
                    int biteq = sc.next().charAt(0) == '0' ? 0 : 1;
                    System.out.println(neq + 1);
                    int bitneq = sc.next().charAt(0) == '0' ? 0 : 1;
                    if ((biteq == bit[eq]) != (bitneq == bit[neq])) {
                        final int[] fbit = bit;
                        bit = IntStream.rangeClosed(1, n).map(i -> fbit[n - i]).toArray();
                    }
                    if (biteq != bit[eq]) {
                        bit = Arrays.stream(bit).map(i -> i ^ 1).toArray();
                    }
                    continue;
                } else if (eq >= 0) {
                    System.out.println(eq + 1);
                    sc.next();
                    System.out.println(eq + 1);
                    int biteq = sc.next().charAt(0) == '0' ? 0 : 1;
                    if (biteq != bit[eq]) {
                        bit = Arrays.stream(bit).map(i -> i ^ 1).toArray();
                    }
                    continue;
                } else if (neq >= 0) {
                    System.out.println(neq + 1);
                    sc.next();
                    System.out.println(neq + 1);
                    int bitneq = sc.next().charAt(0) == '0' ? 0 : 1;
                    if (bitneq != bit[neq]) {
                        bit = Arrays.stream(bit).map(i -> i ^ 1).toArray();
                    }
                    continue;
                }
            }
            System.out.println(left + 1);
            int bitleft = sc.next().charAt(0) == '0' ? 0 : 1;
            System.out.println(right + 1);
            int bitright = sc.next().charAt(0) == '0' ? 0 : 1;
            if (bitleft == bitright) {
                eq = (eq >= 0) ? eq : left;
            } else {
                neq = (neq >= 0) ? neq : left;
            }
            bit[left++] = bitleft;
            bit[right--] = bitright;
        }
        System.out.println(Arrays.stream(bit).mapToObj(String::valueOf).collect(Collectors.joining()));
        return sc.next().charAt(0) != 'N';
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(), b = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            if (!solve(sc, b)) {
                break;
            }
        }
    }
}
