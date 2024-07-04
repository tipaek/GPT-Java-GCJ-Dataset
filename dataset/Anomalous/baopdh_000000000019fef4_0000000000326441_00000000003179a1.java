import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int u = scanner.nextInt();

            Map<Character, Character> characterMapping = new HashMap<>();
            Set<Character> nonZeroCharacters = new HashSet<>();
            Queue<String> processingQueue = new LinkedList<>();

            for (int i = 0; i < 10000; i++) {
                String s1 = scanner.next();
                String s2 = scanner.next();

                nonZeroCharacters.add(s2.charAt(0));
                for (char c : s2.toCharArray()) {
                    characterMapping.putIfAbsent(c, '9');
                }

                if (s1.length() == s2.length()) {
                    char mappedChar = characterMapping.get(s2.charAt(0));

                    if (s1.charAt(0) < mappedChar) {
                        characterMapping.put(s2.charAt(0), s1.charAt(0));
                    }

                    if (s1.length() > 1) {
                        processingQueue.offer(s1);
                        processingQueue.offer(s2);
                    }
                }
            }

            while (!processingQueue.isEmpty()) {
                String s1 = processingQueue.poll();
                String s2 = processingQueue.poll();

                if (characterMapping.get(s2.charAt(0)) == s1.charAt(0)) {
                    s1 = s1.substring(1);
                    s2 = s2.substring(1);

                    char mappedChar = characterMapping.get(s2.charAt(0));

                    if (s1.charAt(0) < mappedChar) {
                        characterMapping.put(s2.charAt(0), s1.charAt(0));
                    }

                    if (s1.length() > 1) {
                        processingQueue.offer(s1);
                        processingQueue.offer(s2);
                    }
                }
            }

            char[] result = new char[10];
            characterMapping.forEach((key, value) -> result[value - '0'] = key);

            System.out.print("Case #" + caseNumber + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
        scanner.close();
    }
}