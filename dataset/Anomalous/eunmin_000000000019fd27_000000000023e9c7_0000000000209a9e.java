import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            StringBuilder currentBuffer = new StringBuilder();
            Set<String> uniqueArrays = new HashSet<>();

            for (int query = 0; query < 150; ++query) {
                if (currentBuffer.length() == bitLength) {
                    uniqueArrays.add(currentBuffer.toString());
                    if (uniqueArrays.size() > 2) break;
                    currentBuffer.setLength(0); // Reset the buffer
                }

                System.out.println((query % bitLength) + 1);
                String response = scanner.next();
                currentBuffer.append(response);
            }

            boolean isCorrect = false;
            for (String array : uniqueArrays) {
                System.out.println(array);
                String result = scanner.next();
                if (result.equals("Y")) {
                    isCorrect = true;
                    break;
                } else {
                    System.exit(0);
                }
            }
        }
        System.exit(0);
    }
}