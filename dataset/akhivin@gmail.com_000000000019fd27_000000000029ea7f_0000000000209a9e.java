import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {


    private static int askbit(Scanner scanner, int num) {
        out("" + (num + 1));
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

            if (tries > 150) {
                throw new RuntimeException();
            }
        }

        return bits;
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

        char got = (char)System.in.read();
        return 'Y'== got;
    }
}
