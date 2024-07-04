import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfLines = scanner.nextInt();
            scanner.nextLine();

            Set<Character> nonZeroCharacters = new HashSet<>();
            Set<Character> allCharacters = new HashSet<>();
            Map<Character, Integer> characterFrequency = new HashMap<>();
            boolean isRandom = false;

            for (int i = 0; i < 10; i++) {
                String[] input = scanner.nextLine().trim().split(" ");
                char firstChar = input[1].charAt(0);

                nonZeroCharacters.add(firstChar);
                if (allCharacters.size() < 10) {
                    for (char c : input[1].toCharArray()) {
                        allCharacters.add(c);
                    }
                }

                if (input[0].equals("-1")) {
                    isRandom = true;
                    characterFrequency.put(firstChar, characterFrequency.getOrDefault(firstChar, 0) + 1);
                } else {
                    characterFrequency.putIfAbsent(firstChar, 9);
                    if (input[0].length() == input[1].length()) {
                        int minFrequency = Math.min(characterFrequency.get(firstChar), Character.getNumericValue(input[0].charAt(0)));
                        characterFrequency.put(firstChar, minFrequency);
                    }
                }
            }

            List<Node> nodes = new ArrayList<>();
            for (char c : allCharacters) {
                nodes.add(new Node(c, characterFrequency.getOrDefault(c, 0)));
            }
            Collections.sort(nodes);

            StringBuilder result = new StringBuilder();
            if (isRandom) {
                for (int i = nodes.size() - 1; i >= 0; i--) {
                    result.append(nodes.get(i).character);
                }
            } else {
                for (Node node : nodes) {
                    result.append(node.character);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        scanner.close();
    }

    private static class Node implements Comparable<Node> {
        private char character;
        private int frequency;

        public Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }
}