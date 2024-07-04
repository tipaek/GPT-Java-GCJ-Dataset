import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();

        for (long T = 1; T <= t; T++) {
            HashMap<Character, Integer> serverValues = new HashMap<>();
            HashMap<Character, Integer> valueZero = new HashMap<>();
            long U = scan.nextLong();

            for (long i = 0; i < 10000; i++) {
                long Q = scan.nextLong();
                if (Q == -1) continue;

                String value = scan.next();
                char alpha = value.charAt(0);

                for (char ch : value.toCharArray()) {
                    serverValues.putIfAbsent(ch, 9);
                    valueZero.putIfAbsent(ch, 0);
                }

                valueZero.put(alpha, -1);
                int newValue = (int) (Q / Math.pow(10, value.length() - 1));
                serverValues.put(alpha, Math.min(serverValues.get(alpha), newValue));
            }

            valueZero.forEach((key, val) -> {
                if (val == 0) {
                    serverValues.put(key, val);
                }
            });

            char[] result = new char[10];
            serverValues.forEach((key, val) -> result[val] = key);

            System.out.println("Case #" + T + ": " + new String(result));
        }
        scan.close();
    }
}