import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();

            for (int t = 0; t < testCases; t++) {
                Set<String> arraySet = new HashSet<>();
                StringBuilder buffer = new StringBuilder();

                for (int j = 0; j < 150; j++) {
                    if (buffer.length() == bitLength) {
                        arraySet.add(buffer.toString());
                        buffer.setLength(0);
                    }
                    System.out.println((j % bitLength) + 1);
                    String response = scanner.next();
                    buffer.append(response);
                }

                boolean isCorrect = false;
                for (String array : arraySet) {
                    System.out.println(array);
                    String result = scanner.next();
                    if ("Y".equals(result)) {
                        isCorrect = true;
                        break;
                    }
                }
                if (isCorrect) {
                    break;
                }
            }
        }
    }
}