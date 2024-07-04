import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> charMap = new HashMap<>();
            int uniqueCount = 0;
            StringBuilder result = new StringBuilder("          ");
            scanner.nextLine(); // Consume the newline

            while (uniqueCount < 9) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    int N = Integer.parseInt(parts[0]);
                    String R = parts[1];
                    if (N <= (uniqueCount + 1) * 10 + 9 && R.length() == 2 && !charMap.containsKey(R.charAt(0))) {
                        charMap.put(R.charAt(0), uniqueCount + 1);
                        uniqueCount++;
                    }
                }
            }

            while (uniqueCount < 10) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String R = parts[1];
                    if (R.length() == 2 && !charMap.containsKey(R.charAt(1))) {
                        charMap.put(R.charAt(1), 0);
                        uniqueCount++;
                    }
                }
            }

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                result.setCharAt(entry.getValue(), entry.getKey());
            }

            System.out.println(result);
        }
    }
}