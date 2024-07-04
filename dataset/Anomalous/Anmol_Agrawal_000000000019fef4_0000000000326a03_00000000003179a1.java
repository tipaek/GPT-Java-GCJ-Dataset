import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int U = scanner.nextInt();
            Map<Character, Character> characterMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                int A = scanner.nextInt();
                String S = scanner.next();

                if (characterMap.size() < 10) {
                    String number = Integer.toString(A);
                    for (int j = 0; j < number.length(); j++) {
                        characterMap.put(number.charAt(j), S.charAt(j));
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for (char i = '0'; i <= '9'; i++) {
                answer.append(characterMap.get(i));
            }

            System.out.println("Case #" + testCase + ": " + answer);
        }

        scanner.close();
    }
}