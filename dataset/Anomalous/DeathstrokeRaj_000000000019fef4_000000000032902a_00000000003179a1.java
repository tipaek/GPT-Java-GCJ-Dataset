import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();

        for (long t = 1; t <= testCases; t++) {
            HashMap<Character, Long> serverValues = new HashMap<>();
            HashMap<Character, Long> valueZero = new HashMap<>();
            long U = scanner.nextLong();

            for (long i = 0; i < 10000; i++) {
                long Q = scanner.nextLong();
                if (Q == -1) continue;
                
                String value = scanner.next();
                char alpha = value.charAt(0);

                for (char ch : value.toCharArray()) {
                    serverValues.putIfAbsent(ch, 9L);
                    valueZero.putIfAbsent(ch, 0L);
                }

                valueZero.put(alpha, -1L);
                long possibleValue = Q / (long) Math.pow(10, value.length() - 1);
                serverValues.put(alpha, Math.min(serverValues.get(alpha), possibleValue));
            }

            valueZero.forEach((ch, val) -> {
                if (val == 0) {
                    serverValues.put(ch, val);
                }
            });

            char[] result = new char[10];
            serverValues.forEach((ch, val) -> {
                result[val.intValue()] = ch;
            });

            System.out.println("Case #" + t + ": " + new String(result));
        }

        scanner.close();
    }
}