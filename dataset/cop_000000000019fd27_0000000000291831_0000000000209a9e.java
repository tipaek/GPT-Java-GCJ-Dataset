import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    enum Fluctuation {
        NONE,
        COMPLEMENTED {
            public void convert(int[] arr, int part) {
                for (int i = 0, p = part * 10; i < 10; i++, p++)
                    arr[p] = arr[p] == 0 ? 1 : 0;
            }
        },
        REVERSED {
            public void convert(int[] arr, int part) {
                for (int i = part * 10, j = i + 10 - 1; i < j; i++, j--) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        },
        BOTH {
            public void convert(int[] arr, int part) {
                COMPLEMENTED.convert(arr, part);
                REVERSED.convert(arr, part);
            }
        };

        public void convert(int[] arr, int part) {
        }
    }

    public static void main(String... args) throws IOException {
        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();
            int b = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < total; i++) {
                int[] arr = new int[b];

                for (int k = 0; k < b; k++) {
                    System.out.println(k + 1);
                    arr[k] = scan.nextInt();
                }

                scan.nextLine();

                Fluctuation[] parts = new Fluctuation[b / 10];
                Arrays.fill(parts, Fluctuation.NONE);

                foo(scan, arr, parts, 0);
            }
        }
    }

    private static boolean foo(Scanner scan, int[] arr, Fluctuation[] parts, int j) {
        if (j == parts.length)
            return false;

        for (int k = 0, total = Fluctuation.values().length; k < total; k++) {
            for (int m = 0; m < parts.length; m++) {
                parts[m].convert(arr, m);
                System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()));
                String res = scan.nextLine();

                if ("Y".equalsIgnoreCase(res))
                    return true;
            }

            if (foo(scan, arr, parts, j + 1))
                return true;

            if (parts[j] == Fluctuation.NONE)
                parts[j] = Fluctuation.COMPLEMENTED;
            else if (parts[j] == Fluctuation.COMPLEMENTED)
                parts[j] = Fluctuation.REVERSED;
            else if (parts[j] == Fluctuation.REVERSED)
                parts[j] = Fluctuation.BOTH;
            else
                parts[j] = Fluctuation.NONE;
        }

        return false;
    }

}
