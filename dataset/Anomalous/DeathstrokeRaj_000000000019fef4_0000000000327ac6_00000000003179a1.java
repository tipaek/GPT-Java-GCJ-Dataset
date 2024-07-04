import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int T = 1; T <= t; T++) {
            int U = scan.nextInt();
            Map<Character, Integer> serverValues = new HashMap<>();
            Map<Character, Integer> valueZero = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                int Q = scan.nextInt();
                if (Q == -1) {
                    Q = (int) (Math.pow(10, U) - 1);
                }
                String value = scan.next();
                char alpha = value.charAt(0);

                for (char c : value.toCharArray()) {
                    serverValues.putIfAbsent(c, 9);
                    valueZero.putIfAbsent(c, 0);
                }

                valueZero.put(alpha, -1);
                int newValue = (int) (Q / Math.pow(10, value.length() - 1));
                serverValues.put(alpha, Math.min(serverValues.get(alpha), newValue));
            }

            valueZero.forEach((x, y) -> {
                if (y == 0) {
                    serverValues.put(x, y);
                }
            });

            char[] result = new char[10];
            serverValues.forEach((x, y) -> result[y] = x);

            System.out.println("Case #" + T + ": " + new String(result));
        }
    }
}