import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    private static int askbit(Scanner scanner, int num) {
        out("" + (num + 1));
        return scanner.nextInt();
    }

    static void out(String s) {
        System.out.println(s);
        System.out.flush();
    }

    private static int[] solve(Scanner input, int len) {

        int tries = 0;
        ArrayList<int[]> options = new ArrayList<>();

        int[] bits = init(len);
        options.add(bits);

        int pos = -1;

        while (options.size() == 1 && (pos = find(options.get(0))) >= 0) {
            tries += 1;
            int[] arr = options.get(0);
            int bit = askbit(input, pos);
            if ((tries % 10) == 1) {
                options = fluct(options, pos, bit);
            }
            arr[pos] = bit;

            if (tries > 150) {
                throw new RuntimeException();
            }
        }

        return bits;
    }

    private static int find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private static ArrayList<int[]> fluct(
            ArrayList<int[]> options,
            int pos,
            int bit) {

        ArrayList<int[]> newoptions = new ArrayList<>();
        for (int[] a : options) {
            int[] r = reversed(a);
            int[] c = complementary(a);
            int[] rc = reversed(complementary(a));

            if (a[pos] >= 0 && a[pos] != bit) {
                continue;
            }

            a[pos] = bit;

            if (r[pos] == bit) {
                newoptions.add(r);
            }
            if (c[pos] == bit) {
                newoptions.add(c);
            }
            if (rc[pos] == bit) {
                newoptions.add(rc);
            }
            newoptions.add(a);
        }

        return newoptions;
    }

    private static int[] complementary(int[] a) {
        int[] reversed = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case 0:
                    reversed[i] = 1;
                    break;
                case 1:
                    reversed[i] = 0;
                    break;
                default:
                    reversed[i] = a[i];
            }
        }
        return reversed;
    }

    private static int[] reversed(int[] a) {
        int[] reversed = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            reversed[i] = a[a.length - i - 1];
        }
        return reversed;
    }

    private static boolean known(int[] ints) {
        for (int i : ints) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] init(int len) {
        int[] a = new int[len];
        Arrays.fill(a, -1);
        return a;
    }

    public static void main(String args[]) throws Exception {
        Scanner input = scanner();
        int testCases = input.nextInt();
        int bitsLen = input.nextInt();
        for (int ks = 1; ks <= testCases; ks++) {
            int[] answer = solve(input, bitsLen);
            boolean res = output_answer_end_get(input, answer);
            if (!res) {
                System.exit(77);
            }
        }
    }

    private static Scanner scanner() throws FileNotFoundException {
        return new Scanner(System.in);
    }

    private static boolean output_answer_end_get(Scanner input, int[] answer) throws InterruptedException, IOException {
        StringBuilder builder = new StringBuilder();
        for (int value : answer) {
            builder.append(value);
        }
        out(builder.toString());

        String got = input.next("(Y|N)");
        return "Y".equals(got.trim());
    }
}
