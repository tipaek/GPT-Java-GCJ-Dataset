import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numInputs = scanner.nextInt();
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
                    int leadingDigit = Integer.parseInt(String.valueOf(input[0].charAt(0)));
                    charFrequency.put(firstChar, Math.min(charFrequency.getOrDefault(firstChar, 9), leadingDigit));
                }
            }

            List<Node> nodeList = new ArrayList<>();
            for (char ch : allChars) {
                nodeList.add(new Node(ch, charFrequency.getOrDefault(ch, 0)));
            }
            Collections.sort(nodeList);

            StringBuilder result = new StringBuilder();
            if (isRandom) {
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    result.append(nodeList.get(i).character);
                }
            } else {
                for (Node node : nodeList) {
                    result.append(node.character);
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
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