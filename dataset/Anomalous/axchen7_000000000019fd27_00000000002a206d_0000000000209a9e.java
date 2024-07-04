import java.util.Scanner;

public class ESAbATAd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            boolean[] bits = new boolean[b];
            boolean[] match = new boolean[b / 2];

            // Read initial bits and determine matches
            for (int i = 0; i < b / 2; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 1;
                System.out.println(b - i);
                bits[b - i - 1] = scanner.nextInt() == 1;
                match[i] = bits[i] == bits[b - i - 1];
            }

            boolean[] complement = new boolean[b / 10];
            boolean[] reverse = new boolean[b / 10];

            // Determine complement and reverse operations
            for (int i = 0; i < b / 10; i++) {
                boolean allMatch = true;
                boolean allDifferent = true;
                int firstMatchIndex = -1;
                int firstDifferentIndex = -1;

                for (int j = 0; j < 5; j++) {
                    if (match[i * 5 + j]) {
                        allDifferent = false;
                        firstMatchIndex = j;
                    } else {
                        allMatch = false;
                        firstDifferentIndex = j;
                    }
                }

                if (allMatch || allDifferent) {
                    System.out.println(i * 5 + 1);
                    complement[i] = (scanner.nextInt() == 1) != bits[i * 5];
                    System.out.println(1);
                    scanner.nextInt();
                } else {
                    System.out.println(i * 5 + firstMatchIndex + 1);
                    complement[i] = (scanner.nextInt() == 1) != bits[i * 5 + firstMatchIndex];
                    System.out.println(i * 5 + firstDifferentIndex + 1);
                    reverse[i] = (scanner.nextInt() == 1) == bits[i * 5 + firstDifferentIndex] == complement[i];
                }
            }

            // Apply complement and reverse operations
            for (int i = 0; i < b / 10; i++) {
                if (complement[i]) {
                    for (int j = 0; j < 5; j++) {
                        int index = i * 5 + j;
                        bits[index] = !bits[index];
                        bits[b - index - 1] = !bits[b - index - 1];
                    }
                }
                if (reverse[i]) {
                    for (int j = 0; j < 5; j++) {
                        int index = i * 5 + j;
                        boolean temp = bits[index];
                        bits[index] = bits[b - index - 1];
                        bits[b - index - 1] = temp;
                    }
                }
            }

            // Print the final result
            StringBuilder result = new StringBuilder();
            for (boolean bit : bits) {
                result.append(bit ? '1' : '0');
            }
            System.out.println(result);

            // Check if the judge wants to stop
            if (scanner.next().equals("N")) {
                break;
            }
        }

        scanner.close();
    }
}