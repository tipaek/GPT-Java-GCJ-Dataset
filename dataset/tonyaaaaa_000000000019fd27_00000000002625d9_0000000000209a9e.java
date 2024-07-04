import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        int B = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int[] array = new int[B];
            Arrays.fill(array, -1);
            int[] equalIndex = new int[B / 10];
            int[] diffIndex = new int[B / 10];
            Arrays.fill(equalIndex, -1);
            Arrays.fill(diffIndex, -1);
            for (int i = 0; i < B / 2; i++) {
                System.out.println(i + 1);
                array[i] = scan.nextInt();
                int j = opposite(i, B);
                System.out.println(j + 1);
                array[j] = scan.nextInt();
                if (array[i] == array[j]) {
                    equalIndex[i / 5] = i;
                } else {
                    diffIndex[i / 5] = i;
                }
            }

            for (int i = 0; i < B / 10; i++) {
                if (equalIndex[i] == -1 || diffIndex[i] == -1) {
                    int index = equalIndex[i] == -1 ? diffIndex[i] : equalIndex[i];
                    System.out.println(index + 1);
                    int curr = scan.nextInt();
                    if (curr != array[index]) {
                        flip(array, i * 10, i * 10 + 5);
                    }
                } else {
                    System.out.println(equalIndex[i] + 1);
                    int e = scan.nextInt();
                    System.out.println(diffIndex[i] + 1);
                    int d = scan.nextInt();

                    boolean flip = e != array[equalIndex[i]];
                    boolean reverse = ((d == array[diffIndex[i]]) && flip) || ((d != array[diffIndex[i]] && !flip));

                    if (flip) flip(array, i * 10, i * 10 + 5);
                    if (reverse) reverse(array, i * 10, i * 10 + 5);

                }
            }
            Arrays.stream(array).forEach(System.out::print);

            System.out.println();
            if (scan.next().equals("N")) break;
        }
    }

    private static int opposite(int i, int l) {
        return l - i - 1;
    }

    private static void flip(int[] array, int from, int to) {
        for (int i = from; i < to; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
        for (int i = opposite(to, array.length) + 1; i < opposite(from, array.length) + 1; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    private static void reverse(int[] array, int from, int to) {
        for (int i = from; i < to; i++) {
            int tmp = array[i];
            array[i] = array[opposite(i, array.length)];
            array[opposite(i, array.length)] = tmp;
        }
    }
}
