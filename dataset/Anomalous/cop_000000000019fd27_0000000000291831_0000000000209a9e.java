import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    enum Fluctuation {
        NONE,
        COMPLEMENTED {
            @Override
            public void apply(int[] arr, int part) {
                for (int i = 0, p = part * 10; i < 10; i++, p++) {
                    arr[p] = arr[p] == 0 ? 1 : 0;
                }
            }
        },
        REVERSED {
            @Override
            public void apply(int[] arr, int part) {
                for (int i = part * 10, j = i + 9; i < j; i++, j--) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        },
        BOTH {
            @Override
            public void apply(int[] arr, int part) {
                COMPLEMENTED.apply(arr, part);
                REVERSED.apply(arr, part);
            }
        };

        public void apply(int[] arr, int part) {}
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int bitLength = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < totalCases; i++) {
                int[] bitArray = new int[bitLength];

                for (int k = 0; k < bitLength; k++) {
                    System.out.println(k + 1);
                    bitArray[k] = scanner.nextInt();
                }

                scanner.nextLine();

                Fluctuation[] fluctuations = new Fluctuation[bitLength / 10];
                Arrays.fill(fluctuations, Fluctuation.NONE);

                process(scanner, bitArray, fluctuations, 0);
            }
        }
    }

    private static boolean process(Scanner scanner, int[] bitArray, Fluctuation[] fluctuations, int index) {
        if (index == fluctuations.length) {
            return false;
        }

        for (Fluctuation fluctuation : Fluctuation.values()) {
            for (int m = 0; m < fluctuations.length; m++) {
                fluctuations[m].apply(bitArray, m);
                System.out.println(Arrays.stream(bitArray).mapToObj(String::valueOf).collect(Collectors.joining()));
                String response = scanner.nextLine();

                if ("Y".equalsIgnoreCase(response)) {
                    return true;
                }
            }

            if (process(scanner, bitArray, fluctuations, index + 1)) {
                return true;
            }

            fluctuations[index] = fluctuation;
        }

        return false;
    }
}