import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int u = scanner.nextInt();
            Map<Character, Character> digitMap = new HashMap<>();
            Set<Character> nonZeroDigits = new HashSet<>();
            Queue<String[]> pairsQueue = new LinkedList<>();

            for (int i = 0; i < 10000; i++) {
                String s1 = scanner.next();
                String s2 = scanner.next();

                nonZeroDigits.add(s2.charAt(0));
                for (char c : s2.toCharArray()) {
                    digitMap.putIfAbsent(c, '9');
                }

                if (s1.length() == s2.length()) {
                    char mappedChar = digitMap.get(s2.charAt(0));

                    if (s1.charAt(0) < mappedChar) {
                        digitMap.put(s2.charAt(0), s1.charAt(0));
                    }

                    if (s1.length() > 1) {
                        pairsQueue.offer(new String[]{s1, s2});
                    }
                }
            }

            while (!pairsQueue.isEmpty()) {
                String[] pair = pairsQueue.poll();
                String s1 = pair[0];
                String s2 = pair[1];

                if (digitMap.get(s2.charAt(0)) == s1.charAt(0)) {
                    s1 = s1.substring(1);
                    s2 = s2.substring(1);

                    char mappedChar = digitMap.get(s2.charAt(0));

                    if (s1.charAt(0) < mappedChar) {
                        digitMap.put(s2.charAt(0), s1.charAt(0));
                    }

                    if (s1.length() > 1) {
                        pairsQueue.offer(new String[]{s1, s2});
                    }
                }
            }

            char[] result = new char[10];
            digitMap.forEach((key, value) -> {
                if (nonZeroDigits.contains(key)) {
                    result[value - '0'] = key;
                } else {
                    result[0] = key;
                }
            });

            System.out.print("Case #" + caseNumber + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
        scanner.close();
    }
}