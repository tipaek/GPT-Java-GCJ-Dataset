import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        String[] array = new String[arrayLength];

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            for (int i = 1; i <= 150; ++i) {
                System.out.println(i);
                System.out.flush();
                String response = scanner.next();

                if (!response.equals("N")) {
                    array[i - 1] = response;
                }

                if (i >= 10 && arrayLength <= 10) {
                    String result = Arrays.stream(array)
                                          .collect(Collectors.joining(""));
                    System.out.println(result);
                    System.out.flush();
                    String answer = scanner.next();

                    if (answer.equals("Y")) {
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}