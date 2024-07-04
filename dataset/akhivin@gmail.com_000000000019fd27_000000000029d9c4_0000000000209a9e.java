import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static final int[] BITS = new int[]{0, 0, 0, 1, 1, 0, 1, 1, 1, 1};
    static final boolean DEBUG = false;

    private static int askbit(Scanner scanner, int num) {
        if (DEBUG) {
            return BITS[num];
        }
        out("" + (num+1));
        return scanner.nextInt();
    }

    static final void out(String s) {
        System.out.print(s);
        System.out.flush();
    }


    public static int[] solve(Scanner input, int len) {

        int bitsRead = 0;
        int tries = 0;

        int[] bits = new int[len];

        while (bitsRead < len) {
            tries += 1;
            int bit = askbit(input, bitsRead);
            if ((tries % 10) == 1) {
                continue;
            }
            bits[bitsRead++] = bit;

            if (bitsRead>150) {
                throw new RuntimeException();
            }
        }

        return bits;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = scanner();
        int testCases = input.nextInt();
        int bitsLen = input.nextInt();
        for (int ks = 1; ks <= testCases; ks++) {
            int[] answer = solve(input, bitsLen);
            boolean res = output_answer_end_get(input, answer);
            if (!res) {
                return;
            }
        }
    }

    private static Scanner scanner() throws FileNotFoundException {
        if (DEBUG) {
            return new Scanner(new FileInputStream(new File("input.txt")));
        }

        return new Scanner(System.in);
    }

    private static boolean output_answer_end_get(Scanner input, int[] answer) {
        StringBuilder builder = new StringBuilder();
        for (int value : answer) {
            builder.append(value);
        }
        out(builder.toString());

        while (true) {
            String got = input.nextLine();
            if ("Y".equals(got.trim())) {
                return true;
            }
            if ("N".equals(got.trim())) {
                System.exit(9);
            }
        }
    }
}