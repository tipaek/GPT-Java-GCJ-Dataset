import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int c = 1; c <= t; c++) {
            boolean[] bits = new boolean[b];
            boolean[] matches = new boolean[b / 2];

            // Initial bit reading
            for (int i = 0; i < b / 2; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 1;
                System.out.println(b - i);
                bits[b - i - 1] = scanner.nextInt() == 1;
                matches[i] = bits[i] == bits[b - i - 1];
            }

            // Determine if we need to complement or reverse
            boolean[] complement = new boolean[b / 10];
            boolean[] reverse = new boolean[b / 10];
            for (int i = 0; i < b / 10; i++) {
                boolean allMatch = true;
                boolean allDiff = true;
                int firstMatch = -1;
                int firstDiff = -1;

                for (int j = 0; j < 5; j++) {
                    if (matches[i * 5 + j]) {
                        allDiff = false;
                        firstMatch = j;
                    } else {
                        allMatch = false;
                        firstDiff = j;
                    }
                }

                if (allMatch || allDiff) {
                    System.out.println(i * 5 + 1);
                    complement[i] = (scanner.nextInt() == 1) != bits[i * 5];
                    System.out.println(1);
                    scanner.nextInt();
                } else {
                    System.out.println(i * 5 + firstMatch + 1);
                    complement[i] = (scanner.nextInt() == 1) != bits[i * 5 + firstMatch];
                    System.out.println(i * 5 + firstDiff + 1);
                    reverse[i] = (scanner.nextInt() == 1) == bits[i * 5 + firstDiff] == complement[i];
                }
            }

            // Apply complement and reverse
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

            // Additional checks for b == 100
            if (b == 100) {
                boolean[] complement2 = new boolean[2];
                boolean[] reverse2 = new boolean[2];

                for (int i = 0; i < 2; i++) {
                    boolean allMatch = true;
                    boolean allDiff = true;
                    int firstMatch = -1;
                    int firstDiff = -1;

                    for (int j = 0; j < 25; j++) {
                        if (matches[i * 25 + j]) {
                            allDiff = false;
                            firstMatch = j;
                        } else {
                            allMatch = false;
                            firstDiff = j;
                        }
                    }

                    if (allMatch || allDiff) {
                        System.out.println(i * 25 + 1);
                        complement2[i] = (scanner.nextInt() == 1) != bits[i * 25];
                        System.out.println(1);
                        scanner.nextInt();
                    } else {
                        System.out.println(i * 25 + firstMatch + 1);
                        complement2[i] = (scanner.nextInt() == 1) != bits[i * 25 + firstMatch];
                        System.out.println(i * 25 + firstDiff + 1);
                        reverse2[i] = (scanner.nextInt() == 1) == bits[i * 25 + firstDiff] == complement2[i];
                    }
                }

                // Apply complement and reverse for b == 100
                for (int i = 0; i < 2; i++) {
                    if (complement2[i]) {
                        for (int j = 0; j < 25; j++) {
                            int index = i * 25 + j;
                            bits[index] = !bits[index];
                            bits[b - index - 1] = !bits[b - index - 1];
                        }
                    }
                    if (reverse2[i]) {
                        for (int j = 0; j < 25; j++) {
                            int index = i * 25 + j;
                            boolean temp = bits[index];
                            bits[index] = bits[b - index - 1];
                            bits[b - index - 1] = temp;
                        }
                    }
                }
            }

            // Output the final result
            StringBuilder result = new StringBuilder();
            for (boolean bit : bits) {
                result.append(bit ? '1' : '0');
            }
            System.out.println(result);

            // Check if we should continue
            if (scanner.next().equals("N")) break;
        }
    }
}