import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            int bufferSize = scanner.nextInt();

            for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
                StringBuilder buffer = new StringBuilder(bufferSize);

                for (int numberIndex = 1, remaining = bufferSize; numberIndex <= 150 && remaining > 0; numberIndex++) {
                    if (numberIndex % 10 == 1) {
                        continue;
                    }
                    buffer.append(scanner.nextInt());
                    remaining--;
                }

                System.out.println(buffer.toString());
                scanner.nextLine();
            }
        }
    }
}