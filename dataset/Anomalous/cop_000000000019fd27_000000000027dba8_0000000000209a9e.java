import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int arrayLength = scanner.nextInt();
            scanner.nextLine();

            for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
                int[] numbers = new int[arrayLength];

                for (int i = 0; i < arrayLength; i++) {
                    System.out.println(i + 1);
                    numbers[i] = scanner.nextInt();
                }

                String concatenatedNumbers = Arrays.stream(numbers)
                                                   .mapToObj(String::valueOf)
                                                   .collect(Collectors.joining());
                System.out.println(concatenatedNumbers);
                scanner.nextLine();
                String response = scanner.nextLine();

                if (!"Y".equalsIgnoreCase(response)) {
                    break;
                }
            }
        }
    }
}