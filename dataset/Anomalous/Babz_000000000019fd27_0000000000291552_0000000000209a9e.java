import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] myArray = new int[arrayLength];
            boolean testFailed = false;

            for (int i = 1; i <= 150; i++) {
                if (i % 10 == 1) {
                    System.out.println(IntStream.of(myArray)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining("")));
                    System.out.flush();

                    String response = scanner.next();
                    if ("Y".equals(response)) {
                        break;
                    } else {
                        testFailed = true;
                        break;
                    }
                }

                System.out.println(i);
                System.out.flush();
                String received = scanner.next();
                if ("N".equals(received)) {
                    break;
                } else {
                    myArray[i - 1] = Integer.parseInt(received);
                }
            }

            if (testFailed) {
                break;
            }
        }
        scanner.close();
    }
}