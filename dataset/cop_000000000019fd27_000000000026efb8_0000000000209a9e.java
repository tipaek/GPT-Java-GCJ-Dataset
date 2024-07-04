import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    public static void main(String... args) throws IOException {
        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();
            int b = scan.nextInt();
            scan.nextLine();

            for (int i = 0, j = 1; i < total; i++) {
                StringBuilder buf = new StringBuilder(b);

                for (int k = 1, offs = b; k <= 150 && offs > 0; k++, j++) {
                    System.out.println(offs);
                    String bit = scan.nextLine();

                    if (j % 10 != 1) {
                        buf.append(bit);
                        offs--;
                    }
                }

                System.out.println(buf);
                System.out.flush();

                scan.nextLine();
            }
        }
    }

}
