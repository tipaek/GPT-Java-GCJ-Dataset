import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bufferSize = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder buffer = new StringBuilder();
            int queryNumber = 1;

            for (int queryCount = 0; queryCount < 150; queryCount++) {
                if (queryCount % bufferSize == 0) {
                    System.out.println("1");
                    scanner.next(); // Read and discard the response
                } else {
                    System.out.println(queryNumber);
                    String response = scanner.next();
                    buffer.append(response);
                    queryNumber++;
                }

                if (buffer.length() == bufferSize) {
                    System.out.println(buffer.toString());
                    String result = scanner.next();
                    if ("Y".equals(result)) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
        System.exit(0);
    }
}