import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int arrayLength = scanner.nextInt();
            int[] array = new int[arrayLength];

            for (int testCase = 1; testCase <= testCases; ++testCase) {
                Arrays.fill(array, 0);
                boolean testFailed = false;

                for (int i = 1; i <= 150; ++i) {
                    if (i != 1 && i % 10 == 1) {
                        System.out.println(Arrays.stream(array)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining("")));
                        System.out.flush();
                        String response = scanner.next();
                        if (response.equals("Y")) {
                            break;
                        } else {
                            testFailed = true;
                            break;
                        }
                    }

                    System.out.println(i);
                    System.out.flush();
                    String received = scanner.next();
                    if (received.equals("N")) {
                        break;
                    } else {
                        array[i - 1] = Integer.parseInt(received);
                    }
                }

                if (testFailed) {
                    break;
                }
            }
        }
    }
}