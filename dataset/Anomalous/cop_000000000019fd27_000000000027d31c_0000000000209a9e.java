import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int arraySize = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            for (int i = 0; i < totalCases; i++) {
                int[] numbers = new int[arraySize];

                for (int index = 0; index < arraySize; index++) {
                    System.out.println(index + 1);
                    numbers[index] = scanner.nextInt();
                }

                String reversedNumbers = IntStream.range(0, numbers.length)
                                                  .mapToObj(j -> String.valueOf(numbers[numbers.length - j - 1]))
                                                  .collect(Collectors.joining());

                System.out.println(reversedNumbers);
                scanner.nextLine();  // Consume the newline character
                String response = scanner.nextLine();

                if (!"Y".equalsIgnoreCase(response)) {
                    break;
                }
            }
        }
    }
}