import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int lines = scanner.nextInt();
            scanner.nextLine();

            Set<Character> nonZeroChars = new HashSet<>();
            Set<Character> allChars = new HashSet<>();
            Map<Character, Integer> charFrequency = new HashMap<>();
            boolean isRandom = false;

            for (int i = 0; i < 10000; i++) {
                String[] input = scanner.nextLine().trim().split(" ");
                char firstChar = input[1].charAt(0);
                nonZeroChars.add(firstChar);

                if (allChars.size() < 10) {
                    for (char ch : input[1].toCharArray()) {
                        allChars.add(ch);
                    }
                }

                if ("-1".equals(input[0])) {
                    isRandom = true;
                    charFrequency.put(firstChar, charFrequency.getOrDefault(firstChar, 0) + 1);
                } else {
                    int firstDigit = Integer.parseInt(String.valueOf(input[0].charAt(0)));
                    charFrequency.putIfAbsent(firstChar, 9);
                    if (input[0].length() == input[1].length()) {
                        charFrequency.put(firstChar, Math.min(charFrequency.get(firstChar), firstDigit));
                    }
                }
            }

            List<Node> nodes = new ArrayList<>();
            for (char ch : allChars) {
                nodes.add(new Node(ch, charFrequency.getOrDefault(ch, 0)));
            }

            nodes.sort(Comparator.naturalOrder());
            StringBuilder result = new StringBuilder();

            if (isRandom) {
                result.append(nodes.get(0).c);
                for (int i = nodes.size() - 1; i > 0; i--) {
                    result.append(nodes.get(i).c);
                }
            } else {
                for (Node node : nodes) {
                    result.append(node.c);
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    private static class Node implements Comparable<Node> {
        private final char c;
        private final int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.count, other.count);
        }
    }
}