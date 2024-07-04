import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int u = input.nextInt();
            input.nextLine(); // Consume the newline character

            TreeSet<Character>[] numSets = new TreeSet[10];
            for (int k = 0; k < 10; k++) {
                numSets[k] = new TreeSet<>();
            }

            Set<Character> allCharacters = new HashSet<>();
            for (int k = 0; k < 10000; k++) {
                String[] line = input.nextLine().split(" ");
                String temp1 = line[0];
                String temp2 = line[1];

                for (char ch : temp2.toCharArray()) {
                    allCharacters.add(ch);
                }

                if (temp1.length() == temp2.length()) {
                    int firstDigit = Character.getNumericValue(temp1.charAt(0));
                    numSets[firstDigit].add(temp2.charAt(0));
                }
            }

            List<Character> resultChars = new ArrayList<>();
            for (int k = 1; k < 10; k++) {
                for (Character c : resultChars) {
                    numSets[k].remove(c);
                }
                if (!numSets[k].isEmpty()) {
                    resultChars.add(numSets[k].first());
                }
            }

            for (Character ch : allCharacters) {
                if (!resultChars.contains(ch)) {
                    resultChars.add(0, ch);
                    break;
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int k = 0; k < 10; k++) {
                answer.append(resultChars.get(k));
            }

            System.out.println("Case #" + (i + 1) + ": " + answer.toString());
        }
    }
}