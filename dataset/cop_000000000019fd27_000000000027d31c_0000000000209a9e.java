import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

            for (int i = 0; i < total; i++) {
                int[] arr = new int[b];

                for (int k = 0, j = 1; k < b; j++) {
                    System.out.println(k + 1);
                    arr[k++] = scan.nextInt();
                }

                String str = IntStream.range(0, arr.length)
                                      .mapToObj(j -> String.valueOf(arr[arr.length - j - 1]))
                                      .collect(Collectors.joining());

                System.out.println(str);
                scan.nextLine();
                String res = scan.nextLine();

                if (!"Y".equalsIgnoreCase(res))
                    break;
            }
        }
    }

}
