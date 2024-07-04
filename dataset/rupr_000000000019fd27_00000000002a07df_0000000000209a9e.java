import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        boolean cont = true;
        for (int t = 0; t < T; t++) {
            if (cont) {
                cont = startRound(scanner, B, pw);
            } else {
                break;
            }
        }

        scanner.close();
        pw.close();
    }

    private static boolean startRound(Scanner scanner, int B, PrintWriter pw) {
        int[] bits = new int[B + 1];
        int index = 1;
        communicate(scanner, pw, bits, index);
        index++;

        for (int i = 2; i < 32; i++) {
            communicate(scanner, pw, bits, index);
        }

        communicate(scanner, pw, bits, B);

        for (int i = 33; i <= 41; i++) {
            if (index <= B) {
                communicate(scanner, pw, bits, index);
                //communicate(scanner, pw, bits, B - index + 1);
                index++;
            }
        }

        // if B was 10 then we must be done by now
        if (B == 10) {
            StringBuilder sb = new StringBuilder(B);
            for (int i = 1; i <= B; i++) {
                sb.append(bits[i]);
            }

            pw.println(sb.toString());
            pw.flush();
            return "Y".equals(scanner.nextLine());
        }

        for (int i = 42; i <= 71; i++) {
            communicate(scanner, pw, bits, index);
        }

        for (int i = 72; i <= 81; i++) {
            if (index <= B) {
                communicate(scanner, pw, bits, index);
                index++;
            }
        }

        if (B == 20) {
            StringBuilder sb = new StringBuilder(B);
            for (int i = 1; i <= B; i++) {
                sb.append(bits[i]);
            }

            pw.println(sb.toString());
            pw.flush();

            return "Y".equals(scanner.nextLine());
        }

        return false;

    }

    private static void communicate(Scanner scanner, PrintWriter pw, int[] bits, int index) {
        pw.println(index);
        pw.flush();
        bits[index] = Integer.parseInt(scanner.nextLine());
    }

}
