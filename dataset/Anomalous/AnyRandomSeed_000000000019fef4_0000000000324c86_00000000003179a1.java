import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(System.getProperty("user.dir") + "/src/sample.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            Solution instance = new Solution();
            sc.nextInt();
            String[] r = new String[10000];
            for (int j = 0; j < 10000; j++) {
                sc.nextInt();
                r[j] = sc.nextLine().trim();
            }
            System.out.println("Case #" + i + ": " + instance.solve(r));
        }
        sc.close();
    }

    private String solve(String[] r) {
        HashMap<Character, Long> frequencyMap = new HashMap<>();
        for (String s : r) {
            for (char ch : s.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0L) + 1);
            }
        }

        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            long minFrequency = Long.MAX_VALUE;
            char minChar = 0;
            for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {
                if (entry.getValue() < minFrequency) {
                    minFrequency = entry.getValue();
                    minChar = entry.getKey();
                }
            }
            result[i] = minChar;
            frequencyMap.remove(minChar);
        }
        return new String(result);
    }

    private long countDigitsInRangeAtDigit(long number, long d, int digit) {
        long entirePart = number / (d * 10);
        long remainder = (number / d) % 10;
        if (remainder == digit) {
            return entirePart * d + number % d + 1;
        } else if (remainder < digit) {
            return entirePart * d;
        } else {
            return (entirePart + 1) * d;
        }
    }

    private long countDigitsInRange(long number, int digit) {
        long d = 1;
        long sum = 0;
        while (number > 0) {
            sum += countDigitsInRangeAtDigit(number, d, digit);
            d *= 10;
            number /= 10;
        }
        return sum;
    }
}