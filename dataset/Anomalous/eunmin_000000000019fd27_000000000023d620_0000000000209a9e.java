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

        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder buffer = new StringBuilder();
            Set<String> possibleArrays = new HashSet<>();

            for (int query = 0; query < 150; query++) {
                if (buffer.length() == bitLength) {
                    possibleArrays.add(buffer.toString());
                    buffer.setLength(0);
                }
                System.out.println((query % bitLength) + 1);
                String response = scanner.next();

                buffer.append(response);
            }

            boolean isCorrect = false;
            for (String array : possibleArrays) {
                System.out.println(array);
                String result = scanner.next();
                if (result.equals("Y")) {
                    isCorrect = true;
                    break;
                }
            }
            if (isCorrect) break;
        }
        System.exit(0);
    }
}